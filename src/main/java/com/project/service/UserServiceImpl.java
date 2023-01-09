package com.project.service;

import com.project.dao.UserDao;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   private final UserDao userDao;

   @Autowired
   public UserServiceImpl(UserDao userDao){
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
   }

   @Transactional(readOnly = true)
   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }
   @Transactional
   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

}
