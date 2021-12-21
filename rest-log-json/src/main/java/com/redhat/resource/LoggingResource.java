package com.redhat.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/logging")
public class LoggingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String userInfoLog() {
        System.out.println("{name: 'User1', age: 33, city: 'Rio de Janeiro', country: 'Brazil', marital_status: 'married'}");
        return "Hello RESTEasy";
    }
}