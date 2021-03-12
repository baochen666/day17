package com.dao;

import com.domain.User;

import java.util.List;

public interface UserDao {


    public List<User> findAll();
    public User findUserByusernameAndPasseord(String username,String password);

    void add(User user);

    void delSelectedUser(Integer id);

    void update(User user);

    User findById(int parseInt);

    int findTotalcount();

    List<User> findByPage(int start, int rows);
}
