/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_LoaiThietBi;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ADMIN
 */
public class DAL_LoaiThietBi {
    private static SessionFactory factory =new Configuration().configure().buildSessionFactory();

    public DAL_LoaiThietBi() {
    }
    
    public List listLoaiThietBi() {
         List<DTO_LoaiThietBi> listLTB = null ;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listLTB = session.createQuery("FROM DTO_LoaiThietBi").list();
            
        tx.commit();
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
         return listLTB;
    }
}
