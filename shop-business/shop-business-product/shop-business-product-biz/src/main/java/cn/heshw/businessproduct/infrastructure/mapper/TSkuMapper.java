package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TSku;
import cn.heshw.entity.TSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSkuMapper {
    long countByExample(TSkuExample example);

    int deleteByExample(TSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSku record);

    int insertSelective(TSku record);

    List<TSku> selectByExample(TSkuExample example);

    TSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSku record, @Param("example") TSkuExample example);

    int updateByExample(@Param("record") TSku record, @Param("example") TSkuExample example);

    int updateByPrimaryKeySelective(TSku record);

    int updateByPrimaryKey(TSku record);
}