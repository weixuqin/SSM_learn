package com.test.ioc.demo2;

/**
 * Bean3 的实例工厂：实例工厂和静态工厂的区别主要就是工厂类中是不是静态方法
 */

public class Bean3Factory {
    public Bean3 createBean3() {
        System.out.println("Bean3Factoyr被执行了....");
        return new Bean3();
    }
}
