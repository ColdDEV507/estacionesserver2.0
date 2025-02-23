/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewReferenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity()
public class User {

    @Id(strategy = GenerationType.AUTO)
    private Long iduser;
    @Column
    private String username;

    @Column
    private String cellphone;
    @Column
    private String email;
    @Column
    private String identificationcard;
    @Column
    private String sex;
    @Column
    private String socialsecuritynumber;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String photo;

    @Column
    private Date dateofbirth;

    @ViewReferenced(from = "central", localField = "idcentral")
    private CentralView centralView;

    @Embedded
    List<Profile> profile;

    @Column
    private Boolean active;
    
    @Column
    private Boolean recibirNotificacion;
    @Column
    private String theme;

    @Embedded
    List<ActionHistory> actionHistory;

    public User() {
    }

    public User(Long iduser, String username, String cellphone, String email, String identificationcard, String sex, String socialsecuritynumber, String name, String password, String photo, Date dateofbirth, CentralView centralView, List<Profile> profile, Boolean active, Boolean recibirNotificacion, String theme, List<ActionHistory> actionHistory) {
        this.iduser = iduser;
        this.username = username;
        this.cellphone = cellphone;
        this.email = email;
        this.identificationcard = identificationcard;
        this.sex = sex;
        this.socialsecuritynumber = socialsecuritynumber;
        this.name = name;
        this.password = password;
        this.photo = photo;
        this.dateofbirth = dateofbirth;
        this.centralView = centralView;
        this.profile = profile;
        this.active = active;
        this.recibirNotificacion = recibirNotificacion;
        this.theme = theme;
        this.actionHistory = actionHistory;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificationcard() {
        return identificationcard;
    }

    public void setIdentificationcard(String identificationcard) {
        this.identificationcard = identificationcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSocialsecuritynumber() {
        return socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public CentralView getCentralView() {
        return centralView;
    }

    public void setCentralView(CentralView centralView) {
        this.centralView = centralView;
    }

    public List<Profile> getProfile() {
        return profile;
    }

    public void setProfile(List<Profile> profile) {
        this.profile = profile;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getRecibirNotificacion() {
        return recibirNotificacion;
    }

    public void setRecibirNotificacion(Boolean recibirNotificacion) {
        this.recibirNotificacion = recibirNotificacion;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
        hash = 23 * hash + Objects.hashCode(this.iduser);
        hash = 23 * hash + Objects.hashCode(this.username);
        hash = 23 * hash + Objects.hashCode(this.cellphone);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.identificationcard);
        hash = 23 * hash + Objects.hashCode(this.sex);
        hash = 23 * hash + Objects.hashCode(this.socialsecuritynumber);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + Objects.hashCode(this.photo);
        hash = 23 * hash + Objects.hashCode(this.dateofbirth);
        hash = 23 * hash + Objects.hashCode(this.centralView);
        hash = 23 * hash + Objects.hashCode(this.profile);
        hash = 23 * hash + Objects.hashCode(this.active);
        hash = 23 * hash + Objects.hashCode(this.recibirNotificacion);
        hash = 23 * hash + Objects.hashCode(this.theme);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.cellphone, other.cellphone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.identificationcard, other.identificationcard)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.socialsecuritynumber, other.socialsecuritynumber)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        if (!Objects.equals(this.dateofbirth, other.dateofbirth)) {
            return false;
        }
        if (!Objects.equals(this.centralView, other.centralView)) {
            return false;
        }
        if (!Objects.equals(this.profile, other.profile)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.recibirNotificacion, other.recibirNotificacion)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "User{" + "iduser=" + iduser + ", username=" + username + ", cellphone=" + cellphone + ", email=" + email + ", identificationcard=" + identificationcard + ", sex=" + sex + ", socialsecuritynumber=" + socialsecuritynumber + ", name=" + name + ", password=" + password + ", photo=" + photo + ", dateofbirth=" + dateofbirth + ", centralView=" + centralView + ", profile=" + profile + ", active=" + active + ", recibirNotificacion=" + recibirNotificacion + ", theme=" + theme + ", actionHistory=" + actionHistory + '}';
    }

    
    
}
