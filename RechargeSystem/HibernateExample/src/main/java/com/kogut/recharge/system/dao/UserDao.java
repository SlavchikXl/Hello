package com.kogut.recharge.system.dao;

import com.kogut.recharge.system.configs.HibernateUtil;
import com.kogut.recharge.system.tables.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Slava on 24.03.2015.
 */
public class UserDao {

    public static User selectUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List lst = session.createCriteria(User.class).add(Restrictions.eq("EMail", user.getEMail())).add(Restrictions.eq("password", user.getPassword())).list();
        session.getTransaction().commit();
        session.close();
        if (lst.size() == 0) {
            return null;
        }
        return (User) lst.get(0);
    }

    public static void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void userToAdmin(User user){
        user.setStatus("A");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
}
