package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.UserCarBean;
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
public class UserCarResource {

    @EJB
    UserCarBean userCarBean;

    /**
     * Calls userCarBean.addCarItem and posts a Car to users Car list
     * @param car Car to add to users Car list
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if failed to add Car to users list
     */
    @POST
    @Path("user_car")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUserCars(Car car){
        if(userCarBean.addUserCar(car).getId() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(car).build();
    }

    /**
     * Calls userCarBean.getUserCars and retrieves a list of Cars
     * @param userId ID of user to get data from
     * @return Returns Response with a JSON array of Cars a user had in his list or Status 400 BAD REQUEST if failed to fetch list
     */
    @GET
    @Path("user_cars/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCars(@PathParam("userId") int userId){
        List<Car> cars = userCarBean.getUserCars(userId);
        if(cars.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(cars).build();
    }

    /**
     * Calls userCarBean.deleteUserCar and removes one item from users item list
     * @param userId ID of user to remove list item from
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if failed to remove
     */
    @DELETE
    @Path("user_car/{userId}")
    public Response deleteUserCars(@PathParam("userId") int userId){
        if(userCarBean.deleteUserCar() == 0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
