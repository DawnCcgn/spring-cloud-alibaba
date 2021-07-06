package com.hpw.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author gn
 * @date 2021/7/2 11:51
 */

@Service
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class PaymentService {


    /**
     * @description 正常的访问
     * @author gn
     * @params id
     * @date 2021/7/2 11:59
     */
    @HystrixCommand
    public String paymenInfo_Ok(Integer id) {

        int i= 1/0;

        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {

//            try {
//                TimeUnit.SECONDS.sleep(13);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        int i= 1/0;

        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "\t当前线程池名字" + Thread.currentThread().getName() + "8001系统繁忙或运行报错，请稍后再试" + id + "/(ㄒoㄒ)/~~";
    }


    public String global_FallbackMethod()
    {
        return "Global异常处理信息 ---- 8001 ---，请稍后再试，/(ㄒoㄒ)/~~";
    }

    //=====================服务熔断==================================

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
