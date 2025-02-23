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
public class Province {

    @Id(strategy = GenerationType.AUTO)
    private Long idprovince;
    @Column
    private Boolean active;
    @Referenced(from = "country", localField = "idcountry")
    private Country country;

    @Column
    private String province;

    @Embedded
List<ActionHistory> actionHistory;
    public Province() {
    }

    public Province(Long idprovince, Boolean active, Country country, String province, List<ActionHistory> actionHistory) {
        this.idprovince = idprovince;
        this.active = active;
        this.country = country;
        this.province = province;
        this.actionHistory = actionHistory;
    }

    public Long getIdprovince() {
        return idprovince;
    }

    public void setIdprovince(Long idprovince) {
        this.idprovince = idprovince;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("Province{");
        sb.append("idprovince=").append(idprovince);
        sb.append(", active=").append(active);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idprovince);
        hash = 89 * hash + Objects.hashCode(this.active);
        hash = 89 * hash + Objects.hashCode(this.country);
        hash = 89 * hash + Objects.hashCode(this.province);
        hash = 89 * hash + Objects.hashCode(this.actionHistory);
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
        final Province other = (Province) obj;
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        if (!Objects.equals(this.idprovince, other.idprovince)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    
    
    

}
