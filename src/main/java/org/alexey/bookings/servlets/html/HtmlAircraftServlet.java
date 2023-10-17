package org.alexey.bookings.servlets.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexey.bookings.service.api.IAircraftService;
import org.alexey.bookings.service.factory.AircraftServiceFactory;

import java.io.IOException;

@WebServlet (urlPatterns = "/aircrafts")
public class HtmlAircraftServlet extends HttpServlet {

    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        req.setAttribute("crafts", aircraftService.getAllAircrafts());

        req.getRequestDispatcher("/template/aircrafts.jsp").forward(req, resp);
    }
}
