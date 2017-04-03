package com.epam.mp.endpoint;

import com.epam.mp.entity.User;
import com.epam.mp.service.UserService;
import com.epam.mp.service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserEndpoint {

    private UserService userService = new UserServiceImpl();

    @GET
    @Path("/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByLogin(@PathParam("login") String login) {
        return userService.getUserByLogin(login).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers() {
        return userService.getAllUsers().toString();
    }

    @DELETE
    @Path("/{login}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response deleteUser(@PathParam("login") String login) {
        userService.deleteUser(login);
        return Response.status(200).entity("Success").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        userService.createUser(user);
        return Response.status(200).entity("Success").build();
    }

    @POST
    @Path("/{login}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateUser(@PathParam("login") String login, User user) {
        userService.updateUser(login, user);
        return Response.status(200).entity("Success").build();
    }


}
