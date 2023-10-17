package org.alexey.bookings.servlets.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexey.bookings.service.api.IAircraftService;
import org.alexey.bookings.service.factory.AircraftServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/json/aircrafts")
public class JsonAircraftServlet extends HttpServlet {

    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        objectMapper.writeValue(writer, aircraftService.getAllAircrafts());

    }
}
