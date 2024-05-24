/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estacionesserver.controller;

import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.estacionesserver.model.Estacion;
import com.estacionesserver.repository.EstacionRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;   
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.metrics.MetricUnits;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author avbravo
 */
@Path("estacion")
@Tag(name = "Información del estacion", description = "End-point para entidad Estacion")
@RolesAllowed({"admin"})
public class EstacionController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EstacionRepository estacionRepository;

    

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @RolesAllowed({"admin"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Timed(name = "estacionesFindAll",
            description = "Monitorea el tiempo en que se obtiene la lista de todos los estaciones",
            unit = MetricUnits.MILLISECONDS, absolute = true)
    @Operation(summary = "Obtiene todos los estaciones", description = "Retorna todos los estaciones disponibles")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los estaciones")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los estaciones", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los estacions", required = true, name = "estaciones")))
    public List<Estacion> findAll() {
        List<Estacion> estacionList = new ArrayList<>();

        return estacionRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estacion findByIdestacion">
    @GET
    @RolesAllowed({"admin"})
    @Path("{idestacion}")
    @Operation(summary = "Busca un estacion por el idestacion", description = "Busqueda de estacion por idestacion")
    @APIResponse(responseCode = "200", description = "El estacion")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idestacion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El estacion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))
    public Estacion findByIdestacion(
            @Parameter(description = "El idestacion", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idestacion") Long idestacion) {

        return estacionRepository.findByPk(idestacion).orElseThrow(
                () -> new WebApplicationException("No hay estacion con idestacion " + idestacion, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estacion findByEstacion">
    @GET
    @RolesAllowed({"admin"})
    @Path("estacion")
    @Operation(summary = "Busca un estacion por proyecti", description = "Busqueda de estacion por estacion")
    @APIResponse(responseCode = "200", description = "El estacion")
    @APIResponse(responseCode = "404", description = "Cuando no existe el estacion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El estacion", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))

    public List<Estacion> findByEstacion(@Parameter(description = "El estacion", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("estacion") final String estacion) {

        return estacionRepository.findByEstacion(estacion);

    }
//// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response save">

    @POST
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo estacion", description = "Inserta un nuevo estacion")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  estacion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo estacion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estacion.class))) Estacion estacion) {

        Optional<Estacion> estacionOptional = estacionRepository.save(estacion);
        if (estacionOptional.isPresent()) {
//            saveHistory(estacion);
            return Response.status(201).entity(estacionOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + estacionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
    @RolesAllowed({"admin"})
    @Operation(summary = "Inserta un nuevo estacion", description = "Inserta un nuevo estacion")
    @APIResponse(responseCode = "201", description = "Cuando se crea un  estacion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response update(
            @RequestBody(description = "Crea un nuevo estacion.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estacion.class))) Estacion estacion) {

        if (estacionRepository.update(estacion)) {
//            saveHistory(estacion);
            return Response.status(201).entity(estacion).build();
        } else {

            return Response.status(400).entity("Error " + estacionRepository.getJmoordbException().getLocalizedMessage()).build();

        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @RolesAllowed({"admin"})
    @Path("{idestacion}")
    @Operation(summary = "Elimina un estacion por  idestacion", description = "Elimina un estacion por su idestacion")
    @APIResponse(responseCode = "200", description = "Cuando elimina el estacion")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(
            @Parameter(description = "El elemento idestacion", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idestacion") Long idestacion) {

        if (estacionRepository.deleteByPk(idestacion) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + estacionRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="List<User> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @GET
    @Path("lookup")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un estacion", description = "Busqueda de estacion por search")
    @APIResponse(responseCode = "200", description = "User")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Estacion> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        List<Estacion> suggestions = new ArrayList<>();
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);

            suggestions = estacionRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return suggestions;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @GET
    @Path("count")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta estacion")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size) {
        Long result = 0L;
        try {

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            result = estacionRepository.count(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
  
    // <editor-fold defaultstate="collapsed" desc="Long countLikeEstacion(@QueryParam("estacion") String estacion)">
    @GET
    @Path("countlikebyestacion")
    @RolesAllowed({"admin"})
    @Operation(summary = "Cuenta ", description = "Cuenta tarjeta")
    @APIResponse(responseCode = "200", description = "contador")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public Long countLikeEstacion(@QueryParam("estacion") String estacion) {
        Long result = 0L;
        try {
            result = estacionRepository.countLikeByEstacion(estacion);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" List<Estacion> likeByName(@QueryParam("estacion") String estacion)">
    @GET
    @Path("likebyestacion")
    @RolesAllowed({"admin"})
    @Operation(summary = "Busca un user", description = "Busqueda de user usando like%")
    @APIResponse(responseCode = "200", description = "UserView")
    @APIResponse(responseCode = "404", description = "Cuando no existe la condicion en el search")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El search", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estacion.class)))

    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Estacion> likeByName(@QueryParam("estacion") String estacion) {
        List<Estacion> suggestions = new ArrayList<>();
        try {
            suggestions = estacionRepository.likeByEstacion(estacion);
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        return suggestions;
    }

    // </editor-fold>
}
