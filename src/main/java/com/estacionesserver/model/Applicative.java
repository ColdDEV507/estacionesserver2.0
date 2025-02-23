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
public class Applicative {

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
    
    @Embedded
    List<Applicativerole> applicativerole;
    
    @Embedded
    List<Emailconfiguration> emailconfiguration;
    
    @Embedded
    List<Applicativeprivilege> applicativeprivilege;
@Embedded
List<ActionHistory> actionHistory;
    public Applicative() {
    }

    public Applicative(Long idapplicative, Boolean active, String applicative, String description, String image, String path, String shortname, List<Applicativerole> applicativerole, List<Emailconfiguration> emailconfiguration, List<Applicativeprivilege> applicativeprivilege, List<ActionHistory> actionHistory) {
        this.idapplicative = idapplicative;
        this.active = active;
        this.applicative = applicative;
        this.description = description;
        this.image = image;
        this.path = path;
        this.shortname = shortname;
        this.applicativerole = applicativerole;
        this.emailconfiguration = emailconfiguration;
        this.applicativeprivilege = applicativeprivilege;
        this.actionHistory = actionHistory;
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

    public List<Applicativerole> getApplicativerole() {
        return applicativerole;
    }

    public void setApplicativerole(List<Applicativerole> applicativerole) {
        this.applicativerole = applicativerole;
    }

    public List<Emailconfiguration> getEmailconfiguration() {
        return emailconfiguration;
    }

    public void setEmailconfiguration(List<Emailconfiguration> emailconfiguration) {
        this.emailconfiguration = emailconfiguration;
    }

    public List<Applicativeprivilege> getApplicativeprivilege() {
        return applicativeprivilege;
    }

    public void setApplicativeprivilege(List<Applicativeprivilege> applicativeprivilege) {
        this.applicativeprivilege = applicativeprivilege;
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
        sb.append("Applicative{");
        sb.append("idapplicative=").append(idapplicative);
        sb.append(", active=").append(active);
        sb.append(", applicative=").append(applicative);
        sb.append(", description=").append(description);
        sb.append(", image=").append(image);
        sb.append(", path=").append(path);
        sb.append(", shortname=").append(shortname);
        sb.append(", applicativerole=").append(applicativerole);
        sb.append(", emailconfiguration=").append(emailconfiguration);
        sb.append(", applicativeprivilege=").append(applicativeprivilege);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idapplicative);
        hash = 73 * hash + Objects.hashCode(this.active);
        hash = 73 * hash + Objects.hashCode(this.applicative);
        hash = 73 * hash + Objects.hashCode(this.description);
        hash = 73 * hash + Objects.hashCode(this.image);
        hash = 73 * hash + Objects.hashCode(this.path);
        hash = 73 * hash + Objects.hashCode(this.shortname);
        hash = 73 * hash + Objects.hashCode(this.applicativerole);
        hash = 73 * hash + Objects.hashCode(this.emailconfiguration);
        hash = 73 * hash + Objects.hashCode(this.applicativeprivilege);
        hash = 73 * hash + Objects.hashCode(this.actionHistory);
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
        final Applicative other = (Applicative) obj;
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
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.applicativerole, other.applicativerole)) {
            return false;
        }
        if (!Objects.equals(this.emailconfiguration, other.emailconfiguration)) {
            return false;
        }
        if (!Objects.equals(this.applicativeprivilege, other.applicativeprivilege)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   
   

   
  

    
    
    
}
