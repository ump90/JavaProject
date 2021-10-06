package com.itheima.spring.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SqlTest {
  @Pointcut("execution(* com.itheima.spring.service.BookService.*(..) )")
  private void pt() {}

  @Around("SqlTest.pt()")
  public void SpeedTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Signature signature = proceedingJoinPoint.getSignature();
    String className = signature.getDeclaringTypeName();
    String methodName = signature.getName();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      proceedingJoinPoint.proceed();
    }
    long endTime = System.currentTimeMillis();
    System.out.println(
        "SpeedTest " + className + " " + methodName + " -->" + (endTime - startTime));
  }

//  @Pointcut("execution(* com.itheima.spring.service.UserService.findUser)")
//  private void
}
