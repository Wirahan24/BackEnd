package com.BackEnd.FullStack.Service.User;

import com.BackEnd.FullStack.Dao.User.UserDao;
import com.BackEnd.FullStack.Entity.User.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void InsertUSer(Users users) {
        userDao.InsertUser(users);
    }
}
