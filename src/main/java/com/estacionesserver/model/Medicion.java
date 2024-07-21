/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Entity
public class Medicion {
    @Id(strategy = GenerationType.OBJECTID, commentary = "Valor maximo 9,223,372,036,854,775,807" )
    private ObjectId _id;
    @Column
    private Long idestacion;
    @Column
    private Date fechahora;
    @Column
    private Double co;
    @Column
    private Double o3;
    @Column
    private Double so2;
    @Column
    private Double no2;
    @Column
    private Double pm25;
    @Column
    private Double pm10;
    @Column
    private Double temperatura;    
    @Column
    private Double humedad;
    @Column
    private Double lluvia;
    @Column
    private Double dir_Viento;
    @Column
    private Double vel_Viento;

    public Medicion() {
    }

    public Medicion(ObjectId _id, Long idestacion, Date fechahora, Double co, Double o3, Double so2, Double no2, Double pm25, Double pm10, Double temperatura, Double humedad, Double lluvia, Double dir_Viento, Double vel_Viento) {
        this._id = _id;
        this.idestacion = idestacion;
        this.fechahora = fechahora;
        this.co = co;
        this.o3 = o3;
        this.so2 = so2;
        this.no2 = no2;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.lluvia = lluvia;
        this.dir_Viento = dir_Viento;
        this.vel_Viento = vel_Viento;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

   


    public Long getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(Long idestacion) {
        this.idestacion = idestacion;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getO3() {
        return o3;
    }

    public void setO3(Double o3) {
        this.o3 = o3;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public Double getLluvia() {
        return lluvia;
    }

    public void setLluvia(Double lluvia) {
        this.lluvia = lluvia;
    }

    public Double getDir_Viento() {
        return dir_Viento;
    }

    public void setDir_Viento(Double dir_Viento) {
        this.dir_Viento = dir_Viento;
    }

    public Double getVel_Viento() {
        return vel_Viento;
    }

    public void setVel_Viento(Double vel_Viento) {
        this.vel_Viento = vel_Viento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this._id);
        hash = 71 * hash + Objects.hashCode(this.idestacion);
        hash = 71 * hash + Objects.hashCode(this.fechahora);
        hash = 71 * hash + Objects.hashCode(this.co);
        hash = 71 * hash + Objects.hashCode(this.o3);
        hash = 71 * hash + Objects.hashCode(this.so2);
        hash = 71 * hash + Objects.hashCode(this.no2);
        hash = 71 * hash + Objects.hashCode(this.pm25);
        hash = 71 * hash + Objects.hashCode(this.pm10);
        hash = 71 * hash + Objects.hashCode(this.temperatura);
        hash = 71 * hash + Objects.hashCode(this.humedad);
        hash = 71 * hash + Objects.hashCode(this.lluvia);
        hash = 71 * hash + Objects.hashCode(this.dir_Viento);
        hash = 71 * hash + Objects.hashCode(this.vel_Viento);
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
        final Medicion other = (Medicion) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.idestacion, other.idestacion)) {
            return false;
        }
        if (!Objects.equals(this.fechahora, other.fechahora)) {
            return false;
        }
        if (!Objects.equals(this.co, other.co)) {
            return false;
        }
        if (!Objects.equals(this.o3, other.o3)) {
            return false;
        }
        if (!Objects.equals(this.so2, other.so2)) {
            return false;
        }
        if (!Objects.equals(this.no2, other.no2)) {
            return false;
        }
        if (!Objects.equals(this.pm25, other.pm25)) {
            return false;
        }
        if (!Objects.equals(this.pm10, other.pm10)) {
            return false;
        }
        if (!Objects.equals(this.temperatura, other.temperatura)) {
            return false;
        }
        if (!Objects.equals(this.humedad, other.humedad)) {
            return false;
        }
        if (!Objects.equals(this.lluvia, other.lluvia)) {
            return false;
        }
        if (!Objects.equals(this.dir_Viento, other.dir_Viento)) {
            return false;
        }
        return Objects.equals(this.vel_Viento, other.vel_Viento);
    }

    @Override
    public String toString() {
        return "Medicion{" + "_id=" + _id.toString() + ", idestacion=" + idestacion + ", fechahora=" + fechahora + ", co=" + co + ", o3=" + o3 + ", so2=" + so2 + ", no2=" + no2 + ", pm25=" + pm25 + ", pm10=" + pm10 + ", temperatura=" + temperatura + ", humedad=" + humedad + ", lluvia=" + lluvia + ", dir_Viento=" + dir_Viento + ", vel_Viento=" + vel_Viento + '}';
    }

   
   
    
    
    
    
}