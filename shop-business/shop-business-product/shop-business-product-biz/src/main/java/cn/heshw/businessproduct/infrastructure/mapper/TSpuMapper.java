package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TSpu;
import cn.heshw.entity.TSpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpuMapper {
    long countByExample(TSpuExample example);

    int deleteByExample(TSpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSpu record);

    int insertSelective(TSpu record);

    List<TSpu> selectByExample(TSpuExample example);

    TSpu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSpu record, @Param("example") TSpuExample example);

    int updateByExample(@Param("record") TSpu record, @Param("example") TSpuExample example);

    int updateByPrimaryKeySelective(TSpu record);

    int updateByPrimaryKey(TSpu record);
}