/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.services;

import com.estacionesserver.model.Medicion;
import com.sft.restclient.Estacion1RestClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.net.URI;
import java.util.List;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

/**
 *
 * @author josecollado
 */
@ApplicationScoped
public class Estacion1ServicesImpl implements Estacion1Services{
    
    @Inject
    Estacion1RestClient estacion1RestClient;
    
    @Override
    public List<Medicion> findAll(String url){
        Estacion1RestClient client = RestClientBuilder.newBuilder().baseUri(URI.create(url)).build(Estacion1RestClient.class);
        return client.findAll();
    }
}
