/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Estacion {
    @Id 
    private Long idestacion;
    @Column
    private String estacion;
    @Column
    private String descripcion;
    @Column
    private String latitud;
    @Column
    private String longitud;
    @Column
    private Boolean activo;

    public Estacion() {
    }

    public Estacion(Long idestacion, String estacion, String descripcion, Boolean activo, String latitud, String longitud) {
        this.idestacion = idestacion;
        this.estacion = estacion;
        this.descripcion = descripcion;
        this.activo = activo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(Long idestacion) {
        this.idestacion = idestacion;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public String getLatitud(){
        return latitud;
    }
    
    public void setLatitud(String latitud){
        this.latitud = latitud;
    }
    
    public String getLongitud(){
        return longitud;
    }
    
    public void setLongitud(String longitud){
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idestacion);
        hash = 83 * hash + Objects.hashCode(this.estacion);
        hash = 83 * hash + Objects.hashCode(this.descripcion);
        hash = 83 * hash + Objects.hashCode(this.activo);
        hash = 83 * hash + Objects.hashCode(this.latitud);
        hash = 83 * hash + Objects.hashCode(this.longitud);
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
        final Estacion other = (Estacion) obj;
        if (!Objects.equals(this.estacion, other.estacion)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.idestacion, other.idestacion)) {
            return false;
        }
        if (!Objects.equals(this.idestacion, other.longitud)) {
            return false;
        }
        if (!Objects.equals(this.idestacion, other.latitud)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Estacion{" + "idestacion=" + idestacion + ", estacion=" + estacion + ", descripcion=" + descripcion + ", latitud=" + latitud + ", longitud=" + longitud + ", activo=" + activo + '}';
    }

   
    
    
}
