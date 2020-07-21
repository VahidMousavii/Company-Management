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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
@Repository
@Scope("prototype")
public class PersonDA {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    public void addPerson(Person person) {
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

    public List<Person> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from person_tbl");
        List<Person> list = query.list();
        return list;
    }

    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
    }

    public void deleteByID(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from person_tbl pt where pt.id = :personId");
        query.setParameter("personId", id);
        query.executeUpdate();
        tx.commit();
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
        return (Person) HibernateUtil.getSessionFactory().openSession().load(Person.class, id);
    }

    public Person loadPerson(Person person) {
        return this.loadPerson(person.getPersonID());
    }

    public void save(Person person) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(person);
        tx.commit();
        sessionFactory.close();
    }

    public void saveRole(SubCategory subCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(subCategory);
        tx.commit();
        sessionFactory.close();
    }

    /*public List<PersonTO> selectByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from PersonTO u where u.name like :name");
        query.setParameter("name", "%" + name + "%");
        List<PersonTO> list = query.list();
        return list;
    }*/
}