package cn.heshw.businessproduct.domain.aggregate.spu;

import cn.heshw.ddd.AggregateRoot;
import cn.heshw.ddd.DefaultEntity;
import java.util.Date;
import lombok.Builder;

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

  public Spu(SpuBuilder builder) {
    super(builder);
    this.cid3 = builder.cid3;
    this.lastUpdateTime = builder.lastUpdateTime;
    this.title = builder.title;
    this.subTitle = builder.subTitle;
    this.cid1 = builder.cid1;
    this.cid2 = builder.cid2;
    this.createTime = builder.createTime;
    this.detail = builder.detail;
    this.onSale = builder.onSale;
    this.valid = builder.valid;
    this.brand = builder.brand;
  }

  public static class SpuBuilder extends Builder<SpuBuilder> {

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

    private SpuBuilder() {
    }

    public static SpuBuilder aSpu() {
      return new SpuBuilder();
    }

    public SpuBuilder title(String title) {
      this.title = title;
      return this;
    }

    public SpuBuilder subTitle(String subTitle) {
      this.subTitle = subTitle;
      return this;
    }

    public SpuBuilder cid1(String cid1) {
      this.cid1 = cid1;
      return this;
    }

    public SpuBuilder cid2(String cid2) {
      this.cid2 = cid2;
      return this;
    }

    public SpuBuilder cid3(String cid3) {
      this.cid3 = cid3;
      return this;
    }

    public SpuBuilder brand(Brand brand) {
      this.brand = brand;
      return this;
    }

    public SpuBuilder detail(SpuDetail detail) {
      this.detail = detail;
      return this;
    }

    public SpuBuilder onSale(Boolean onSale) {
      this.onSale = onSale;
      return this;
    }

    public SpuBuilder valid(Boolean valid) {
      this.valid = valid;
      return this;
    }

    public SpuBuilder createTime(Date createTime) {
      this.createTime = createTime;
      return this;
    }

    public SpuBuilder lastUpdateTime(Date lastUpdateTime) {
      this.lastUpdateTime = lastUpdateTime;
      return this;
    }

    public Spu build() {
      return new Spu(this);
    }
  }
}