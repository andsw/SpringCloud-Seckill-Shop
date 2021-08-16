package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.CategoryBrandExample;
import cn.heshw.entity.CategoryBrandKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryBrandMapper {
    long countByExample(CategoryBrandExample example);

    int deleteByExample(CategoryBrandExample example);

    int deleteByPrimaryKey(CategoryBrandKey key);

    int insert(CategoryBrandKey record);

    int insertSelective(CategoryBrandKey record);

    List<CategoryBrandKey> selectByExample(CategoryBrandExample example);

    int updateByExampleSelective(@Param("record") CategoryBrandKey record, @Param("example") CategoryBrandExample example);

    int updateByExample(@Param("record") CategoryBrandKey record, @Param("example") CategoryBrandExample example);
}