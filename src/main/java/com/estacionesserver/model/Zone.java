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
public class Zone {

    @Id(strategy = GenerationType.AUTO)
    private Long idzone;
    @Column
    private Boolean active;

    @Referenced(from = "building", localField = "idbuilding")
    private Building building;
    @Column
    private String descripcion;
    @Referenced(from = "icono", localField = "idicono", commentary = "Esta asociado a la prioridad")
    private Icono icono;

    @Column
    private String zone;

    @Embedded
    List<ActionHistory> actionHistory;

    public Zone() {
    }

    public Zone(Long idzone, Boolean active, Building building, String descripcion, Icono icono, String zone, List<ActionHistory> actionHistory) {
        this.idzone = idzone;
        this.active = active;
        this.building = building;
        this.descripcion = descripcion;
        this.icono = icono;
        this.zone = zone;
        this.actionHistory = actionHistory;
    }

    public Long getIdzone() {
        return idzone;
    }

    public void setIdzone(Long idzone) {
        this.idzone = idzone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Icono getIcono() {
        return icono;
    }

    public void setIcono(Icono icono) {
        this.icono = icono;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public String toString() {
        return "Zone{" + "idzone=" + idzone + ", active=" + active + ", building=" + building + ", descripcion=" + descripcion + ", icono=" + icono + ", zone=" + zone + ", actionHistory=" + actionHistory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idzone);
        hash = 23 * hash + Objects.hashCode(this.active);
        hash = 23 * hash + Objects.hashCode(this.building);
        hash = 23 * hash + Objects.hashCode(this.descripcion);
        hash = 23 * hash + Objects.hashCode(this.icono);
        hash = 23 * hash + Objects.hashCode(this.zone);
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
        final Zone other = (Zone) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.zone, other.zone)) {
            return false;
        }
        if (!Objects.equals(this.idzone, other.idzone)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.building, other.building)) {
            return false;
        }
        if (!Objects.equals(this.icono, other.icono)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }


    
    
    
    
    
    
}
