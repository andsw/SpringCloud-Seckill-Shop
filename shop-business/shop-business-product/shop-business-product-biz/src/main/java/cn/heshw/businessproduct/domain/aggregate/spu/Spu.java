package cn.heshw.businessproduct.domain.aggregate.spu;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.DefaultEntity;
import java.util.Date;
import lombok.Builder;

@Builder
public class Spu extends DefaultEntity implements AggregateRoot {
  private String title;
  private String subTitle;
  private String cid1;
  private String cid2;
  private String cid3;
  private Brand brand;
  private SpuDetail detail;
  private Boolean onSale;
  private Boolean valid;
  private Date createTime;
  private Date lastUpdateTime;
}