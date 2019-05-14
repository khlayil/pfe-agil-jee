package Ressources;


import Entities.Promotion;
import Services.PromotionService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("promotion")

public class PromotionRessource {

    @EJB
    PromotionService promotionService;
    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPromotions() {
        List<Promotion> promotions= promotionService.getAllPromotion();
        if (promotions != null)
            return Response.status(Response.Status.OK).entity(promotions).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPromotionById(@PathParam(value = "id") int id) {
        Promotion promotion= promotionService.getPromotionById(id);
        if (promotion!= null)
            return Response.status(Response.Status.OK).entity(promotion).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }

    @DELETE
    @Path("{id}")
    public Response deletePromotion(@PathParam("id") int id) {
        if (id != 0) {
            if (promotionService.removePromotion(id))
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPromotion(Promotion promotion) {
        if (promotion!= null) {
            System.out.println(promotion.getNom()+"+++"+promotion.getProduct().getNom());
            if (promotionService.addPromotion(promotion))
                return Response.status(Response.Status.CREATED).build();
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }


}
