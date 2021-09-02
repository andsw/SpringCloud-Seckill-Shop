package cn.heshw.businessproduct.infrastructure.mapper;

import cn.heshw.entity.TSpuDetail;
import cn.heshw.entity.TSpuDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpuDetailMapper {
    long countByExample(TSpuDetailExample example);

    int deleteByExample(TSpuDetailExample example);

    int deleteByPrimaryKey(Long spuId);

    int insert(TSpuDetail record);

    int insertSelective(TSpuDetail record);

    List<TSpuDetail> selectByExampleWithBLOBs(TSpuDetailExample example);

    List<TSpuDetail> selectByExample(TSpuDetailExample example);

    TSpuDetail selectByPrimaryKey(Long spuId);

    int updateByExampleSelective(@Param("record") TSpuDetail record, @Param("example") TSpuDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") TSpuDetail record, @Param("example") TSpuDetailExample example);

    int updateByExample(@Param("record") TSpuDetail record, @Param("example") TSpuDetailExample example);

    int updateByPrimaryKeySelective(TSpuDetail record);

    int updateByPrimaryKeyWithBLOBs(TSpuDetail record);

    int updateByPrimaryKey(TSpuDetail record);
}