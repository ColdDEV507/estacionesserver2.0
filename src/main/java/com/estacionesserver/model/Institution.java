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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Institution {
   @Id(strategy = GenerationType.AUTO)
  private Long idinstitution;
   @Column
   private String institution;
   
   @Column
   private Boolean active;
   
   @Embedded
List<ActionHistory> actionHistory;

    public Institution() {
    }

    public Institution(Long idinstitution, String institution, Boolean active, List<ActionHistory> actionHistory) {
        this.idinstitution = idinstitution;
        this.institution = institution;
        this.active = active;
        this.actionHistory = actionHistory;
    }

    public Long getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Long idinstitution) {
        this.idinstitution = idinstitution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        sb.append("Institution{");
        sb.append("idinstitution=").append(idinstitution);
        sb.append(", institution=").append(institution);
        sb.append(", active=").append(active);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idinstitution);
        hash = 83 * hash + Objects.hashCode(this.institution);
        hash = 83 * hash + Objects.hashCode(this.active);
        hash = 83 * hash + Objects.hashCode(this.actionHistory);
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
        final Institution other = (Institution) obj;
        if (!Objects.equals(this.institution, other.institution)) {
            return false;
        }
        if (!Objects.equals(this.idinstitution, other.idinstitution)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   
    

}
