package com.ssg.product_manageapp.mapper;

import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class) //test 파일에선 Autowired랑 세트
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductMapperTests {

    @Autowired(required = false)
    private ProductMapper productMapper;

    @Test
    public void testInsert(){
        ProductVO productVO = ProductVO.builder()
                .pname("필통").price(10000).amount(11).build();
        log.info(productVO);
        productMapper.insert(productVO);
    }

    @Test
    public void testSelectAll(){
        List<ProductVO> productVOList = productMapper.selectAll();
        productVOList.forEach(vo->log.info(vo));
    }

    @Test
    public void testSelectOne(){
        ProductVO productVO = productMapper.selectOne(1L);
        log.info(productVO);
    }

    @Test
    public void testDelete(){
        productMapper.delete(5L);
    }

    @Test
    public void testUpdate(){
        ProductVO productVO = ProductVO.builder().pno(4L).
        pname("전등").price(400000).amount(12).build();
        log.info(productVO);
        productMapper.update(productVO);
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1).size(10).build();

        List<ProductVO> productVOList = productMapper.selectList(pageRequestDTO);
        productVOList.forEach(vo->log.info(vo));
    }
}
