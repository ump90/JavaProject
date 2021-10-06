package com.itheima.service;

import com.itheima.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() throws Exception {


//逻辑：张部要搞定100元，其中15%的为手续费打到手续账户
//        首先张部账户转钱向账户A ，然后账户A转账户B ，依次经历Cd账户，最后转到张部账户
//        异常：中途可能会出现异常，采用偶数判断，随时可能出现异常
//        完成效果：
// 1.依次配置注解（不需要修改代码逻辑，只需要配置注解即可）
// 2.控制台打印出（AOP功能）：资金流动情况：[张部账号, 100.0]
// 3.当异常发生的时候，仍然需要保住资金不变，并且保障日志能正常使用
        accountService.transferByCps("张部国内账号",100d);
    }

}
