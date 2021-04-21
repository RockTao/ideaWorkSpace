package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface paymentService {

    public int create(Payment payment);

    public  Payment getPaymentById(Long id);

}
