package com.hpw.service;

import org.springframework.stereotype.Component;

/**
 * @author gn
 * @date 2021/7/5 14:48
 */


@Component
public class PaymentFallbackService implements ConsumerService
{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK ---- 80 降级处理";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut ---- 80 降级处理";
}
}

