package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.PageResponseDTO;
import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        log.info(productVO);
        productMapper.insert(productVO);
    }

//    @Override
//    public ProductDTO getOne(Long pno) {
//        ProductVO productVO = productMapper.selectOne(pno);
//        ProductDTO productDTO = modelMapper.map(productVO, ProductDTO.class);
//        return productDTO;
//    }

    @Override
    public ProductDTO getOne(Long pno) {
        ProductVO productVO = productMapper.selectOne(pno);
        if (productVO == null) {
            // productVO가 null일 때 취할 조치
            // 예: 기본 ProductDTO 객체를 반환하거나, 특정 값을 가진 ProductDTO를 반환
            ProductDTO defaultProductDTO = new ProductDTO();
            // 기본값 설정 또는 로그 남기기 등
            return defaultProductDTO;
        }
        ProductDTO productDTO = modelMapper.map(productVO, ProductDTO.class);
        return productDTO;
    }


    @Override
    public void remove(Long pno) {
        productMapper.delete(pno);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productMapper.update(productVO);
    }

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        List<ProductVO> vos = productMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtos = vos.stream().map(vo->modelMapper.map(vo,ProductDTO.class)).toList();
        int total = productMapper.getCount(pageRequestDTO);

        PageResponseDTO<ProductDTO> pageResponseDTO = PageResponseDTO.<ProductDTO>All()
                .dtoList(dtos).total(total).pageRequestDTO(pageRequestDTO).build();

        return pageResponseDTO;
    }
    // 제너릭으로 만들어놓아서 <ProductDTO>로 써야 한다.
    // 여기서 선언이 되면서 제너릭 타입이 정해진다!
}
