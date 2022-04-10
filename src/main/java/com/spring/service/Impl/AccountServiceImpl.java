package com.spring.service.Impl;

import com.spring.service.IAccountService;
import com.spring.service.dao.IAccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
*曾经XML的配置：
* <bean id="accountService" class="com.spring.AccountServiceImpl"、
*    scope="" init-method="" destroy-method="">
*   <property name="" value="" | ref=""></property>
* </bean>
*
* 用于创建对象的
*   他们的作用就和XML文件中编写一个bean标签的实现的功能是一样的
*   @Component:
*           作用：用于把当前类对象存入spring容器中
*           属性：
*               value：用于指定的bean的id。当我们不写时，它的默认值是当前类名，且首字母小写。
*   @Controller：一般用在表现层
*   @Service：一般用在业务层
*   @Repository：一般用在持久层
*   以上三个注解他们的作用和属性与Component是一模一样
*   他们三个是spring框架为我们提供明确的三层使用的注释，使我们的三层对象更加清晰
*
* 用于注入数据的
*   他们的作用就和XML文件中的bean标签中写一个<property>标签的作用是一样的</property>
*   Autowired:
*       作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
*            如果IOC容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
*       出现位置：
*           可以是变量上，也可以是方法上
*       细节：
*           在使用注解注入时，set方法就不是必须的了。
*   Qualifier:
*       作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以。
*       属性：
*           value：用于指定注入时的id
*   Resource:
*       作用：直接按照bean的id注入，可以独立使用
*       属性：
*           name：用于指定bean的id
*   以上三个注入都只能注入bean类型的数据，而基本类型和String类型无法使用上述注解实现
*
*   Value
*       作用：用于注入基本类型和String类型的数据
*       属性：
*           value：用于指定数据的值。
*
* 用于改变作用范围的
*   他们的作用就和XML文件中bean标签中使用scope属性实现的功能是一样的
* 和生命周期相关的
*   他们的作用就和XML文件中bean标签中使用init-method和destroy-method的作用是一样的
*
*   PreDestroy
*       作用：用于指定销毁方法
*   PostConstruct
*       作用：用于指定初始化方法
*
* 账户业务逻辑层实现类
* */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao = null;

    public void saveAccount(){
            accountDao.saveAccount();
    }
}
