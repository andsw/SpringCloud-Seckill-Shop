package cn.heshw.businessproduct.infrastructure.repository.impl;

import cn.heshw.businessproduct.domain.aggregate.spu.Spu;
import cn.heshw.businessproduct.infrastructure.mapper.TSpuMapper;
import cn.heshw.businessproduct.infrastructure.repository.SpuRepository;
import cn.heshw.entity.TSpu;
import cn.heshw.entity.TSpuExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpuRepositoryImpl implements SpuRepository {

  private final TSpuMapper spuMapper;

  @Autowired
  public SpuRepositoryImpl(TSpuMapper spuMapper) {
    this.spuMapper = spuMapper;
  }

  @Override
  public List<Spu> listByPage(int page, int pageSize) {
    PageHelper.startPage(page, pageSize);
    List<TSpu> tSpus = spuMapper.selectByExample(new TSpuExample());
    return null;
  }

  @Override
  public Spu find(String id) {
    return null;
  }

  @Override
  public void save(Spu domain) {

  }

  @Override
  public void delete(String id) {

  }
}