package com.datacollector.com.datacollector.db;

import com.datacollector.model.Country;
import com.datacollector.model.Model;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.jpa.internal.EntityManagerImpl;

import java.util.List;

/**
 * Created by sanjay on 19/12/15.
 */
public class CountryPersistor implements ModelPersistor {

    public boolean insert(Model model) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save((Country) model);
            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
                ex.printStackTrace();
            }
        return false;
    }

    public boolean update(Model model) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update((Country) model);
            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(Model model) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete((Country) model);
            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public Model select(String code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Country.class,code);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<Model> selectAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query=session.createQuery("from Country");
            return query.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
