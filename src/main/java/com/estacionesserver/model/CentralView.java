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
@ViewEntity(collection = "central")
public class CentralView {
    @Id(strategy = GenerationType.AUTO)
    private Long idcentral;
    @Column
    private String central;
    @Column
    private Boolean active;
  

    public CentralView() {
    }

    public CentralView(Long idcentral, String central, Boolean active) {
        this.idcentral = idcentral;
        this.central = central;
        this.active = active;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CentralView{");
        sb.append("idcentral=").append(idcentral);
        sb.append(", central=").append(central);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idcentral);
        hash = 23 * hash + Objects.hashCode(this.central);
        hash = 23 * hash + Objects.hashCode(this.active);
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
        final CentralView other = (CentralView) obj;
        if (!Objects.equals(this.central, other.central)) {
            return false;
        }
        if (!Objects.equals(this.idcentral, other.idcentral)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

  

   
   
    
    
    
}
