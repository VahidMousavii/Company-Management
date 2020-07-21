package ir.dotin.da;

import ir.dotin.entity.Category;
import ir.dotin.entity.SubCategory;
import ir.dotin.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class CategoryDA {
    public void addCategory(Category category) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public SubCategory findByName(String name) {
        Session session = null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from sub_category_tbl sc where sc.subCategoryName like :name");
            query.setParameter("name", name);
            SubCategory subCategory = (SubCategory) query.uniqueResult();
            Hibernate.initialize(subCategory.getPersonList());
            Hibernate.initialize(subCategory.getOffRequestList());
            return subCategory;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
