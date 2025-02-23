/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity()
public class Otp {

    @Id(strategy = GenerationType.AUTO)
    private Long idotp;
    @Column
    private Date expirationdate;
    @Column
    private Long idapplicative;    
    @Column
    private String email;
    @Column
    private Long iduser;
    @Column
    private Boolean isexpired;
    @Column
    private String otp;
    @Column
    private Boolean used;
    @Embedded
    List<ActionHistory> actionHistory;

    public Otp() {
    }

    public Otp(Long idotp, Date expirationdate, Long idapplicative, String email, Long iduser, Boolean isexpired, String otp, Boolean used, List<ActionHistory> actionHistory) {
        this.idotp = idotp;
        this.expirationdate = expirationdate;
        this.idapplicative = idapplicative;
        this.email = email;
        this.iduser = iduser;
        this.isexpired = isexpired;
        this.otp = otp;
        this.used = used;
        this.actionHistory = actionHistory;
    }

    public Long getIdotp() {
        return idotp;
    }

    public void setIdotp(Long idotp) {
        this.idotp = idotp;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Long getIdapplicative() {
        return idapplicative;
    }

    public void setIdapplicative(Long idapplicative) {
        this.idapplicative = idapplicative;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Boolean getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(Boolean isexpired) {
        this.isexpired = isexpired;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public String toString() {
        return "Otp{" + "idotp=" + idotp + ", expirationdate=" + expirationdate + ", idapplicative=" + idapplicative + ", email=" + email + ", iduser=" + iduser + ", isexpired=" + isexpired + ", otp=" + otp + ", used=" + used + ", actionHistory=" + actionHistory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idotp);
        hash = 67 * hash + Objects.hashCode(this.expirationdate);
        hash = 67 * hash + Objects.hashCode(this.idapplicative);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.iduser);
        hash = 67 * hash + Objects.hashCode(this.isexpired);
        hash = 67 * hash + Objects.hashCode(this.otp);
        hash = 67 * hash + Objects.hashCode(this.used);
        hash = 67 * hash + Objects.hashCode(this.actionHistory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Otp other = (Otp) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.otp, other.otp)) {
            return false;
        }
        if (!Objects.equals(this.idotp, other.idotp)) {
            return false;
        }
        if (!Objects.equals(this.expirationdate, other.expirationdate)) {
            return false;
        }
        if (!Objects.equals(this.idapplicative, other.idapplicative)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        if (!Objects.equals(this.isexpired, other.isexpired)) {
            return false;
        }
        if (!Objects.equals(this.used, other.used)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   
  
}
