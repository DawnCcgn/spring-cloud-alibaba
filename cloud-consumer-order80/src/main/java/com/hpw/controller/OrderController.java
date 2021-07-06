package com.hpw.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hpw.entities.CommonResult;
import com.hpw.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author gn
 * @date 2021/6/22 19:55
 */

@EnableEurekaClient
@RestController
@Slf4j
public class OrderController {

    public static final String PARMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult creat(Payment payment){


////        String s = JSON.toJSONString(payment);
//        Payment payment1 = JSONObject.parseObject(payment, Payment.class);

        return restTemplate.postForObject(PARMENT_URL + "/payment/create/",payment,CommonResult.class);

    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PARMENT_URL + "/payment/get/" + id,CommonResult.class);
    }




}
