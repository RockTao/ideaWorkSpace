package com.genericity;

import java.math.BigDecimal;

public class Order<T> {
    private  String name;
    private BigDecimal price;
    private T product;

    public Order() {
    }

    public Order(String name, BigDecimal price, T product) {
        this.name = name;
        this.price = price;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }
}
