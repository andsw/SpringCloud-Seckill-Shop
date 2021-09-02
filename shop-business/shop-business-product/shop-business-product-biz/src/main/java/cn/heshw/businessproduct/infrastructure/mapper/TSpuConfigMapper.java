package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TSpuConfig;
import cn.heshw.entity.TSpuConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpuConfigMapper {
    long countByExample(TSpuConfigExample example);

    int deleteByExample(TSpuConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSpuConfig record);

    int insertSelective(TSpuConfig record);

    List<TSpuConfig> selectByExample(TSpuConfigExample example);

    TSpuConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSpuConfig record, @Param("example") TSpuConfigExample example);

    int updateByExample(@Param("record") TSpuConfig record, @Param("example") TSpuConfigExample example);

    int updateByPrimaryKeySelective(TSpuConfig record);

    int updateByPrimaryKey(TSpuConfig record);
}