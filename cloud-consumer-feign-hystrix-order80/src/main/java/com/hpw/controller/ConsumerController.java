package com.hpw.controller;

import com.hpw.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author gn
 * @date 2021/7/2 14:43
 */

@RestController
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = consumerService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws InterruptedException
    {
        String result = consumerService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) throws InterruptedException
    {

        return  "端口80，调用支付服务超时或者错误,请稍后重试" + "/(ㄒoㄒ)/~~";
    }

    public String global_FallbackMethod()
    {
        return "Global --80--异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
