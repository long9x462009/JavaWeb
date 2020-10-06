package com.example.demo.product.mapping;

import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapping implements MappingInterface{

    @Override
    public ProductDTO mappingEntityToDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        return productDTO;
    }

    @Override
    public ProductEntity mappingDTOToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDTO.getId());
        productEntity.setName(productDTO.getName());
        productEntity.setDescription("default");
        return productEntity;
    }

}
