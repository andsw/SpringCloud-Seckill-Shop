package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.SpuConfig;
import cn.heshw.entity.SpuConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpuConfigMapper {
    long countByExample(SpuConfigExample example);

    int deleteByExample(SpuConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpuConfig record);

    int insertSelective(SpuConfig record);

    List<SpuConfig> selectByExample(SpuConfigExample example);

    SpuConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpuConfig record, @Param("example") SpuConfigExample example);

    int updateByExample(@Param("record") SpuConfig record, @Param("example") SpuConfigExample example);

    int updateByPrimaryKeySelective(SpuConfig record);

    int updateByPrimaryKey(SpuConfig record);
}