package com.itheima.mvc.exception;

import com.itheima.mvc.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author UMP90
 * @date 2021/10/8
 */
@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler(Exception.class)
  public Result doOtherException(Exception exception) {

    return new Result(0, "unexpected error", null);
  }
  @ExceptionHandler(SystemException.class)
  public Result doSystemException(SystemException ex){
    return new Result(ex.getCode(),ex.getMessage(), null);
  }
  @ExceptionHandler(BusinessException.class)
  public Result doBusinessException(BusinessException exception){
    return new Result(exception.getCode(),exception.getMessage(), null);
  }


}
