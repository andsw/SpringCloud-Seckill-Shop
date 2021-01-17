package cn.heshw.businessproduct.mapper;

import cn.heshw.entity.SpuDetail;
import cn.heshw.entity.SpuDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpuDetailMapper {
    long countByExample(SpuDetailExample example);

    int deleteByExample(SpuDetailExample example);

    int deleteByPrimaryKey(Long spuId);

    int insert(SpuDetail record);

    int insertSelective(SpuDetail record);

    List<SpuDetail> selectByExampleWithBLOBs(SpuDetailExample example);

    List<SpuDetail> selectByExample(SpuDetailExample example);

    SpuDetail selectByPrimaryKey(Long spuId);

    int updateByExampleSelective(@Param("record") SpuDetail record, @Param("example") SpuDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") SpuDetail record, @Param("example") SpuDetailExample example);

    int updateByExample(@Param("record") SpuDetail record, @Param("example") SpuDetailExample example);

    int updateByPrimaryKeySelective(SpuDetail record);

    int updateByPrimaryKeyWithBLOBs(SpuDetail record);

    int updateByPrimaryKey(SpuDetail record);
}