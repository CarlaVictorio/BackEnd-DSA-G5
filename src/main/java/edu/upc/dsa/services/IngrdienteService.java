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
import java.util.List;

@Api(value = "/ingrediente", description = "Endpoint to Partida Service")
@Path("/ingrediente")
public class IngrdienteService {

    private IngredienteManager im; //Gestor

    public IngrdienteService(){
        this.im = IngredienteManagerImpl.getInstance();
        im.addIngrediente("1","MasaPizza",1,0);
        im.addIngrediente("1","Mozarella",1,0);
        im.addIngrediente("1","SalsaTomate",1,0);
        im.addIngrediente("1","Vino",1,0);
        im.addIngrediente("1","Jamon",2,0);
        im.addIngrediente("1","Pepperoni",2,0);
        im.addIngrediente("1","Piña",3,0);
        im.addIngrediente("1","Champiñones",3,0);
        im.addIngrediente("1","Rucula",3,0);
        im.addIngrediente("1","Hamburguesa",1,1);
        im.addIngrediente("1","Lechuga",1,1);
        im.addIngrediente("1","Cocacola",1,1);
        im.addIngrediente("1","PanHamburguesa",1,1);
        im.addIngrediente("1","Tomate",1,1);
        im.addIngrediente("1","Bacon",2,1);
        im.addIngrediente("1","Queso",2,1);
        im.addIngrediente("1","Frankfurt",3,1);
        im.addIngrediente("1","PanFrankfurt",3,1);
    }


    @GET
    @ApiOperation(value = "get all Ingredientes", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Ingrediente.class, responseContainer="List"),
    })
    @Path("/getAllIngredientes")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllIngredientes(){
        List<Ingrediente> listIngredientes = this.im.getAllIngredientes();
        GenericEntity<List<Ingrediente>> entity = new GenericEntity<List<Ingrediente>>(listIngredientes) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get un Ingrediente", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Ingrediente.class),
            @ApiResponse(code = 404, message = "Ingrediente not found")
    })
    @Path("/getIngrediente")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getIngrediente(@PathParam("idIngrediente") String id) {
        Ingrediente i = this.im.getIngrediente(id);
        if (i == null) return Response.status(404).build();
        else  return Response.status(201).entity(i).build();
    }


    @POST
    @ApiOperation(value = "añadir un nuevo Ingrediente", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error"),

    })
    @Path("/postIngrediente")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIngrediente(Ingrediente ingrediente) {
        if (ingrediente.getNombreIngrediente()=="" || ingrediente.getNivelDesbloqueoIngrediente()==0) {
            return Response.status(500).build();
        }
        Ingrediente i = this.im.addIngrediente(RandomUtils.getId(),ingrediente.getNombreIngrediente(),ingrediente.getNivelDesbloqueoIngrediente(),ingrediente.getPrecioIngrediente());
        if (i!=null){
            return Response.status(201).build();
        }
        return Response.status(500).build();
    }


    @DELETE
    @ApiOperation(value = "delete Ingrediente", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Ingrediente not found")
    })
    @Path("/deleteIngrediente")
    public Response deleteIngrediente(@PathParam("idIngrediente") String id) {
        Ingrediente i = this.im.getIngrediente(id);
        if (i == null) return Response.status(404).build();
        else {
            this.im.deleteIngrediente(id);
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "update Ingrediente", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Ingrediente not found")
    })
    @Path("/putIngrediente")
    public Response putIngrediente(Ingrediente ingrediente) {

        Ingrediente i = this.im.putIngrediente(ingrediente);
        if (i == null) return Response.status(404).build();
        else return Response.status(201).build();
    }
}

