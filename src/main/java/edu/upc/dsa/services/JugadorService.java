package edu.upc.dsa.services;

import edu.upc.dsa.JugadorManager;
import edu.upc.dsa.JugadorManagerImpl;
import edu.upc.dsa.PartidasManagerImpl;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Partida;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/jugador", description = "Endpoint to Partida Service")
@Path("/jugador")
public class JugadorService {

    private JugadorManager jm; //Gestor

    public JugadorService(){
        this.jm = JugadorManagerImpl.getInstance();
        if(jm.size()==0){
            jm.addJugador("Juan","1111");
            jm.addJugador("Victoria","2222");
            jm.addJugador("Maria","3333");
        }
    }


    @GET
    @ApiOperation(value = "get all Jugadores", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getAllJugadores(){
        List<Jugador> jugadores = this.jm.getAllJugadores();
        GenericEntity<List<Jugador>> entity = new GenericEntity<List<Jugador>>(jugadores) {};
        return Response.status(201).entity(entity).build()  ;
    }


    @GET
    @ApiOperation(value = "get un Jugador", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/{idJugador}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getJugador(@PathParam("idJugador") String id) {
        Jugador j = this.jm.getJugador(id);
        if (j == null) return Response.status(404).build();
        else  return Response.status(201).entity(j).build();
    }


    @POST
    @ApiOperation(value = "create a new Jugador", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Jugador.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJugador(Jugador jugador) {
        if (jugador.getNombre()==null || jugador.getPassword()==null) {
            return Response.status(500).build();
        }
        this.jm.addJugador(jugador.getNombre(), jugador.getPassword());
        return Response.status(201).entity(jugador).build();
    }


    @DELETE
    @ApiOperation(value = "delete Jugador", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/{idJugador}")
    public Response deleteJugador(@PathParam("idJugador") String id) {
        Jugador j = this.jm.getJugador(id);
        if (j == null) return Response.status(404).build();
        else {
            this.jm.deleteJugador(id);
            return Response.status(201).build();
        }
    }


    @PUT
    @ApiOperation(value = "update Jugador", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/")
    public Response putJugador(Jugador jugador) {

        Jugador j = this.jm.putJugador(jugador);
        if (j == null) return Response.status(404).build();
        else return Response.status(201).build();
    }


    @GET // POST aquest ha de ser un login i no t'he sentit que hem retorni entity
    @ApiOperation(value = "search un Jugador", notes = "hola")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Jugador.class),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/{nombre}/{password}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response searchJugador(@PathParam("nombre") String nombre, @PathParam("password") String password) {
        Jugador j = this.jm.searchJugador(nombre, password);
        if (j == null) return Response.status(404).build();
        else  return Response.status(201).entity(j).build();
    }
}
