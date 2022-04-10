package com.spring.service.ui;

import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
* 模拟一个表现层，用于调用业务层
* */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountService");
        /*System.out.println(as);

        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(ad);*/

        as.saveAccount();
    }
}

