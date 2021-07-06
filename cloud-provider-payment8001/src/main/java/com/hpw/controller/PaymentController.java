package com.hpw.controller;

import com.hpw.entities.CommonResult;
import com.hpw.entities.Payment;
import com.hpw.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gn
 * @date 2021/6/22 19:55
 */
@RestController
@Slf4j
@EnableEurekaClient
public class PaymentController
{

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create( Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);

        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功" + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}",payment);
        if (payment != null) {
            return new CommonResult<Payment>(200,"查询成功" +serverPort,payment);
        }else{
            return new CommonResult<Payment>(444,"没有对应记录,查询ID: "+id,null);
        }
    }
}
