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
@Path("")
public class ItemResource {

    @EJB
    ItemBean itemBean;

    /**
     *
     * @return
     */
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

    /**
     *
     * @param item
     * @return
     */
    public int addItem(Item item){
        return 0;
    }

    /**
     *
     * @param itemId
     * @return
     */
    public int removeItem(int itemId){
        return  0;
    }

}
