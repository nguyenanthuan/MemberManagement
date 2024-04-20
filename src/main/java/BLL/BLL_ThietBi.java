/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DAL_ThietBi;
import DTO.DTO_ThietBi;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BLL_ThietBi {
     DAL_ThietBi thietbiDAL =new DAL_ThietBi();
   public List listEquipment(int loaiTB,String search,String searchfor)
   {
       return thietbiDAL.listEquipment(loaiTB, search, searchfor);
   }
   public int addEquipment(int loaithietbi,String tenTB,String GhiChu)
   {
       return thietbiDAL.addEquipment(loaithietbi, tenTB, GhiChu);
   }
   public int addEquipmentExcel(int maThietBi,String tenTB,String GhiChu)
   {
       return thietbiDAL.addEquipmentExcel(maThietBi, tenTB, GhiChu);
   }
    public void updateEquipment(int ID,String a,String b){
        thietbiDAL.updateEquipment(ID, a, b);
    }
    public String deleteEquipment(int ID){
        return thietbiDAL.deleteEquipment(ID);
    }
     public void deleteEquipmentByCondition(List listThietBi){
         thietbiDAL.deleteEquipmentByCondition(listThietBi);
     }
     public DTO_ThietBi findEquipmentByID(int id){
         return thietbiDAL.findEquipmentByID(id);
     }
      public List findEquipmentByCondition(int loaiTB) {
          return thietbiDAL.findEquipmentByCondition(loaiTB);
      }
    
}
