package com.atguigu.springcloud.serviceImpl;

import com.atguigu.springcloud.dao.paymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.paymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class paymentServiceImpl implements paymentService {
    @Resource
    private paymentDao paymentDao;



    public int create(Payment payment){
        return  paymentDao.create(payment);
    }

    public  Payment getPaymentById( Long id){
return  paymentDao.getPaymentById(id);
    }

}
