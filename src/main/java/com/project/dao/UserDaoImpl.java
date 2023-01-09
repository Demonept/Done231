package com.project.dao;

import com.project.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void add(User user) {
      em.persist(user);
   }

   @Override
   public List<User> listUsers() {
      return em.createQuery("SELECT user FROM User user", User.class).getResultList();
   }

   @Override
   public void update(User user) {
      em.merge(user);
   }

   @Override
   public User getUser(Long id) {
      User user = em.find(User.class, id);
      return user;
   }
   @Override
   public void deleteUser(Long id) {
      em.remove(em.find(User.class, id));
   }


}
