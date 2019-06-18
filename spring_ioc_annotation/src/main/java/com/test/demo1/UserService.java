package com.test.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Spring 的 Bean 管理的注释方式
 * 传统方式需要去XML中配置<bean id="" class=""></bean>
 */

@Component("userService")
public class UserService {
    // 直接使用注解，不用另外写setter和getter方法
    @Value("米饭")
    private String something;

//    //自动注入UserDao类
//    @Autowired
//    //使用名称注入
//    @Qualifier("userDao")

    @Resource(name = "userDao")
    private UserDao userDao;

    public String sayHello(String name) {
        return "Hello" + name;
    }

    public void eat() {
        System.out.println("eat:" + something);
    }

    public void save() {
        System.out.println("Service 中保存用户。。。");
        userDao.save();
    }

}
