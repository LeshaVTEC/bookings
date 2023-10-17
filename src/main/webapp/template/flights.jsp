
<%@ page import="org.alexey.bookings.dto.Flight" %>
<%@ page import="java.util.List" %>
 <!DOCTYPE html>
 <html>
  <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Flights</title>
  </head>
  <body>
      <h1>Flights</h1>
                      <%
                      List<Flight> flights = (List) request.getAttribute("flights");
                      %>
                          <table border="1">
                              <thead>
                                  <tr>
                                      <th>flight_id</th>
                                      <th>flight_no</th>
                                      <th>scheduled_departure</th>
                                      <th>scheduled_arrival</th>
                                      <th>departure_airport</th>
                                      <th>arrival_airport</th>
                                      <th>status</th>
                                      <th>aircraft_code</th>
                                      <th>actual_departure;</th>
                                      <th>actual_arrival</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <% for (Flight flight : flights) { %>
                                    <tr>
                                      <td><%= flight.getFlight_id() %></td>
                                      <td><%= flight.getFlight_no() %></td>
                                      <td><%= flight.getScheduled_departure() %></td>
                                      <td><%= flight.getScheduled_arrival() %></td>
                                      <td><%= flight.getDeparture_airport() %></td>
                                      <td><%= flight.getArrival_airport() %></td>
                                      <td><%= flight.getStatus() %></td>
                                      <td><%= flight.getAircraft_code() %></td>
                                      <td><%= flight.getActual_departure() %></td>
                                      <td><%= flight.getActual_arrival() %></td>
                                    </tr>
                                  <% } %>
                              </tbody>
                          </table>
  </body>
  </html>