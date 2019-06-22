package com.test.aspectJ.demo2;

public class CustomerDaoImpl implements CustomerDao{
    @Override
    public void save() {
        System.out.println("保存用户...");
    }

    @Override
    public String update() {
        System.out.println("修改用户...");
        return "spring";
    }

    @Override
    public void delete() {
        System.out.println("删除用户...");
    }

    @Override
    public void findOne() {
        System.out.println("查询单个用户...");
        // int a = 1/0;
    }

    @Override
    public void findAll() {
        System.out.println("查询多个用户...");
        // int b = 1/0;
    }
}
