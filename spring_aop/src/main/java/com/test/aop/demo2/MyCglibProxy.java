package com.test.aop.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor{

    private ProductDao productDao;

    public MyCglibProxy(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Object createProxy() {
        //1. 创建核心类
        Enhancer enhancer = new Enhancer();
        //2. 设置父类
        enhancer.setSuperclass(productDao.getClass());
        //3. 设置回调
        enhancer.setCallback(this);
        //4. 生成代理（子类）
        Object proxy = enhancer.create();
        return proxy;
    }

    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())) {
            System.out.println("权限校验=========");
        }
        // invokeSuper 调用父类 ProductDao 方法
        return methodProxy.invokeSuper(proxy, args);
    }
}
