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
public class Departament {

    @Id(strategy = GenerationType.AUTO)
    private Long iddepartament;
    @Column
    private String departament;
    @Column
    private String shortname;

    @Column
    private Boolean active;

    @Referenced(from = "central", localField = "idcentral")
    private Central central;

    @Embedded
List<ActionHistory> actionHistory;
    public Departament() {
    }

    public Departament(Long iddepartament, String departament, String shortname, Boolean active, Central central, List<ActionHistory> actionHistory) {
        this.iddepartament = iddepartament;
        this.departament = departament;
        this.shortname = shortname;
        this.active = active;
        this.central = central;
        this.actionHistory = actionHistory;
    }

    public Long getIddepartament() {
        return iddepartament;
    }

    public void setIddepartament(Long iddepartament) {
        this.iddepartament = iddepartament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Central getCentral() {
        return central;
    }

    public void setCentral(Central central) {
        this.central = central;
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
        sb.append("Departament{");
        sb.append("iddepartament=").append(iddepartament);
        sb.append(", departament=").append(departament);
        sb.append(", shortname=").append(shortname);
        sb.append(", active=").append(active);
        sb.append(", central=").append(central);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.iddepartament);
        hash = 37 * hash + Objects.hashCode(this.departament);
        hash = 37 * hash + Objects.hashCode(this.shortname);
        hash = 37 * hash + Objects.hashCode(this.active);
        hash = 37 * hash + Objects.hashCode(this.central);
        hash = 37 * hash + Objects.hashCode(this.actionHistory);
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
        final Departament other = (Departament) obj;
        if (!Objects.equals(this.departament, other.departament)) {
            return false;
        }
        if (!Objects.equals(this.shortname, other.shortname)) {
            return false;
        }
        if (!Objects.equals(this.iddepartament, other.iddepartament)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.central, other.central)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    
   
    

}
