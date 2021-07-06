package com.hpw.service;

import com.hpw.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author gn
 * @date 2021/6/22 19:19
 */


public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
