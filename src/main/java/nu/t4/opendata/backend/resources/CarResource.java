package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.CarBean;
import nu.t4.opendata.backend.entities.Car;

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
public class CarResource {

    @EJB
    CarBean carBean;

    /**
     *
     * @return
     */
    @GET
    @Path("cars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(){
        List<Car> cars = carBean.getCars();
        if(cars.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(cars).build();
    }
}
