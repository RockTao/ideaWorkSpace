package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface paymentService {

    public int create(Payment payment);

    public  Payment getPaymentById(Long id);

}
