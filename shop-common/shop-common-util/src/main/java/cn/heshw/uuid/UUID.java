package cn.heshw.uuid;

import cn.heshw.constant.EntityIDPrefix;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.validation.constraints.NotNull;

public class UUID {

  // timestamp start from 2021-01-01 00:00:00
  private static final long START_TIMESTAMP = 1609430400;
  private static final int SERVER_ID_SHIFT = 22;
  private static final int TIMESTAMP_SHIFT = 12;
  private static final int MAX_TAIL_ID = 4096;

  private Long lastTimeSec;
  private Integer tailIncreaseId;
  private final Integer serverId;

  public UUID(int serverId) {
    this.serverId = serverId;
    lastTimeSec = currentTimeSec();
    tailIncreaseId = 0;
  }

  public synchronized String generateIdFor(EntityIDPrefix entityIDPrefix) {
    return generateIdFor(entityIDPrefix.getPrefix());
  }

  public synchronized String generateIdFor(String entityType) {
    long current = currentTimeSec();

    if (current != lastTimeSec) {
      lastTimeSec = current;
      tailIncreaseId = 0;
    } else {
      if (tailIncreaseId >= MAX_TAIL_ID) {
        waitForNextSec();
        lastTimeSec = currentTimeSec();
        tailIncreaseId = 0;
      }
    }
    return entityType + snowFlake();
  }

  private long snowFlake() {
//  64位数： 1正负，41位时间戳，10位当前服务器id，12位生成的随机数范围[0, 2^ 12 - 1]
    long res = 0;
    res = res | (lastTimeSec << TIMESTAMP_SHIFT);
    res = res | (serverId << SERVER_ID_SHIFT);
    res = res | (tailIncreaseId++);
//    System.out.println(Long.toBinaryString(res));
    return res;
  }

  private long currentTimeSec() {
    return (System.currentTimeMillis() - START_TIMESTAMP) / 1000;
  }

  private void waitForNextSec() {
    long currentSec = currentTimeSec();
    while (currentSec != lastTimeSec) {
      currentSec = currentTimeSec();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Set<String> set = new HashSet<>();
    UUID generator = new UUID(1);
    ExecutorService service = Executors.newFixedThreadPool(5, new ThreadFactory() {
      private int no = 0;

      @Override
      public Thread newThread(@NotNull Runnable r) {
        return new Thread(r, (no++) + "NO");
      }
    });
    for (int j = 0; j < 100; j++) {
      service.submit(() -> {
        for (int i = 0; i < 10; i++) {
          String id = generator.generateIdFor(Thread.currentThread().getName());
          if (set.contains(id)) {
            System.out.println(id);
          } else {
            set.add(id);
          }
        }
      });
    }
    service.shutdown();
    if (service.awaitTermination(360, TimeUnit.SECONDS)) {
      System.out.println(set.size());
    }
  }
}