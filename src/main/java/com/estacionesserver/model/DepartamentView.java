/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewEntity;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@ViewEntity(collection = "departament")
public class DepartamentView {

    @Id(strategy = GenerationType.AUTO)
    private Long iddepartament;
    @Column
    private String departament;
    @Column
    private String shortname;

    @Column
    private Boolean active;

    public DepartamentView() {
    }

    public DepartamentView(Long iddepartament, String departament, String shortname, Boolean active) {
        this.iddepartament = iddepartament;
        this.departament = departament;
        this.shortname = shortname;
        this.active = active;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DepartamentView{");
        sb.append("iddepartament=").append(iddepartament);
        sb.append(", departament=").append(departament);
        sb.append(", shortname=").append(shortname);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.iddepartament);
        hash = 59 * hash + Objects.hashCode(this.departament);
        hash = 59 * hash + Objects.hashCode(this.shortname);
        hash = 59 * hash + Objects.hashCode(this.active);
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
        final DepartamentView other = (DepartamentView) obj;
        if (!Objects.equals(this.departament, other.departament)) {
            return false;
        }
        if (!Objects.equals(this.shortname, other.shortname)) {
            return false;
        }
        if (!Objects.equals(this.iddepartament, other.iddepartament)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

   
   
    

}
