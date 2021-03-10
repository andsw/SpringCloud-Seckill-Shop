package cn.heshw.businessproduct.service.impl;

import cn.heshw.businessproduct.mapper.CategoryMapper;
import cn.heshw.businessproduct.service.CategoryService;
import cn.heshw.entity.Category;
import cn.heshw.entity.CategoryExample;
import cn.heshw.vo.CategoryVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryMapper categoryMapper;

  public CategoryServiceImpl(CategoryMapper categoryMapper) {
    this.categoryMapper = categoryMapper;
  }

  public CategoryVO getAllCategoryTree() {
    List<CategoryVO> tree = new ArrayList<>();
    List<Category> categories = categoryMapper.selectByExample(new CategoryExample());

    return null;
  }

}