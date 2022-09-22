package cn.bistu.dao;

import cn.bistu.domain.AdminUser;
import cn.bistu.domain.User;

/**
 * @author dfx
 */
public interface AdminUserDao {
    AdminUser login(AdminUser loginAdminUser);
    AdminUser findAdminUsername(AdminUser loginAdminUser);
    void addAdminUser(AdminUser adminUser);
}
