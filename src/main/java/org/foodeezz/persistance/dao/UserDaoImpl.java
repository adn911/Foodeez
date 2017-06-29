package org.foodeezz.persistance.dao;


import org.foodeezz.persistance.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public UserDaoImpl() {

    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u WHERE u.email=:email AND u.password=:password", User.class);

        query.setParameter("email", loginEmail);
        query.setParameter("password", loginPassword);

        return getSingleResultOrNull(query);
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u WHERE u.email=:email ", User.class);
        query.setParameter("email", email);

        return getSingleResultOrNull(query);
    }

    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u WHERE u.username=:username", User.class);
        query.setParameter("username", username);
        return getSingleResultOrNull(query);
    }


    @Override
    public void addUser(User user) {

        if(user.isNew()){
            em.persist(user);
        } else{
            em.merge(user);
        }
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User AS u", User.class).getResultList();
    }

    @Override
    public boolean userExists(int userId) {
        return getUser(userId) != null;
    }

    @Override
    public User getUser(int userId) {
        return em.find(User.class, userId);
    }

    private User getSingleResultOrNull(TypedQuery<User> query) {
        query.setMaxResults(1);
        List<User> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}