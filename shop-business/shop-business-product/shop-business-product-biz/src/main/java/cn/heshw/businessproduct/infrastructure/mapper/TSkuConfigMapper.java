package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TSkuConfig;
import cn.heshw.entity.TSkuConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSkuConfigMapper {
    long countByExample(TSkuConfigExample example);

    int deleteByExample(TSkuConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSkuConfig record);

    int insertSelective(TSkuConfig record);

    List<TSkuConfig> selectByExample(TSkuConfigExample example);

    TSkuConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSkuConfig record, @Param("example") TSkuConfigExample example);

    int updateByExample(@Param("record") TSkuConfig record, @Param("example") TSkuConfigExample example);

    int updateByPrimaryKeySelective(TSkuConfig record);

    int updateByPrimaryKey(TSkuConfig record);
}