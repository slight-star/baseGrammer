package cn.bistu.dao;

import cn.bistu.domain.User;

/**
 * @author dfx
 */
public interface UserDao {
    User login(User user);
    User findUsername(User user);
    void addUser(User user);
}
