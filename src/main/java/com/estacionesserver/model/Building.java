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
public class Building {

    @Id(strategy = GenerationType.AUTO)
    private Long idbuilding;

    @Referenced(from = "central", localField = "idcentral")
    private Central central;

    @Column
    private Boolean active;
    @Column
    private String building;

    @Column
    private String shortname;

    @Embedded
List<ActionHistory> actionHistory;
    
    public Building() {
    }

    public Building(Long idbuilding, Central central, Boolean active, String building, String shortname, List<ActionHistory> actionHistory) {
        this.idbuilding = idbuilding;
        this.central = central;
        this.active = active;
        this.building = building;
        this.shortname = shortname;
        this.actionHistory = actionHistory;
    }

    public Long getIdbuilding() {
        return idbuilding;
    }

    public void setIdbuilding(Long idbuilding) {
        this.idbuilding = idbuilding;
    }

    public Central getCentral() {
        return central;
    }

    public void setCentral(Central central) {
        this.central = central;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idbuilding);
        hash = 89 * hash + Objects.hashCode(this.central);
        hash = 89 * hash + Objects.hashCode(this.active);
        hash = 89 * hash + Objects.hashCode(this.building);
        hash = 89 * hash + Objects.hashCode(this.shortname);
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
        final Building other = (Building) obj;
        if (!Objects.equals(this.building, other.building)) {
            return false;
        }
        if (!Objects.equals(this.shortname, other.shortname)) {
            return false;
        }
        if (!Objects.equals(this.idbuilding, other.idbuilding)) {
            return false;
        }
        if (!Objects.equals(this.central, other.central)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

 
    
    
}
