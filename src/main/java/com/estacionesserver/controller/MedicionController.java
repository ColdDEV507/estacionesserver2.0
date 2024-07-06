/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.estacionesserver.model.Medicion;
import com.estacionesserver.repository.MedicionRepository;
import com.estacionesserver.repository.EstacionRepository;
import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordb.core.util.JmoordbCoreDateUtil;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author avbravo
 */
@Path("medicion")
@Tag(name = "Información del medicion", description = "End-point para entidad Medicion")
@RolesAllowed({"admin"})
@RequestScoped
public class MedicionController implements Serializable {

    private String nameOfCollection = "medicion_";
    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    MedicionRepository medicionRepository;
    @Inject
    EstacionRepository estacionRepository;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Medicion findByIdmedicionIdproyecto(@QueryParam("idmedicion") Long idmedicion,       @QueryParam("anio") Long anio  ) ">
    @GET
    @RolesAllowed({"admin"})
    @Path("idmedicionanio")
    @Operation(summary = "Busca un medicion por el idmedicion", description = "Busqueda de medicion por idmedicion")
    @APIResponse(responseCode = "200", description = "El medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idmedicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El medicion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))
    public Medicion findByIdmedicionIdproyecto(@QueryParam("idmedicion") Long idmedicion, @QueryParam("anio") Long anio) {

        medicionRepository.setDynamicCollection(nameOfCollection + anio);
        return medicionRepository.findByPk(idmedicion).orElseThrow(
                () -> new WebApplicationException("No hay medicion con idmedicion " + idmedicion, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo medicion", description = "Inserta un nuevo medicion")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo medicion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Medicion.class))) Medicion medicion) {

        /**
         * Genera base de datos para cada año
         * formato: lectura_añodb
         *    lecturas_2024db
         * 
         * Para las colecciones seria
         * el primer digito indica la estacion, el segundo digito sera el mes
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         * ----------------------
         *   lecturas_2025db
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         */
        medicionRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(medicion.getFechahora()).toString().trim() + "db");
        Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith0(medicion.getFechahora());
        medicionRepository.setDynamicCollection(nameOfCollection + medicion.getIdestacion().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

        Optional<Medicion> medicionOptional = medicionRepository.save(medicion);
        if (medicionOptional.isPresent()) {
  

            return Response.status(201).entity(medicionOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo medicion", description = "Inserta un nuevo medicion")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response update(
            @RequestBody(description = "Crea un nuevo medicion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Medicion.class))) Medicion medicion) {
         /**
         * Genera base de datos para cada año
         * formato: lectura_añodb
         *    lecturas_2024db
         * 
         * Para las colecciones seria
         * el primer digito indica la estacion, el segundo digito sera el mes
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         * ----------------------
         *   lecturas_2025db
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         */
        medicionRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(medicion.getFechahora()).toString().trim() + "db");
        Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith1(medicion.getFechahora());
        medicionRepository.setDynamicCollection(nameOfCollection + medicion.getIdestacion().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));


        if (medicionRepository.update(medicion)) {
          
            return Response.status(201).entity(medicion).build();
        } else {
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod());
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod() + " [error] " + medicionRepository.getJmoordbException().getLocalizedMessage());
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete(@QueryParam("idmedicion") Long idmedicion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) ">
    @DELETE
    @RolesAllowed({"admin"})
    @Path("idmedicionanio")
    @Operation(summary = "Elimina un medicion por  idmedicion", description = "Elimina un medicion por su idmedicion")
    @APIResponse(responseCode = "200", description = "Cuando elimina el medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(@QueryParam("idmedicion") Long idmedicion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        /**
         * Genera base de datos para cada año
         * formato: lectura_añodb
         *    lecturas_2024db
         * 
         * Para las colecciones seria
         * el primer digito indica la estacion, el segundo digito sera el mes
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         * ----------------------
         *   lecturas_2025db
         * medicion_1_enero
         * medicion_2_enero
         * medicion_1_febrero
         * medicion_2_febrero
         */
        medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        medicionRepository.setDynamicCollection(nameOfCollection +idmedicion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

        if (medicionRepository.deleteByPk(idmedicion) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response deleteMany(@QueryParam("filter") String filter @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @DELETE
    @Path("deletemany")
    @RolesAllowed({"admin"})
    @Operation(summary = "Elimina un medicion por  idmedicion", description = "Elimina un medicion por su idmedicion")
    @APIResponse(responseCode = "200", description = "Cuando elimina el medicion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
      medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        medicionRepository.setDynamicCollection(nameOfCollection +idestacion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (medicionRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + medicionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Medicion> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @GET
    @Path("lookup")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un medicion", description = "Busqueda de medicion por search")
    @APIResponse(responseCode = "200", description = "Medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Medicion> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        System.out.println("Año: " + anio);
        System.out.println("ID Estacion: " + idestacion);
        System.out.println("Mes: " + mes);
        List<Medicion> suggestions = new ArrayList<>();
        try {

     medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        medicionRepository.setDynamicCollection(nameOfCollection +idestacion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);

            suggestions = medicionRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        System.out.println("Resultado: " + suggestions);
        return suggestions;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("anio") Long anio)">
    @GET
    @Path("count")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta medicion")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        Long result = 0L;
        try {
    medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        medicionRepository.setDynamicCollection(nameOfCollection +idestacion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            result = medicionRepository.count(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Medicion> findLastMedicion @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes">
    @GET
    @Path("findlastmedicion")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca la última medicion de una estación", description = "Busqueda de la última medicion en una estación")
    @APIResponse(responseCode = "200", description = "Medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Medicion> findLastMedicion(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        List<Medicion> suggestions = new ArrayList<>();
        try {
            Integer numeroMes = mes;

            medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            medicionRepository.setDynamicCollection(nameOfCollection + idestacion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));
            Search search = DocumentUtil.convertForLookup(filter, sort, 1, 1);

            suggestions = medicionRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
 

        return suggestions;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Medicion> findAllLastMedicion @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes">
    @GET
    @Path("findalllastmedicion")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca la última medicion de cada estación", description = "Busqueda de la última medicion en cada estación")
    @APIResponse(responseCode = "200", description = "Medicion")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Medicion> findAllLastMedicion(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        List<Medicion> suggestions = new ArrayList<>();
        List<Medicion> resultSearch = new ArrayList<>();
        try {
            Integer numeroMes = mes;
            Long countEstaciones = estacionRepository.count();
                    
            for(int index = 1; index <= countEstaciones; index++){
                
            
            medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            medicionRepository.setDynamicCollection(nameOfCollection +String.valueOf(index) + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));
            Search search = DocumentUtil.convertForLookup(filter, sort, 1, 1);

            resultSearch = medicionRepository.lookup(search);
            suggestions.addAll(resultSearch);
            }

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
 

        return suggestions;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" List<Medicion> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal, @QueryParam("anio") Long anio)">
    @GET
    @Path("betweendate")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un user", description = "Busqueda de user usando like%")
    @APIResponse(responseCode = "200", description = "UserView")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Medicion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Medicion> betweenDate(@QueryParam("fechainicial") @DateFormat("dd-MM-yyyy") final Date fechainicial, @QueryParam("fechafinal") @DateFormat("dd-MM-yyyy") final Date fechafinal, @QueryParam("idestacion") Long idestacion, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        System.out.println("---------------------llego a "+MessagesUtil.nameOfClassAndMethod());
        System.out.println("Fecha inicio:" + fechainicial);
        System.out.println("Fecha final: " + fechafinal);
        System.out.println("Año: " + anio);
        System.out.println("ID Estacion: " + idestacion);
        System.out.println("Mes: " + mes);
        System.out.println("nombremes: " + JmoordbCoreDateUtil.getNombreMes(mes));
        List<Medicion> suggestions = new ArrayList<>();
        try {
           medicionRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        medicionRepository.setDynamicCollection(nameOfCollection +idestacion.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes));

            suggestions = medicionRepository.findByFechahoraGreaterThanEqualAndFechahoraLessThanEqual(fechainicial, fechafinal);


        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        System.out.println("Resultado: " + suggestions);

        return suggestions;
    }

    // </editor-fold>
   
}
