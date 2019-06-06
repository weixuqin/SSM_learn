package com.test.ioc.demo2;

/**
 * Bean2 的静态工厂：在工厂类当中，提供了一个静态的方法，返回类的实例
 */

public class Bean2Factory {
    public static Bean2 createBean2() {
        System.out.println("Bean2Factory的方法已经执行了...");
        return new Bean2();
    }
}
