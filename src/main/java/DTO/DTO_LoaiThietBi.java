/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author ADMIN
 */

@Data
@Entity
@Table(name="loai_thietbi")
public class DTO_LoaiThietBi {
    @Id
    @Column(name = "maLoai")
    private int idLoaiThietBi;
    @Column(name="tenTB")
    private String tenLoaiThietBi;
    
    @OneToMany(mappedBy ="loaiTB")
    private Set<DTO_ThietBi> danhsachthietbi=new HashSet<>();

    public DTO_LoaiThietBi() {
    }
 
    
    public Set<DTO_ThietBi> getDanhSachThietBi() {
	return danhsachthietbi;
    }
 
    public void setDanhSachThietBi(Set<DTO_ThietBi> thietbi) {
	this.danhsachthietbi = thietbi;
    }      

    public DTO_LoaiThietBi(int idLoaiThietBi, String tenLoaiThietBi) {
        this.idLoaiThietBi = idLoaiThietBi;
        this.tenLoaiThietBi = tenLoaiThietBi;
    }

    public int getIdLoaiThietBi() {
        return idLoaiThietBi;
    }

    public void setIdLoaiThietBi(int idLoaiThietBi) {
        this.idLoaiThietBi = idLoaiThietBi;
    }

    public String getTenLoaiThietBi() {
        return tenLoaiThietBi;
    }

    public void setTenLoaiThietBi(String tenLoaiThietBi) {
        this.tenLoaiThietBi = tenLoaiThietBi;
    }
    public String toString()
    {
        return idLoaiThietBi + " " +tenLoaiThietBi;
    }
    
    
    
    
}
