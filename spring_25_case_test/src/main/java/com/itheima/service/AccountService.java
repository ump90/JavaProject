package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AccountService {
    //rollbackFor:设置当前事务参与回滚的异常，默认非运行时异常不参与回滚
    @Transactional(rollbackFor = IOException.class)
    public void transfer(String out,String in ,Double money) throws IOException;


//思考下是否要开启 编译异常包含,cps 代表操盘手
    public void transferByCps(String out,Double money) throws IOException, Exception;
}
