package cn.heshw.businessproduct.domain.aggregate.spu;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.Entity;
import lombok.Builder;

@Builder
public class Spu implements Entity<String, Spu>, AggregateRoot {
  private String id;
  private String name;

  @Override
  public String identity() {
    return null;
  }

  @Override
  public boolean sameIdentityAs(Spu other) {
    return false;
  }
}