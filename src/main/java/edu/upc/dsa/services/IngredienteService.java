package edu.upc.dsa.services;

import edu.upc.dsa.DAO.IngredienteManager;
import edu.upc.dsa.DAO.IngredienteManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/ingrediente", description = "Endpoint to Partida Service")
@Path("/ingrediente")
public class IngredienteService {

    private IngredienteManager im; //Gestor

    public IngredienteService(){
        this.im = IngredienteManagerImpl.getInstance();
        if(im.size()==0) {
            im.addIngrediente("MasaPizza", 1, 0);
            im.addIngrediente("Mozarella", 1, 0);
            im.addIngrediente("SalsaTomate", 1, 0);
            im.addIngrediente("Vino", 1, 0);
            im.addIngrediente("Jamon", 2, 0);
            im.addIngrediente("Pepperoni", 2, 0);
            im.addIngrediente("Piña", 3, 0);
            im.addIngrediente("Champiñones", 3, 0);
            im.addIngrediente("Rucula", 3, 0);
            im.addIngrediente("Hamburguesa", 1, 1);
            im.addIngrediente("Lechuga", 1, 1);
            im.addIngrediente("Cocacola", 1, 1);
            im.addIngrediente("PanHamburguesa", 1, 1);
            im.addIngrediente("Tomate", 1, 1);
            im.addIngrediente("Bacon", 2, 1);
            im.addIngrediente("Queso", 2, 1);
            im.addIngrediente("Frankfurt", 3, 1);
            im.addIngrediente("PanFrankfurt", 3, 1);
        }
    }



    @GET
    @ApiOperation(value = "get all Ingredientes", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Ingrediente.class, responseContainer="List"),
    })
    @Path("/getAllIngredientes")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllIngredientes(){
        List<Ingrediente> listIngredientes = null;
        listIngredientes = this.im.getAllIngredientes();
        GenericEntity<List<Ingrediente>> entity = new GenericEntity<List<Ingrediente>>(listIngredientes) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get un Ingrediente", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Ingrediente.class),
            @ApiResponse(code = 404, message = "Ingrediente not found")
    })
    @Path("/getIngrediente/{idIngrediente}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getIngrediente(@PathParam("idIngrediente") int id) {
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
        Ingrediente i = this.im.addIngrediente(ingrediente.getNombreIngrediente(),ingrediente.getNivelDesbloqueoIngrediente(),ingrediente.getPrecioIngrediente());
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
    @Path("/deleteIngrediente/{idIngrediente}")
    public Response deleteIngrediente(@PathParam("idIngrediente") int id) {
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


    @GET
    @ApiOperation(value = "Lista Ingredientes de un Jugador", notes = "lista con los ingredientes que tiene un jugador")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Ingrediente.class),
            @ApiResponse(code = 404, message = "Ingrediente not found")

    })

    @Path("/getLista/{jugador}")
    @Produces(MediaType.APPLICATION_JSON)// nos devuelve JSON con forma BuyedObject in a List
    public Response listaIngredientesComprados(@PathParam("jugador") int idJugador) {
        try {
            List<Ingrediente> ingredientesCompradosPorJugador = this.im.get(userName);
            if (objectsBuyedByUser == null) {
                return Response.status(401).build();
            }
            GenericEntity<List<Objects>> entity = new GenericEntity<List<Objects>>(objectsBuyedByUser) {
            };
            return Response.status(200).entity(entity).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).build();
        }

    }






}

