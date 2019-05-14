package Ressources;


import Entities.Station;
import Services.StationService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("station")
public class StationRessource {



    @EJB
    StationService stationService;
    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getStationById(@PathParam(value = "id") int id) {
        Station station = stationService.getStationById(id);
        if (station!= null)
            return Response.status(Response.Status.OK).entity(station).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStations() {
        List<Station> stations= stationService.getAllStation();
        if (stations != null)
            return Response.status(Response.Status.OK).entity(stations).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateStation(Station station) {

        if ( station!= null) {
            if (stationService.editStation(station))
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteStation(@PathParam("id") int id) {
        if (id != 0) {
            if (stationService.removeStation(id))
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStation(Station station) {
        if (station!= null) {
            if (stationService.addStation(station))
                return Response.status(Response.Status.CREATED).build();
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}
