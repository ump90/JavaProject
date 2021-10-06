package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class DataAdvice {
    @Pointcut("execution(void com.itheima.service.AccountService.*(..))")
    private void servicePt(){}

    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("资金流动情况：");
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            //输出参数
            System.out.println("资金流动情况："+Arrays.toString(args));
        }
        Object ret = pjp.proceed(args);
        return ret;
    }


}
