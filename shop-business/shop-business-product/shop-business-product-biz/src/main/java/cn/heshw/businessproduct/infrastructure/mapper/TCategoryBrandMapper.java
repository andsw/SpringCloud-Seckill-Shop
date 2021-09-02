package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TCategoryBrandExample;
import cn.heshw.entity.TCategoryBrandKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCategoryBrandMapper {
    long countByExample(TCategoryBrandExample example);

    int deleteByExample(TCategoryBrandExample example);

    int deleteByPrimaryKey(TCategoryBrandKey key);

    int insert(TCategoryBrandKey record);

    int insertSelective(TCategoryBrandKey record);

    List<TCategoryBrandKey> selectByExample(TCategoryBrandExample example);

    int updateByExampleSelective(@Param("record") TCategoryBrandKey record, @Param("example") TCategoryBrandExample example);

    int updateByExample(@Param("record") TCategoryBrandKey record, @Param("example") TCategoryBrandExample example);
}