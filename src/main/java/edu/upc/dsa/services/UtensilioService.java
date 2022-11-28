package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.LogIn;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Utensilio;
import edu.upc.dsa.util.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/utensilio", description = "Endpoint to Partida Service")
@Path("/utensilio")
public class UtensilioService {

    private UtensilioManager um; //Gestor

    public UtensilioService(){
        this.um = UtensilioManagerImpl.getInstance();
        um.addUtensilio("50","plancha",15,10,5);
        um.addUtensilio("51","dispensadorCocacola",15,10,5);
        um.addUtensilio("52","cafetera",15,10,5);
        um.addUtensilio("53","dispensador",15,10,5);
        um.addUtensilio("54","horno",15,10,5);
    }


    @GET
    @ApiOperation(value = "get all Utensilios", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Utensilio.class, responseContainer="List"),
    })
    @Path("/getAllUtensilios")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllUtensilios(){
        List<Utensilio> listUtensilios = this.um.getAllUtensilios();
        GenericEntity<List<Utensilio>> entity = new GenericEntity<List<Utensilio>>(listUtensilios) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get un Utensilio", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Utensilio.class),
            @ApiResponse(code = 404, message = "Utensilio not found")
    })
    @Path("/getUtensilio")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getUtensilio(@PathParam("idUtensilio") String id) {
        Utensilio u = this.um.getUtensilio(id);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }


    @POST
    @ApiOperation(value = "añadir un nuevo Utensilio", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error"),

    })
    @Path("/postUtensilio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUtensilio(Utensilio utensilio) {
        if (utensilio.getNombreUtensilio()=="" || utensilio.getTiempoNivel1()==0|| utensilio.getTiempoNivel2()==0||utensilio.getTiempoNivel3()==0) {
            return Response.status(500).build();
        }
        Utensilio u = this.um.addUtensilio(RandomUtils.getId(),utensilio.getNombreUtensilio(),utensilio.getTiempoNivel1(),utensilio.getTiempoNivel2(),utensilio.getTiempoNivel3());
        if (u!=null){
            return Response.status(201).build();
        }
        return Response.status(500).build();
    }


    @DELETE
    @ApiOperation(value = "delete Utensilio", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Utensilio not found")
    })
    @Path("/deleteUtensilio")
    public Response deleteUtensilio(@PathParam("idUtensilio") String id) {
        Utensilio u = this.um.getUtensilio(id);
        if (u == null) return Response.status(404).build();
        else {
            this.um.deleteUtensilio(id);
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "update Utensilio", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Utensilio not found")
    })
    @Path("/putUtensilio")
    public Response putUtensilio(Utensilio utensilio) {

        Utensilio u = this.um.putUtensilio(utensilio);
        if (u == null) return Response.status(404).build();
        else return Response.status(201).build();
    }
}

