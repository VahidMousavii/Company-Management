package ir.dotin.da;

import ir.dotin.entity.OffRequest;

import ir.dotin.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class OffRequestDA {
    public void addOffRequest(OffRequest offRequest) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(offRequest);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<OffRequest> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from off_Request_tbl ");
            List<OffRequest> list = query.list();
            session.getTransaction().commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}