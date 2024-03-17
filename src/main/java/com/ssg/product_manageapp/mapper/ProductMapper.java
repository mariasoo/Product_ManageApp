package com.ssg.product_manageapp.mapper;

import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;

import java.util.List;

public interface ProductMapper { //데이터베이스를 mybatis로 가져오는 것 정의는 productMapper.xml에서

    void insert(ProductVO productVO);

    List<ProductVO> selectAll();

    ProductVO selectOne(Long pno);

    void delete(Long pno);

    void update(ProductVO productVO);

    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

}
