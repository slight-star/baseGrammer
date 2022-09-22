package com.dong.test;

import com.dong.dao.UserDao;
import com.dong.domain.User;
import org.junit.Test;

/**
 * @author dfx
 */
public class UserDaoTest {

    @Test
    public void loginTest(){
        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("1234");

        User user = new UserDao().login(loginUser);
        System.out.println(user);
    }
}
