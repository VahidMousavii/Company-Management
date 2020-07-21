package ir.dotin.da;

import ir.dotin.entity.Email;
import ir.dotin.entity.Person;
import ir.dotin.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EmailDA {
    public void addEmail(Email email) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(email);
/*            Person person = (Person) session.load(Person.class, email.getSenderPerson().getPersonID());
            session.saveOrUpdate(person);*/
            for (Person receiverPerson : email.getReceiverPersons()) {
                session.saveOrUpdate(receiverPerson);
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public List<Email> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from email_tbl ");
        List<Email> list = query.list();
        return list;
    }

}
