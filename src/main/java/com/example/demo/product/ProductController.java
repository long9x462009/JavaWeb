package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// tầng định nghĩa API
@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/api/v1/products")
    //đây là uri
    public ResponseEntity<List<ProductEntity>> findAll(){
        return ResponseEntity.ok(productServices.findAll());
    }
    @GetMapping("/api/v1/products-query")
    public ResponseEntity<List<ProductEntity>> findAllQuery(){
        return ResponseEntity.ok(productServices.findAllQuery());
    }
    @PostMapping("/api/v1/products")
    public ResponseEntity<ProductEntity> post(@RequestBody ProductEntity productEntity){
        return ResponseEntity.ok(productServices.post(productEntity));
    }
    @DeleteMapping("api/v1/products/{id}")
    public ResponseEntity<Boolean> del( @PathVariable Long id){
        return ResponseEntity.ok(productServices.del(id));
    }

    // ham query
//    @DeleteMapping("api/v1/products/{id}")
//    public ResponseEntity<Boolean> delUserbyid(@PathVariable Long id){
//        return ResponseEntity.ok(productServices.delUserbyid(id));
//    }
//    @PostMapping("/api/v1/products")
//    public ResponseEntity<Boolean> insertUser(@RequestBody ProductEntity productEntity){
//        return ResponseEntity.ok(productServices.insertUser(productEntity));
//    }
//    @PutMapping("/api/v1/products/{id}")
//    public ResponseEntity<Boolean> updateUser(@PathVariable Long id,@RequestBody ProductEntity productEntity){
//        return ResponseEntity.ok(productServices.updateUser(id,productEntity));
//    }

    // ham spring boot
//    @PutMapping("/api/v1/products/{id}")
//    public ResponseEntity<Boolean> save(@PathVariable Long id, @RequestBody ProductEntity productEntity){
//        return ResponseEntity.ok(productServices.save(id, productEntity));
//    }
    @GetMapping("api/v1/product-mapping")
    public  ResponseEntity<List<ProductDTO>> getmapping() {
        return ResponseEntity.ok(productServices.getList());
    }

    @PostMapping("/mapping-insert")
    public ResponseEntity<ProductEntity> insertMapping(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productServices.insert(productDTO));
    }

    @PutMapping("/mapping/{id}")
    public ResponseEntity<ProductEntity> updateMapping(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productServices.update(id,productDTO));
    }
    @PostMapping("/api/v1/set")
    public ResponseEntity<Set<ProductEntity>> set(@RequestBody ArrayList<ProductEntity> productEntityList){
        return ResponseEntity.ok(productServices.set(productEntityList));
    }
    @GetMapping("/pagination/")
    public  ResponseEntity<testDTO> pagination(@RequestParam("activePage") int activePage){
        return ResponseEntity.ok(productServices.pagination(activePage));
    }
}
//rest API in spring boot and spring data JPA thêm xóa
