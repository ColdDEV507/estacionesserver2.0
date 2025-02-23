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
public class Area {
    @Id(strategy = GenerationType.AUTO)
      private Long idarea;
    @Column
    private String area;
    @Column
    private String nombrecorto;
    @Column 
    private Boolean active;
       @Embedded
List<ActionHistory> actionHistory;

    public Area() {
    }

    public Area(Long idarea, String area, String nombrecorto, Boolean active, List<ActionHistory> actionHistory) {
        this.idarea = idarea;
        this.area = area;
        this.nombrecorto = nombrecorto;
        this.active = active;
        this.actionHistory = actionHistory;
    }

    public Long getIdarea() {
        return idarea;
    }

    public void setIdarea(Long idarea) {
        this.idarea = idarea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto;
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
        sb.append("Area{");
        sb.append("idarea=").append(idarea);
        sb.append(", area=").append(area);
        sb.append(", nombrecorto=").append(nombrecorto);
        sb.append(", active=").append(active);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idarea);
        hash = 67 * hash + Objects.hashCode(this.area);
        hash = 67 * hash + Objects.hashCode(this.nombrecorto);
        hash = 67 * hash + Objects.hashCode(this.active);
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
        final Area other = (Area) obj;
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.nombrecorto, other.nombrecorto)) {
            return false;
        }
        if (!Objects.equals(this.idarea, other.idarea)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

 
    
}
