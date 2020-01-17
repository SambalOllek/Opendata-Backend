package nu.t4.opendata.backend.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.t4.opendata.backend.beans.Oauth;

@Path("")
public class OauthResources1 {
    
   @EJB
    Oauth oAuth;
    
    @GET
    @Path("token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getToken(@QueryParam("code") String code){
        return Response.ok(oAuth.getToken(code)).build();
    }
    
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvents(@QueryParam("token") String token){
        return Response.ok(oAuth.githubOauth(token)).build();
    }
    
    
}
