package org.example.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.File;
@Path("/tv")
public class TVService {
    @GET
    @Path("/send")
    @Produces(MediaType.APPLICATION_XML)
    public Response sendXmlDocument() {
        File file = new File("D:\\university\\6sem\\ris\\REST\\src\\main\\resources\\TVs.xml");
        return Response.ok(file).build();
    }
}
