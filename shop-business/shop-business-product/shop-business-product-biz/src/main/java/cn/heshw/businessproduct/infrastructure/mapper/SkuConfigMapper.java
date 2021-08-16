package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.SkuConfig;
import cn.heshw.entity.SkuConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuConfigMapper {
    long countByExample(SkuConfigExample example);

    int deleteByExample(SkuConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuConfig record);

    int insertSelective(SkuConfig record);

    List<SkuConfig> selectByExample(SkuConfigExample example);

    SkuConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuConfig record, @Param("example") SkuConfigExample example);

    int updateByExample(@Param("record") SkuConfig record, @Param("example") SkuConfigExample example);

    int updateByPrimaryKeySelective(SkuConfig record);

    int updateByPrimaryKey(SkuConfig record);
}