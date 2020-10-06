package com.example.demo.product;

import com.example.demo.product.mapping.MappingInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;

// đây là tầng xử lí logic
@Service
public class ProductServices {
    // đây là cầu kết nối các tầng với nhau
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MappingInterface mappingInterface;

    public List<ProductEntity> findAll() {
        // lấy toàn bộ dữ liệu của bảng
        return productRepository.findAll();
    }

    public List<ProductEntity> findAllQuery() {
        return productRepository.findAllQuery();
    }

    public ProductEntity post(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public Boolean del(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            productRepository.delete(productEntity.get());
            return true;
        } else
            return false;

    }
//    public Boolean delUserbyid(Long id) {
//        Optional<ProductEntity> productEntity = productRepository.findById(id);
//        if (productEntity.isPresent()) {
//            productRepository.delUserbyid(id);
//            return true;
//        } else
//            return false;
//    }
//    public Boolean insertUser(ProductEntity productEntity){
//        boolean check = false;
//        try {
//            productRepository.insertUser(productEntity.getName(),productEntity.getDescription());
//            check=true;
//        }catch (Exception e){
//
//        }
//         return check;
//    }
//    public Boolean updateUser(Long id,ProductEntity productEntity) {
//        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
//        boolean check = false;
//        if (productEntityOptional.isPresent()) {
//            try {
//                productRepository.updateUser(id, productEntity.getName(), productEntity.getDescription());
//                check = true;
//            } catch (Exception e) {
//
//            }
//            return check;
//        } else {
//            return false;
//        }
//    }

    public Boolean save(Long id, ProductEntity productEntity) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        boolean check = false;
        if (optionalProductEntity.isPresent()) {
            try {
                productEntity.setId(id);
                productRepository.save(productEntity);
                check = true;
            } catch (Exception e) {

            }
            return check;
        } else {
            return false;
        }
    }

    public List<ProductDTO> getList() {
        List<ProductDTO> listDTO = new ArrayList<>();
        List<ProductEntity> listEntity = new ArrayList<>();
        listEntity = productRepository.findAllQuery();
        for (ProductEntity productEntity : listEntity
        ) {
            ProductDTO productDTO = new ProductDTO();
            productDTO = mappingInterface.mappingEntityToDTO(productEntity);
            listDTO.add(productDTO);
        }
        return listDTO;
    }

    public ProductEntity insert(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity = mappingInterface.mappingDTOToEntity(productDTO);
        return productRepository.save(productEntity);

    }

    public ProductEntity update(Long id, ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity = mappingInterface.mappingDTOToEntity(productDTO);
        productEntity.setId(id);
        return productRepository.save(productEntity);
    }

    public Set<ProductEntity> set(ArrayList<ProductEntity> productEntityList) {
        Set<ProductEntity> setarr = new HashSet<ProductEntity>(productEntityList);
        Set<ProductEntity> setarrdone = new HashSet<>();
        for (ProductEntity productEntity : setarr
        ) {
            try {
                setarrdone.add(post(productEntity));
            } catch (Exception e) {

            }
        }
        return setarrdone;
    }

    public testDTO pagination(int activePage) {
        int limit = 10;
        PageRequest pageable = PageRequest.of(activePage - 1, limit,Sort.by(Sort.Direction.ASC,"id"));
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);
        int totalPage = (int)(Math.ceil((double)(productRepository.findAll().size())/limit));
        testDTO testDTO = new testDTO();

        testDTO.setTotalPage(totalPage);
        testDTO.setData(productEntities.getContent());

        return testDTO;
    }

}
