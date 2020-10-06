package com.example.demo.product;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
// jpaRepository hộ trợ những câu truy vấn db cơ bản
// bắt truyền vào 2 tham số t1 đó là tên class tương ứng vơi table mà các bạn thao tác truy vấn trong db
// tham số thứ 2 là kiểu dữ liệu của trường giá trị khóa chính

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(value = "SELECT p FROM product_demo p")
    List<ProductEntity> findAllQuery();

    @Query(value = "SELECT p FROM product_demo p")
    Page<ProductEntity> pagination(PageRequest pageable);



//    @Modifying
//    @Transactional
//    @Query("DELETE  FROM product_demo u WHERE u.id = :id")
//    void delUserbyid(
//            @Param("id") Long id);
//    @Modifying
//    @Transactional
//    @Query(value = "insert into product_demo (name, description) values(:name,:description)", nativeQuery = true)
//    void insertUser ( @Param("name") String name, @Param("description") String description);

//    @Modifying
//    @Transactional
//    @Query(value = "update product_demo u set u.name = :name , u.description = :des where u.id = :id")
//    void updateUser( @Param("id") Long id,@Param("name") String name,@Param("des") String description);

}
