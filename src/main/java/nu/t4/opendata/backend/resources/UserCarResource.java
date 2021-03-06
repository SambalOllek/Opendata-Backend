package nu.t4.opendata.backend.resources;

import nu.t4.opendata.backend.beans.UserCarBean;
import nu.t4.opendata.backend.entities.Car;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.t4.opendata.backend.beans.UserCars;

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
     *
     * @param car Car to add to users Car list
     * @param token Token of user making the request
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if
     * failed to add Car to users list
     */
    @POST
    @Path("userCars")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUserCars(Car car, @HeaderParam("authorization") String token) {
        if (userCarBean.addUserCar(car, token) == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(car).build();
    }

    /**
     * Calls userCarBean.getUserCars and retrieves a list of Cars
     *
     * @param token Token of user making the request
     * @return Returns Response with a JSON array of Cars a user had in his list
     * or Status 400 BAD REQUEST if failed to fetch list
     */
    @GET
    @Path("userCars")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCars(@HeaderParam("authorization") String token) {
        UserCars usercars = userCarBean.getUserCars(token);
        if (usercars.getCars().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(usercars).build();
    }

    /**
     * Calls userCarBean.deleteUserCar and removes one item from users item list
     *
     * @param token Token of user making the request
     * @param carId ID of car to delete
     * @return Returns Status 200 OK if success or Status 400 BAD REQUEST if
     * failed to remove
     */
    @DELETE
    @Path("userCars/{carId}")
    public Response deleteUserCars(@HeaderParam("authorization") String token, @PathParam("carId") int carId) {
        if (userCarBean.deleteUserCar(token, carId) == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
