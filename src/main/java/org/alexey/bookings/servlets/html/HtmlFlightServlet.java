package org.alexey.bookings.servlets.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexey.bookings.dto.FlightFilter;
import org.alexey.bookings.dto.Pageable;
import org.alexey.bookings.service.api.IFlightService;
import org.alexey.bookings.service.factory.FlightServiceFactory;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet (urlPatterns = "/flights")
public class HtmlFlightServlet extends HttpServlet {

    private static final String PAGE = "page";
    private static final String SIZE = "size";
    private static final String SCHEDULED_DEPARTURE = "scheduled_departure";
    private static final String SCHEDULED_ARRIVAL = "scheduled_arrival";
    private static final String DEPARTURE_AIRPORT = "departure_airport";
    private static final String ARRIVAL_AIRPORT = "arrival_airport";
    private static final String STATUS = "status";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String scheduled_departure_String = req.getParameter(SCHEDULED_DEPARTURE);
        LocalDate scheduled_departure = null;
        if (scheduled_departure_String != null && !scheduled_departure_String.isBlank()) {
             scheduled_departure = LocalDate.parse(scheduled_departure_String, formatter);
        }

        String scheduled_arrival_String = req.getParameter(SCHEDULED_ARRIVAL);
        LocalDate scheduled_arrival = null;
        if (scheduled_arrival_String != null && !scheduled_arrival_String.isBlank()) {
             scheduled_arrival = LocalDate.parse(scheduled_arrival_String, formatter);
        }

        String departure_airport = req.getParameter(DEPARTURE_AIRPORT);

        String arrival_airport = req.getParameter(ARRIVAL_AIRPORT);

        String status = req.getParameter(STATUS);

        String pageNumberString = req.getParameter(PAGE);
        Integer pageNumber = NumberUtils.toInt(pageNumberString, 1);

        String sizeString = req.getParameter(SIZE);
        Integer size = NumberUtils.toInt(sizeString, 10);

        FlightFilter filter = new FlightFilter(scheduled_departure, scheduled_arrival, departure_airport, arrival_airport, status);
        Pageable pageable = new Pageable(pageNumber, size);

        req.setAttribute("flights", flightService.getFlightsWithFilters(filter, pageable));
        req.getRequestDispatcher("/template/flights.jsp").forward(req, resp);


    }
}
