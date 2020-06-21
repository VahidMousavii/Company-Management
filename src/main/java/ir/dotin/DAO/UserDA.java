package ir.dotin.DAO;


import ir.dotin.entity.Person;
import ir.dotin.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDA {
/*
    public List<PersonTO> selectByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from PersonTO u where u.name like :name");
        query.setParameter("name", "%" + name + "%");
        List<PersonTO> list = query.list();
        return list;
    }*/
        
        public void addUser (Person person){
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(person);
                session.getTransaction().commit();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
            
        }
    }

