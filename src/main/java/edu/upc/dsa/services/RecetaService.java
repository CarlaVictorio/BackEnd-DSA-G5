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

@Api(value = "/receta", description = "Endpoint to Partida Service")
@Path("/receta")
public class RecetaService {

    private RecetaManager rm; //Gestor

    public RecetaService(){
        this.rm = RecetaManagerImpl.getInstance();
        this.rm.addReceta("0","hamurguesa",1,50,5);
        this.rm.addReceta("0","hamurguesa",2,100,10);
        this.rm.addReceta("1","hamburguesa_lechuga",1,50,5);
        this.rm.addReceta("1","hamburguesa_lechuga",2,100,10);
        this.rm.addReceta("1","hamburguesa_lechuga",3,150,15);
    }


    @GET
    @ApiOperation(value = "get all Recetas", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Receta.class, responseContainer="List"),
    })
    @Path("/getAllRecetas")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllRecetas(){
        List<Receta> listReceta = this.rm.getAllRecetas();
        GenericEntity<List<Receta>> entity = new GenericEntity<List<Receta>>(listReceta) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get una Receta", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Receta.class),
            @ApiResponse(code = 404, message = "Receta not found")
    })
    @Path("/getReceta")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getReceta(@PathParam("idReceta") String id) {
        Receta r = this.rm.getReceta(id);
        if (r == null) return Response.status(404).build();
        else  return Response.status(201).entity(r).build();
    }


    @POST
    @ApiOperation(value = "añadir una nueva Receta", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error"),

    })
    @Path("/postReceta")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postReceta(Receta receta) {
        if (receta.getNombreReceta()=="" || receta.getNumPaso()==0) {
            return Response.status(500).build();
        }
        Receta r = this.rm.addReceta(RandomUtils.getId(),receta.getNombreReceta(),receta.getNumPaso(),receta.getPremioDinero(),receta.getPremioPuntos());
        if (r!=null){
            return Response.status(201).build();
        }
        return Response.status(500).build();
    }


    @DELETE
    @ApiOperation(value = "delete Receta", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Receta not found")
    })
    @Path("/deleteReceta")
    public Response deleteReceta(@PathParam("idReceta") String id) {
        Receta r = this.rm.getReceta(id);
        if (r == null) return Response.status(404).build();
        else {
            this.rm.deleteReceta(id);
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "update Receta", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Receta not found")
    })
    @Path("/putReceta")
    public Response putReceta(Receta receta) {

        Receta r = this.rm.putReceta(receta);
        if (r == null) return Response.status(404).build();
        else return Response.status(201).build();
    }
}
