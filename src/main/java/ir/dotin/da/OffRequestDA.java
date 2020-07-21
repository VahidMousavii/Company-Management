package ir.dotin.da;

import ir.dotin.entity.DayOffRequest;
import ir.dotin.entity.Person;
import ir.dotin.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DayOffRequestDA {
    public void addDayOffRequest(DayOffRequest dayOffRequest) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dayOffRequest);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<DayOffRequest> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from dayoffrequest_tbl ");
        List<DayOffRequest> list = query.list();
        return list;
    }


}
