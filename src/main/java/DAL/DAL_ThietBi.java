/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DTO_LoaiThietBi;
import DTO.DTO_ThietBi;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author ADMIN
 */
public class DAL_ThietBi {
      private static SessionFactory factory =new Configuration().configure().buildSessionFactory();;
    public List listEquipment(int loaiTB,String search,String searchfor) {
         List<DTO_ThietBi> danhsachthietbi = null ;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql="From DTO_ThietBi";
            if(loaiTB>=1)
            {
            sql=sql+" u where u.loaiTB.idLoaiThietBi="+loaiTB;
            }
            if (!search.trim().equals(""))
                
            {
                if (loaiTB==0)
                    sql=sql+" u where ";
                else
                    sql=sql+" and ";
              sql=sql+searchfor+" like '%"+search+"%'"; 
            }
            
            danhsachthietbi = session.createQuery(sql).list();
            
            
        tx.commit();
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
         return danhsachthietbi;
    }
    
    
    public int addEquipment(int loaithietbi,String tenTB,String GhiChu)
    {
        int idEquipment=0;
        Session session = factory.openSession();
        int minidLTB = loaithietbi*100000;
        int maxidLTB = minidLTB +99999;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
          try 
          {
              idEquipment=(int) session.createQuery("SELECT MAX(u.maTB) FROM DTO_ThietBi u WHERE u.maTB BETWEEN :minidLTB AND :maxidLTB ").setParameter("minidLTB",minidLTB).setParameter("maxidLTB", maxidLTB).getSingleResult();
              if (idEquipment < maxidLTB)
                    idEquipment = idEquipment + 1;
          }
          catch (NullPointerException e)
          {
              idEquipment=minidLTB;
          }
          DTO_LoaiThietBi LoaiThietBi =session.get(DTO_LoaiThietBi.class,loaithietbi);
          DTO_ThietBi thietbi=new DTO_ThietBi(idEquipment,tenTB,GhiChu,LoaiThietBi);
           session.save(thietbi);
            tx.commit();       
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
        return idEquipment;
    }
    public int addEquipmentExcel(int maThietBi,String tenTB,String GhiChu)
    {
        int idEquipment=0;
        Session session = factory.openSession();
        int loaithietbi=Integer.valueOf(String.valueOf(String.valueOf(maThietBi).charAt(0)));
        
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            DTO_ThietBi se=(DTO_ThietBi) session.get(DTO_ThietBi.class,maThietBi);
            
            if (se!=null)
            {
                int minidLTB = loaithietbi*100000;
                int maxidLTB = minidLTB +99999;
                 idEquipment=(int) session.createQuery("SELECT MAX(u.maTB) FROM DTO_ThietBi u WHERE u.maTB BETWEEN :minidLTB AND :maxidLTB ").setParameter("minidLTB",minidLTB).setParameter("maxidLTB", maxidLTB).getSingleResult();
              if (idEquipment < maxidLTB)
                    idEquipment = idEquipment + 1;
            }
            else
            {
                idEquipment=maThietBi;
            }
          DTO_LoaiThietBi LoaiThietBi =session.get(DTO_LoaiThietBi.class,loaithietbi);
          DTO_ThietBi thietbi=new DTO_ThietBi(idEquipment,tenTB,GhiChu,LoaiThietBi);
           session.save(thietbi);
            tx.commit();       
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
        return idEquipment;
    }
    public void updateEquipment(int ID,String a,String b){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            DTO_ThietBi thietbi=(DTO_ThietBi) session.get(DTO_ThietBi.class,ID);
            thietbi.setTenTB(a);
            thietbi.setMoTaTB(b);
            session.update(thietbi);           
            tx.commit();       
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
    }
    
     public String deleteEquipment(int ID){
        Session session = factory.openSession();
        Transaction tx = null;
        String str="Thiết bị đã được xóa thành công !";
        try {
            tx = session.beginTransaction();
            DTO_ThietBi thietbi=(DTO_ThietBi) session.get(DTO_ThietBi.class,ID);
        
            session.delete(thietbi);           
            tx.commit();       
             } catch (HibernateException e){
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
        str="Thiết bị này không thể xóa vì đã có thành viên sử dụng !";
         } finally {
             session.close();
         }
        return str;
    }
     public void deleteEquipmentByCondition(List listThietBi){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
             
        for (Iterator iterator = listThietBi.iterator(); iterator.hasNext();) {
        DTO_ThietBi thietbi = (DTO_ThietBi) iterator.next();
        
        session.delete(thietbi);   
       
           }
            tx.commit();       
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
    }
     public DTO_ThietBi findEquipmentByID(int id){
          Session session = factory.openSession(); 
          
              DTO_ThietBi thietbi=session.load(DTO_ThietBi.class,id)  ;
              return thietbi;
          
           
    }
      public List findEquipmentByCondition(int loaiTB) {
         List<DTO_ThietBi> danhsachthietbi = null ;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql="select DTO_ThietBi.* from DTO_ThietBi where DTO_ThietBi.loaiTB="+loaiTB;
            danhsachthietbi = session.createQuery(sql).list();
            
        tx.commit();
             } catch (HibernateException e) {
          if (tx != null)
         tx.rollback();
        e.printStackTrace();
         } finally {
             session.close();
         }
         return danhsachthietbi;
    }
    

    
}
