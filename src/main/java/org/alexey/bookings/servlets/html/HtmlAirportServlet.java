package org.alexey.bookings.servlets.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexey.bookings.service.api.IAirportService;
import org.alexey.bookings.service.factory.AirportServiceFactory;

import java.io.IOException;

@WebServlet (urlPatterns = "/airports")
public class HtmlAirportServlet extends HttpServlet {

    private IAirportService airportService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

//        List<Airport> airports = airportService.getAllAirports();

        req.setAttribute("airports", airportService.getAllAirports());
        req.getRequestDispatcher("/template/airports.jsp").forward(req, resp);
    }
}
