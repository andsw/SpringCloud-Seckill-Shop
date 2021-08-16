package cn.heshw.businessproduct.domain.aggregate.spu;

import cn.heshw.ddd.ValueObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;

@Builder
public class SpuDetail implements ValueObject<SpuDetail> {
  private String description;
  private Map<String, String> genericInfo;
  private LinkedHashMap<String, List<String>> specialConfig;
  private String accessoriesList;
  private String afterSale;
}