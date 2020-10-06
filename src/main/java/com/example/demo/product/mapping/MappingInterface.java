package com.example.demo.product.mapping;

import com.example.demo.product.ProductDTO;
import com.example.demo.product.ProductEntity;

public interface MappingInterface {
    public ProductDTO mappingEntityToDTO(ProductEntity productEntity);
    public ProductEntity mappingDTOToEntity(ProductDTO productDTO);
}
