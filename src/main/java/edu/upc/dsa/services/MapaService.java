package edu.upc.dsa.services;

import edu.upc.dsa.*;
import edu.upc.dsa.models.*;
import edu.upc.dsa.util.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "/mapa", description = "Endpoint to Partida Service")
@Path("/mapa")
public class MapaService {

    private MapaManager mm; //Gestor

    public MapaService(){
        this.mm = MapaManagerImpl.getInstance();
        this.mm.postMapa("0","Pizzeria",3);
        this.mm.postMapa("1","Hamburgeseria",3);
        this.mm.postMapa("2","Pasteleria",3);
        this.mm.postMapa("3","Calle",3);
    }


    @GET
    @ApiOperation(value = "get all Mapas", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mapa.class, responseContainer="List"),
    })
    @Path("/getAllMapas")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllMapas(){
        HashMap<String,Mapa> listMapas = this.mm.getAllMapas();
        GenericEntity<List<Mapa>> entity = new GenericEntity<List<Mapa>>((List<Mapa>) listMapas) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get un Mapa", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mapa.class),
            @ApiResponse(code = 404, message = "Mapa not found")
    })
    @Path("/getMapa")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getMapa(@PathParam("idMapa") String id) {
        Mapa m = this.mm.getMapa(id);
        if (m == null) return Response.status(404).build();
        else  return Response.status(201).entity(m).build();
    }


    @POST
    @ApiOperation(value = "añadir un nuevo Mapa", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error"),

    })
    @Path("/postMapa")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMapa(Mapa mapa) {
        if (mapa.getNombre()=="" || mapa.getNumNiveles()==0) {
            return Response.status(500).build();
        }
        Mapa m = this.mm.postMapa(RandomUtils.getId(),mapa.getNombre(),mapa.getNumNiveles());
        if (m!=null){
            return Response.status(201).build();
        }
        return Response.status(500).build();
    }


    @DELETE
    @ApiOperation(value = "delete Mapa", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Mapa not found")
    })
    @Path("/deleteMapa")
    public Response deleteMapa(@PathParam("idMapa") String id) {
        Mapa m = this.mm.getMapa(id);
        if (m == null) return Response.status(404).build();
        else {
            this.mm.deleteMapa(id);
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "update Mapa", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Mapa not found")
    })
    @Path("/putMapa")
    public Response putMapa(Mapa mapa) {

        Mapa m = this.mm.putMapa(mapa.getId(),mapa.getNombre(),mapa.getNumNiveles());
        if (m == null) return Response.status(404).build();
        else return Response.status(201).build();
    }
}

