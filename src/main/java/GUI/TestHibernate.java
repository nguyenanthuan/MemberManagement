/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.DTO_ThanhVien;
import java.util.Iterator;
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
public class TestHibernate {
    private static SessionFactory factory;
    
    public static void main(String[] args) {
        try {
         factory = new Configuration().configure().buildSessionFactory();
        } 
        catch (HibernateException ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
        }
        TestHibernate th = new TestHibernate();
        
//        Integer tv1 = th.addThanhVien("Thuan", "CNTT", "KTPM", 79834534);
//        System.out.println(tv1);
        th.listEmployees();
    }
    public Integer addThanhVien(String hoTen, String khoa, String nganh, int SDT){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer tvID = null;

        try {
           tx = session.beginTransaction();
           DTO_ThanhVien tv = new DTO_ThanhVien(1230150184, hoTen, khoa, nganh, SDT);
           tvID = (Integer) session.save(tv); 
           tx.commit();
        } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
        return tvID;
    }
    
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
           tx = session.beginTransaction();
           List lsThanhVien = session.createQuery("FROM DTO_ThanhVien").list(); 
           for (Iterator iterator = lsThanhVien.iterator(); iterator.hasNext();){
              DTO_ThanhVien tv = (DTO_ThanhVien) iterator.next(); 
              System.out.print("MaTV: " + tv.getMaTV());
              System.out.print("  Ho ten: " + tv.getHoTen()); 
              System.out.print("  Khoa: " + tv.getKhoa()); 
              System.out.println("  Nganh: " + tv.getNganh()); 
              //System.out.print("  SDT: " + tv.getSDT());
           }
           tx.commit();
        } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
    }
}
