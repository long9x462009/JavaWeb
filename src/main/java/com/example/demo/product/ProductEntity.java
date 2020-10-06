package com.example.demo.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name = "product_demo")
// định nghĩa class này tương đương với 1 bảng trong db( bảng có tên là product_demo)
// đây là tầng thao tác với db
public class ProductEntity {
    // thuộc tính tương đương với cột khóa chính trong db
    // khóa chính là trường giá trị đại diện trong 1 bảng để xử lí chính với giá trị này
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // không được để null( ko để giá trị trống)
    @NotNull
    private String name;
    private String description;
    // get set đại diện cho đóng gói
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

}
