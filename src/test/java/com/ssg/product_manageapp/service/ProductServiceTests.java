package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.PageResponseDTO;
import com.ssg.product_manageapp.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductServiceTests {

    @Autowired(required = false)
    private ProductService productService;

    @Test
    public void testRegister(){
        ProductDTO productDTO = ProductDTO.builder().
                pname("접시").price(200000).amount(3).build();
        log.info(productDTO);
        productService.register(productDTO);
    }

    @Test
    public void testGetOne(){
        log.info(productService.getOne(1L));
    }

    @Test
    public void testRemove(){
        productService.remove(7L);
    }

    @Test
    public void testModify(){
        ProductDTO productDTO = ProductDTO.builder().pno(2L).
        pname("건전지").price(30000).amount(8).build();
        log.info(productDTO);
        productService.modify(productDTO);
    }

    @Test
    public void testPaging(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().
                page(1).size(3).build();
        PageResponseDTO<ProductDTO> responseDTO = productService.getList(pageRequestDTO);
        log.info(responseDTO);

        responseDTO.getDtoList().stream().forEach(productDTO -> log.info(productDTO));
    }
}
