package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.UserCarBean;
import nu.t4.opendata.backend.entities.Car;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("")
public class UserCarResource {

    @EJB
    UserCarBean userCarBean;

    /**
     * Calls userItemBean.addUserItem and posts a item to users item list
     * @param item Item to add to users item list
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if failed to add to users list
     */
    @POST
    @Path("user_car")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUserItem(Car car){
        if(userCarBean.addUserCar(car).getId() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(car).build();
    }

    /**
     * Calls userItemBean.getUserItems and retrieves a list of items
     * @param userId ID of user to get data from
     * @return Returns Response with a JSON array of items a user had in his list or Status 400 BAD REQUEST if failed to fetch list
     */
    @GET
    @Path("user_cars/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserItems(@PathParam("userId") int userId){
        List<Car> cars = userCarBean.getUserCars(userId);
        if(cars.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(cars).build();
    }

    /**
     * Calls userItemBean.deleteUserItem and removes one item from users item list
     * @param userId ID of user to remove list item from
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if failed to remove
     */
    @DELETE
    @Path("user_car/{userId}")
    public Response deleteUserItem(@PathParam("userId") int userId){
        if(userCarBean.deleteUserCar() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
