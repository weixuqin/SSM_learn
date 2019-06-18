package com.test.demo1;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

    public void save() {
        System.out.println("Dao 中保存用户。。。");
    }

}
