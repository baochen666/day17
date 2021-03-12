package com.dao.impl;

import com.dao.UserDao;
import com.domain.User;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;

    }

    @Override
    public User findUserByusernameAndPasseord(String username, String password) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String str="insert into user values (null,?,?,?,?,?,?,null,null)";
        template.update(str,user.getName(),user.getGender(),user.getAge()
        ,user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void delSelectedUser(Integer id) {
        String str="delete from user where id=?";
        template.update(str,id);
    }

    @Override
    public void update(User user) {
        String str="update user set name=?,gender=?,age=?,address=?,qq=?,email=?where id=?";
        template.update(str,user.getName(),user.getGender(),user.getAge()
                ,user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public User findById(int id) {
        String str="select * from user where id=? ";
        return template.queryForObject(str,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public int findTotalcount() {
        String str="select count(*) from user";
        Integer integer = template.queryForObject(str, Integer.class);
        return integer;

    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql="select * from user limit ? ,?";
        return  template.query(sql,new BeanPropertyRowMapper<>(User.class),start,rows);

    }
}
