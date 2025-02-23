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
@ViewEntity(collection = "user")
public class UserView {

    @Id(strategy = GenerationType.AUTO)
    private Long iduser;

    @Column
    private String name;

    @Column
    private String photo;

    @Column
    private String email;

    @Column
    private Boolean recibirNotificacion;

    public UserView() {
    }

    public UserView(Long iduser, String name, String photo, String email, Boolean recibirNotificacion) {
        this.iduser = iduser;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.recibirNotificacion = recibirNotificacion;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRecibirNotificacion() {
        return recibirNotificacion;
    }

    public void setRecibirNotificacion(Boolean recibirNotificacion) {
        this.recibirNotificacion = recibirNotificacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.iduser);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.photo);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.recibirNotificacion);
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
        final UserView other = (UserView) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        return Objects.equals(this.recibirNotificacion, other.recibirNotificacion);
    }

    @Override
    public String toString() {
        return "UserView{" + "iduser=" + iduser + ", name=" + name + ", photo=" + photo + ", email=" + email + ", recibirNotificacion=" + recibirNotificacion + '}';
    }
    
    
    

}
