package com.datacollector.db;

import com.datacollector.model.Country;
import com.datacollector.model.Model;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sanjay on 19/12/15.
 */
public class CountryPersistor implements ModelPersistor {

    public boolean insert(Model model) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(model);
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
            session.update(model);
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
            session.delete(model);
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
