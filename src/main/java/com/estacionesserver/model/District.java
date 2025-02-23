/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity()
public class District {

   @Id(strategy = GenerationType.AUTO)
    private Long iddistrict;
    @Column
    private Boolean active;
    @Column
    private String district;

    @Referenced(from = "province", localField = "idprovince")
    private Province province;
    
    @Embedded
List<ActionHistory> actionHistory;

    public District() {
    }

    public District(Long iddistrict, Boolean active, String district, Province province, List<ActionHistory> actionHistory) {
        this.iddistrict = iddistrict;
        this.active = active;
        this.district = district;
        this.province = province;
        this.actionHistory = actionHistory;
    }

    public Long getIddistrict() {
        return iddistrict;
    }

    public void setIddistrict(Long iddistrict) {
        this.iddistrict = iddistrict;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public String toString() {
        return "District{" + "iddistrict=" + iddistrict + ", active=" + active + ", district=" + district + ", province=" + province + ", actionHistory=" + actionHistory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.iddistrict);
        hash = 17 * hash + Objects.hashCode(this.active);
        hash = 17 * hash + Objects.hashCode(this.district);
        hash = 17 * hash + Objects.hashCode(this.province);
        hash = 17 * hash + Objects.hashCode(this.actionHistory);
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
        final District other = (District) obj;
        if (!Objects.equals(this.district, other.district)) {
            return false;
        }
        if (!Objects.equals(this.iddistrict, other.iddistrict)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }
    
}
