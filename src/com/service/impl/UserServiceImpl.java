package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.PageBean;
import com.domain.User;
import com.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(String username, String password) {
        return dao.findUserByusernameAndPasseord(username,password);
    }

    @Override
    public void addUser(User user) {
         dao.add(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        for (String id :ids){
            dao.delSelectedUser(Integer.valueOf(id));
        }
    }

    @Override
    public void deleteUser(String id) {
        dao.delSelectedUser(Integer.valueOf(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> fingUserPage(String currentPage, String Rows, Map<String, String[]> condition) {
        PageBean<User> pb  = new PageBean<>();
        int currentgage=Integer.valueOf(currentPage);
        int rows=Integer.valueOf(Rows);
        int count=dao.findTotalcount();
        pb.setRows(rows);
        pb.setTotalCount(count);
        pb.setCurrentPage(currentgage);
        int start=(currentgage-1)*rows;

        List<User> list=dao.findByPage(start,rows);
        pb.setList(list);
        int totalpage = (count%rows==0)?count/rows:count/rows+1;
        pb.setTotalPage(totalpage);
        return pb;


    }

}
