package com.test.aop.demo5;

public class StudentDaoImpl implements StudentDao {


    @Override
    public void find() {
        System.out.println("学生信息查询...");
    }

    @Override
    public void save() {
        System.out.println("学生信息保存...");
    }

    @Override
    public void update() {
        System.out.println("学生信息修改...");
    }

    @Override
    public void delete() {
        System.out.println("学生信息删除...");
    }
}
