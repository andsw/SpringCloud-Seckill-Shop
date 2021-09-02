package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TBrand;
import cn.heshw.entity.TBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBrandMapper {
    long countByExample(TBrandExample example);

    int deleteByExample(TBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TBrand record);

    int insertSelective(TBrand record);

    List<TBrand> selectByExample(TBrandExample example);

    TBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByExample(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByPrimaryKeySelective(TBrand record);

    int updateByPrimaryKey(TBrand record);
}