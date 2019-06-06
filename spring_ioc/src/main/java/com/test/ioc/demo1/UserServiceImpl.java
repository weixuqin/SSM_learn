package com.test.ioc.demo1;

public class UserServiceImpl implements UserService{

    // 添加属性
    private String name;

    public void sayHello() {
        System.out.println("hello spring" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
