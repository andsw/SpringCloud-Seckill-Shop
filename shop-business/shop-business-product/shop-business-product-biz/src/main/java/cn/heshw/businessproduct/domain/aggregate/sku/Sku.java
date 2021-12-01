package cn.heshw.businessproduct.domain.aggregate.sku;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.DefaultEntity;
import java.math.BigDecimal;
import java.util.Date;

public class Sku extends DefaultEntity implements AggregateRoot {

  private final String title;
  private final String imageUrl;
  private final BigDecimal price;
  private final Date createTime;
  private final Date lastUpdateTime;

  public Sku(SkuBuilder builder) {
    super(builder);
    this.title = builder.title;
    this.imageUrl = builder.imageUrl;
    this.price = builder.price;
    this.createTime = builder.createTime;
    this.lastUpdateTime = builder.lastUpdateTime;
  }

  public static class SkuBuilder extends Builder<SkuBuilder> {

    private String title;
    private String imageUrl;
    private BigDecimal price;
    private Date createTime;
    private Date lastUpdateTime;

    public SkuBuilder title(String val) {
      this.title = val;
      return this;
    }

    public SkuBuilder imageUrl(String val) {
      this.imageUrl = val;
      return this;
    }

    public SkuBuilder price(BigDecimal val) {
      this.price = val;
      return this;
    }

    public SkuBuilder createTime(Date val) {
      this.createTime = val;
      return this;
    }

    public SkuBuilder lastUpdateTime(Date val) {
      this.lastUpdateTime = val;
      return this;
    }

    public Sku build() {
      return new Sku(this);
    }
  }
}