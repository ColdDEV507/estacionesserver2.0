/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.services;

import com.estacionesserver.model.Medicion;
import com.sft.restclient.Estacion1RestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author josecollado
 */
public interface Estacion1Services{

public List<Medicion> findAll(String url);
}
