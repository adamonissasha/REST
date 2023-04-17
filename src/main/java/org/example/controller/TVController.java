package org.example.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@WebServlet("/info")
public class TVController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Client client = ClientBuilder.newClient();
        try {
            URI uri = new URI("http://localhost:8080/REST/tv/send");
            response.setContentType("application/xml;charset=UTF-8");
            response.getWriter().write(client.target(uri).request(MediaType.APPLICATION_XML).get(String.class));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
