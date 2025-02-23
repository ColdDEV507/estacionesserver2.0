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
public class Township {
    @Id(strategy = GenerationType.AUTO)
    private Long idtownship;
    @Column
    private String township;
    @Column
    private Boolean active;
    
    @Referenced(from = "district", localField = "iddistrict")
    private District district; 
    
       @Embedded
List<ActionHistory> actionHistory;

    public Township() {
    }

    public Township(Long idtownship, String township, Boolean active, District district, List<ActionHistory> actionHistory) {
        this.idtownship = idtownship;
        this.township = township;
        this.active = active;
        this.district = district;
        this.actionHistory = actionHistory;
    }

    public Long getIdtownship() {
        return idtownship;
    }

    public void setIdtownship(Long idtownship) {
        this.idtownship = idtownship;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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
        sb.append("Township{");
        sb.append("idtownship=").append(idtownship);
        sb.append(", township=").append(township);
        sb.append(", active=").append(active);
        sb.append(", district=").append(district);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idtownship);
        hash = 23 * hash + Objects.hashCode(this.township);
        hash = 23 * hash + Objects.hashCode(this.active);
        hash = 23 * hash + Objects.hashCode(this.district);
        hash = 23 * hash + Objects.hashCode(this.actionHistory);
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
        final Township other = (Township) obj;
        if (!Objects.equals(this.township, other.township)) {
            return false;
        }
        if (!Objects.equals(this.idtownship, other.idtownship)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.district, other.district)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   
  
    

 
}
