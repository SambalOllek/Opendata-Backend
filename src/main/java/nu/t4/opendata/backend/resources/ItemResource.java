package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.ItemBean;
import nu.t4.opendata.backend.entities.Item;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Erik
 */
public class ItemResource {

    @EJB
    ItemBean itemBean;

    @GET
    @Path("items/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(@PathParam("userId") int userId){
        List<Item> items = itemBean.getItems(userId);
        if(items.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(items).build();
    }

    @DELETE
    @Path("item/{itemId}")
    public Response deleteItem(@PathParam("itemId") int itemId){
        if(itemBean.removeItem(itemId) == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postItem(Item item){
        if(itemBean.addItem(item).getId() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(item).build();
    }


}
