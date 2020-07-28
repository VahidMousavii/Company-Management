package ir.dotin.da;

import ir.dotin.entity.Person;
import ir.dotin.entity.SubCategory;
import ir.dotin.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("prototype")
public class PersonDA {

    public List<Person> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from person_tbl");
            List<Person> list = query.list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void update(Person person) {
        if (person.getActive() == null) {
            person.setActive(false);
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(person);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteByID(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete from person_tbl pt where pt.personID = :personId");
            query.setParameter("personId", id);
            query.executeUpdate();
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public List<Person> findByName(String name) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from person_tbl pt where pt.personName like :personName ");
            query.setParameter("personName", name);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Person loadPerson(Long id) {
        return (Person) HibernateUtil.getSessionFactory().openSession().get(Person.class, id);
    }

    public Person loadPerson(Person person) {
        return this.loadPerson(person.getPersonID());
    }

    public void save(Person person) {
        if (person.getActive() == null) {
            person.setActive(false);
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.save(person);
            tx.commit();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public void saveRole(SubCategory subCategory) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(subCategory);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void active(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = (Person) session.get(Person.class, person.getPersonID());
            loadedPerson.setActive(true);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deactivate(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Person loadedPerson = (Person) session.get(Person.class, person.getPersonID());
            loadedPerson.setActive(false);
            session.saveOrUpdate(loadedPerson);
            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}