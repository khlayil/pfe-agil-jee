package Ressources;


import Entities.Product;
import Services.ProductService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("product")

public class ProductRessouce {

    @EJB
    ProductService productService;
    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getProductById(@PathParam(value = "id") int id) {
        Product product = productService.getProductById(id);
        if (product!= null)
            return Response.status(Response.Status.OK).entity(product).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Product> products= productService.getAllProduct();
        if (products != null)
            return Response.status(Response.Status.OK).entity(products).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("noPromo")
    public Response getAllProductsWithNoPromo() {
        List<Product> products= productService.getAllProductNoPromotion();
        if (products != null)
            return Response.status(Response.Status.OK).entity(products).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateProduct(Product product) {

        if ( product!= null) {

            if (productService.editProduct(product))
                return Response.status(Response.Status.OK).entity(product).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        if (id != 0) {
            if (productService.removeProduct(id))
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) {
        if (product!= null) {
            if (productService.addProduct(product))
                return Response.status(Response.Status.CREATED).build();
            else
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }
}
