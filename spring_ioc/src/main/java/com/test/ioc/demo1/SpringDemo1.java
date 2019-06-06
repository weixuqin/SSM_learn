package com.test.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class SpringDemo1 {

    @Test
    /**
     * 传统方式实现
     */
    public void demo1() {
       // UserService userService = new UserServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        //设置属性
        userService.setName("张三");
        userService.sayHello();
    }

    @Test
    /**
     * Spring 方式实现
     */
    public void demo2() {
        // 创建 Spring 的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 读取磁盘系统中的配置文件
     */
    public void demo3() {
        // 创建 Spring 的工厂
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("e:\\applicationContext.xml");
        //通过工厂获得类
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 传统方式的工厂类：BeanFactory
     */
    public void demo4() {
        //创建工厂类
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //通过工厂获得类
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 传统方式的工厂类：BeanFactory
     */
    public void demo5() {
        //创建工厂类
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("e:\\applicationContext.xml"));
        //通过工厂获得类
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }
}
