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
public class Icono {
@Id(strategy = GenerationType.AUTO)
private Long idicono;
@Column
private String icono;

@Embedded
List<ActionHistory> actionHistory;
    public Icono() {
    }

    public Icono(Long idicono, String icono, List<ActionHistory> actionHistory) {
        this.idicono = idicono;
        this.icono = icono;
        this.actionHistory = actionHistory;
    }

    public Long getIdicono() {
        return idicono;
    }

    public void setIdicono(Long idicono) {
        this.idicono = idicono;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
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
        sb.append("Icono{");
        sb.append("idicono=").append(idicono);
        sb.append(", icono=").append(icono);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idicono);
        hash = 61 * hash + Objects.hashCode(this.icono);
        hash = 61 * hash + Objects.hashCode(this.actionHistory);
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
        final Icono other = (Icono) obj;
        if (!Objects.equals(this.icono, other.icono)) {
            return false;
        }
        if (!Objects.equals(this.idicono, other.idicono)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

  

    

}
