package cn.heshw.businessproduct.domain.aggregate.sku;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.Entity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;

@Builder
public class Sku implements Entity<String, Sku>, AggregateRoot {

  private String id;
  private String title;
  private String imageUrl;
  private BigDecimal price;
  private Date createTime;
  private Date lastUpdateTime;

  @Override
  public String identity() {
    return id;
  }

  @Override
  public boolean sameIdentityAs(Sku other) {
    return false;
  }
}