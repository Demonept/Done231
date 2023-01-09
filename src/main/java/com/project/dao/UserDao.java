package com.project.dao;

import com.project.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void update(User user);
   User getUser(Long id);

   void deleteUser(Long id);
}
