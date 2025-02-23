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
@ViewEntity(collection = "applicative")
public class ApplicativeView {

    @Id(strategy = GenerationType.AUTO)
    private Long idapplicative;
    @Column
    private Boolean active;

    @Column
    private String applicative;
    @Column
    private String description;

    @Column
    private String image;
    @Column
    private String path;
    @Column

    private String shortname;
    
   
    public ApplicativeView() {
    }

    public ApplicativeView(Long idapplicative, Boolean active, String applicative, String description, String image, String path, String shortname) {
        this.idapplicative = idapplicative;
        this.active = active;
        this.applicative = applicative;
        this.description = description;
        this.image = image;
        this.path = path;
        this.shortname = shortname;
    }

    public Long getIdapplicative() {
        return idapplicative;
    }

    public void setIdapplicative(Long idapplicative) {
        this.idapplicative = idapplicative;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getApplicative() {
        return applicative;
    }

    public void setApplicative(String applicative) {
        this.applicative = applicative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApplicativeView{");
        sb.append("idapplicative=").append(idapplicative);
        sb.append(", active=").append(active);
        sb.append(", applicative=").append(applicative);
        sb.append(", description=").append(description);
        sb.append(", image=").append(image);
        sb.append(", path=").append(path);
        sb.append(", shortname=").append(shortname);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idapplicative);
        hash = 59 * hash + Objects.hashCode(this.active);
        hash = 59 * hash + Objects.hashCode(this.applicative);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.image);
        hash = 59 * hash + Objects.hashCode(this.path);
        hash = 59 * hash + Objects.hashCode(this.shortname);
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
        final ApplicativeView other = (ApplicativeView) obj;
        if (!Objects.equals(this.applicative, other.applicative)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.shortname, other.shortname)) {
            return false;
        }
        if (!Objects.equals(this.idapplicative, other.idapplicative)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

   
   

   
  

    
    
    
}
