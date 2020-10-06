package com.example.demo.product;


import java.util.List;

public class testDTO {
    private List<ProductEntity> data;
    private int totalPage;

    public List<ProductEntity> getData() {
        return data;
    }

    public void setData(List<ProductEntity> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
