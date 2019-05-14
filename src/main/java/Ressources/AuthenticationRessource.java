package Ressources;

import Entities.Users;
import Services.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Path("authentication")
public class AuthenticationRessource {



    @Context
    private UriInfo uriInfo;

    @EJB
    AuthenticationService authenticationService;


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response authenticateUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {

            //this.reqContext=requestContext;

            // Authenticate the user using the credentials provided
            if (authenticate(username, password)!=null)
                // Issue a token for the user
            {

               String  token = issueToken(username);
                //System.out.println( securityContext.getUserPrincipal().getName()+"333333");


                return Response.ok(token).build();

            }


            return Response.status(Response.Status.UNAUTHORIZED).build();

            // Return the token on the response

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private Users authenticate(String username, String password) {


        Users users= authenticationService.getUserByMailAndPassword(username,password);

        System.out.println("Authenticating user..."+users);

        return users;



    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token


        String keyString = "simplekey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        System.out.println("the key is : " + key);

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        System.out.println("the returned token is : " + jwtToken);
        return jwtToken;


    }

    // ======================================
    // = Private methods =
    // ======================================

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<Users> users= authenticationService.getAllUsers();
        if (users != null)
            return Response.status(Response.Status.OK).entity(users).build();

        return Response.status(Response.Status.NO_CONTENT).build();

    }
}
