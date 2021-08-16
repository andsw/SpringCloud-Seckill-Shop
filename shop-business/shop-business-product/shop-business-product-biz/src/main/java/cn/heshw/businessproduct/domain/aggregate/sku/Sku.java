package cn.heshw.businessproduct.domain.aggregate.sku;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.Entity;
import lombok.Builder;

@Builder
public class Sku implements Entity<String, Sku>, AggregateRoot {

  private String id;
  private String name;

  @Override
  public String identity() {
    return id;
  }

  @Override
  public boolean sameIdentityAs(Sku other) {
    return false;
  }
}