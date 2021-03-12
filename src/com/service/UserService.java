package com.service;

import com.domain.PageBean;
import com.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /*
      查询所有用户信息
     */
    public List<User> findAll();
    public User login(String username,String passeord);
    public void addUser(User user);

    void delSelectedUser(String[] ids);

    void deleteUser(String id);

    void updateUser(User user);

    User findUserById(String id);

    PageBean<User> fingUserPage(String currentPage, String Rows, Map<String, String[]> condition);
}
