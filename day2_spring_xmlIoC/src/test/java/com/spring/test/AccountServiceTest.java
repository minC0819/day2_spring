package com.spring.test;

import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(123456);
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 执行方法
        Account account = as.findAccountById(4);
        account.setName("test");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 得到业务层对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        // 执行方法
        as.deleteAccount(4);
    }
}
