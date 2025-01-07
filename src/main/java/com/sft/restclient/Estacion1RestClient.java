/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.restclient;

import com.estacionesserver.model.Medicion;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Base64;
import java.util.List;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.ConfigValue;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
/**
 *
 * @author josecollado
 */
@RegisterRestClient()
@Path("/data")
@ClientHeaderParam(name = "Authorization", value = "{lookupAuth}")
//@ApplicationScoped
public interface Estacion1RestClient {

     // <editor-fold defaultstate="collapsed" desc="lookupAuth()">
    default String lookupAuth() {
        /**
         * *
         * Leer las configuraciones del archivo microprofile-config.properties
         */

        String secretKey = "SCox1jmWrkma$*opne2Amwz";

        Config config = ConfigProvider.getConfig();

        String userSecurity = config.getValue("userSecurity", String.class);

        // or
        ConfigValue passwordSecurity = config.getConfigValue("passwordSecurity");

           //        String userDecrypted = Encryptor.decrypt(userSecurity, secretKey,FacesUtil.nameOfClassAndMethod());√ß
//String passwordDecrypted = Encryptor.decrypt(passwordSecurity.getValue(), secretKey,FacesUtil.nameOfClassAndMethod());
        String userDecrypted = userSecurity;
        String passwordDecrypted = passwordSecurity.getValue();
        return "Basic "
                + Base64.getEncoder().encodeToString((userDecrypted + ":" + passwordDecrypted).getBytes());
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Medicion> findAll();    
// </editor-fold>


}