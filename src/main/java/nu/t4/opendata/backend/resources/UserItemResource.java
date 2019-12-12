package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.UserItemBean;
import nu.t4.opendata.backend.entities.Item;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class UserItemResource {

    @EJB
    UserItemBean userItemBean;

    @POST
    @Path("user_item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postItem(Item item){
        if(userItemBean.addUserItem(item).getId() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(item).build();
    }

    @GET
    @Path("user_items/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(@PathParam("userId") int userId){
        List<Item> items = userItemBean.getUserItems(userId);
        if(items.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(items).build();
    }

    @DELETE
    @Path("user_item/{userId}")
    public Response deleteItem(@PathParam("userId") int userId){
        if(userItemBean.deleteUserItem() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
