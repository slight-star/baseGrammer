package cn.bistu.dao;

/**
 * @author dfx
 */

import cn.bistu.domain.AdminUser;
import cn.bistu.domain.User;
import cn.bistu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表的类
 */
public class AdminUserDaoImpl implements AdminUserDao{

    /**
     * 创建JDBCTemplate对象,共用连接池
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    /**
     * 登录方法
     * @param loginuser
     * @return
     */
    public AdminUser login(AdminUser loginAdminUser){
        //1.编写sql
        String sql = "select * from adminUser where username = ? and password = ?";
        //2.调用query方法
        AdminUser adminUser = null;
        try {
            adminUser = template.queryForObject(sql, new BeanPropertyRowMapper<AdminUser>(AdminUser.class), loginAdminUser.getUsername(), loginAdminUser.getPassword());
//            System.out.println(adminUser);
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
        return adminUser;

    }


    public AdminUser findAdminUsername(AdminUser loginAdminUser){
        //1.编写sql
        String sql = "select * from adminUser where username = ? ";
        //2.调用query方法
        AdminUser adminUser = null;
        try {
            adminUser = template.queryForObject(sql, new BeanPropertyRowMapper<AdminUser>(AdminUser.class), loginAdminUser.getUsername());
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
        return adminUser;

    }

    public void addAdminUser(AdminUser adminUser) {
        String sql = "insert into adminUser(username,password) values(?,?) ";
        int update = template.update(sql, adminUser.getUsername(), adminUser.getPassword());
    }
}
