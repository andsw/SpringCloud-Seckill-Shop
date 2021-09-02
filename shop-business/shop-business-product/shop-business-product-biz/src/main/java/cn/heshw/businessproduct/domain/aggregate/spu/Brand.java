package cn.heshw.businessproduct.domain.aggregate.spu;

import cn.heshw.ddd.ValueObject;
import lombok.Builder;

@Builder
public class Brand implements ValueObject<Brand> {
  private String id;
  private String name;
  private String imageUrl;
  private Character firstLetter;
}