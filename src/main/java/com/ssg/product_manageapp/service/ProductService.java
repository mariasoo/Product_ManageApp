package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.PageResponseDTO;
import com.ssg.product_manageapp.dto.ProductDTO;

public interface ProductService {

    void register(ProductDTO productDTO);

    ProductDTO getOne(Long pno);

    void remove(Long pno);

    void modify(ProductDTO productDTO);

    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
}
