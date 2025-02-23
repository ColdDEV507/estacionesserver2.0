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
@Entity
public class Central {
     @Id(strategy = GenerationType.AUTO)
    private Long idcentral;
    @Column
    private String central;
    @Column
    private Boolean active;
    @Referenced(from = "institution", localField = "idinstitution")
    private Institution institution;

    @Embedded
List<ActionHistory> actionHistory;
    
    public Central() {
    }

    public Central(Long idcentral, String central, Boolean active, Institution institution, List<ActionHistory> actionHistory) {
        this.idcentral = idcentral;
        this.central = central;
        this.active = active;
        this.institution = institution;
        this.actionHistory = actionHistory;
    }

    public Long getIdcentral() {
        return idcentral;
    }

    public void setIdcentral(Long idcentral) {
        this.idcentral = idcentral;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
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
        sb.append("Central{");
        sb.append("idcentral=").append(idcentral);
        sb.append(", central=").append(central);
        sb.append(", active=").append(active);
        sb.append(", institution=").append(institution);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idcentral);
        hash = 71 * hash + Objects.hashCode(this.central);
        hash = 71 * hash + Objects.hashCode(this.active);
        hash = 71 * hash + Objects.hashCode(this.institution);
        hash = 71 * hash + Objects.hashCode(this.actionHistory);
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
        final Central other = (Central) obj;
        if (!Objects.equals(this.central, other.central)) {
            return false;
        }
        if (!Objects.equals(this.idcentral, other.idcentral)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.institution, other.institution)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   

   
    
    
    
}
