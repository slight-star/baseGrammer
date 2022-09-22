package cn.bistu.service;

import cn.bistu.dao.AdminUserDao;
import cn.bistu.dao.AdminUserDaoImpl;
import cn.bistu.domain.AdminUser;

/**
 * @author dfx
 */
public class AdminUserServiceImpl implements AdminUserService{

    @Override
    public AdminUser login(AdminUser adminUser) {
        AdminUserDao dao = new AdminUserDaoImpl();
        AdminUser loginUser = dao.login(adminUser);
        return loginUser;
    }
}
