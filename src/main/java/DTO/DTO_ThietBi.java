package DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
@Data
@Entity
@Table(name="thietbi")
public class DTO_ThietBi {
    @Id
    @Column(name = "MaTB")
    private int maTB;
    
    @Column(name="TenTB")
    private String tenTB;
    
    @Column(name="MoTaTB")
    private String MoTaTB;
    
    @ManyToOne
    @JoinColumn(name="maLTB" ,nullable=false,
            foreignKey=@ForeignKey(name="fk_ThietBi_LoaiThietBi"))
    private DTO_LoaiThietBi loaiTB ;

    public DTO_ThietBi() {
    }

    public DTO_ThietBi(int maTB, String tenTB, String MoTaTB, DTO_LoaiThietBi loaiTB) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.MoTaTB = MoTaTB;
        this.loaiTB = loaiTB;
    }

    
    public DTO_ThietBi(int maTB, String tenTB, String MoTaTB) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.MoTaTB = MoTaTB;
    }
    
    public DTO_LoaiThietBi getLoaiThietBi() {
        return loaiTB;
    }
    
    public void setLoaiThietBi(DTO_LoaiThietBi loaithietbi) {
        this.loaiTB=loaithietbi;
    }
    public int getMaTB() {
        return maTB;
    }

    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMoTaTB() {
        return MoTaTB;
    }

    public void setMoTaTB(String MoTaTB) {
        this.MoTaTB = MoTaTB;
    }
    
    
    
    
}
