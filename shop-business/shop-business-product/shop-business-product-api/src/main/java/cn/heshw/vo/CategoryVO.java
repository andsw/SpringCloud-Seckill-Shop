package cn.heshw.vo;

import java.util.List;
import lombok.Data;

@Data
public class CategoryVO {

  private Integer id;
  private String name;
  private Integer sort;
  private List<CategoryVO> sub;
}