package org.alexey.bookings.servlets.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexey.bookings.service.api.IFlightService;
import org.alexey.bookings.service.factory.FlightServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/json/flights")
public class JsonFlightServlet extends HttpServlet {

    private IFlightService flightService = FlightServiceFactory.getInstance();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        objectMapper.writeValue(writer, flightService.getAllFlights());
    }
}
