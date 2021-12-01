package cn.heshw.businessproduct.infrastructure.repository;

import cn.heshw.businessproduct.domain.aggregate.spu.Spu;
import cn.heshw.ddd.Repository;
import java.util.List;


public interface SpuRepository extends Repository<Spu> {

  List<Spu> listByPage(int page, int pageSize);
}