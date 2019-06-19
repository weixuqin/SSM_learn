package com.test.aop.demo1;

import org.junit.Test;

public class SpringDemo1 {

    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();

        //产生代理对象
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();

        //调用增强的方法
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }

}
