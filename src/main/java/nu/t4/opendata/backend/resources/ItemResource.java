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
    @Path("items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(){
        List<Item> items = itemBean.getItems();
        if(items.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(items).build();
    }

    public int addItem(Item item){
        return 0;
    }

    public int removeItem(int itemId){
        return  0;
    }

}
