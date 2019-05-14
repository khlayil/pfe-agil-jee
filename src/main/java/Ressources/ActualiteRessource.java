package Ressources;

import Entities.Actualite;
import Interfaces.IActualiteService;
import Services.ActualiteService;
import utilities.Secured;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("actu")
public class ActualiteRessource {




    @EJB
    ActualiteService actualiteService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActu() {
        List<Actualite> actualites= actualiteService.getAllActu();
        if (actualites != null)
            return Response.status(Response.Status.OK).entity(actualites).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }
}
