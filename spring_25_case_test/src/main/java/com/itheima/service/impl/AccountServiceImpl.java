package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    /**
     * xq开始的入口
     * @param out
     * @param in
     * @param money
     */
    public void transfer(String out,String in ,Double money ) throws IOException{


        try{

            accountDao.outMoney(out,money);
            int i=new Random().nextInt(25)/2;
            System.out.println("随机数="+i);
            if(i==1){
                throw  new IOException();
            }
            accountDao.inMoney(in,money);
//            模拟出现转账异常，这里使用随机数


        }finally {

            logService.log(out,in,money);
        }
    }

    public void transferByCps(String out, Double money) throws Exception {

        this.transfer(out,"账户A",money);
        Thread.sleep(20);
        this.transfer("账户A","账户B",money);
        Thread.sleep(3);
        this.transfer("账户B","账户C",money);
        Thread.sleep(3);
        this.transfer("账户C","账户D",money);
        Thread.sleep(3);
        this.transfer("账户D","张部海外账号",money);




    }

}
