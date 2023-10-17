
<%@ page import="org.alexey.bookings.dto.Airport" %>
<%@ page import="java.util.List" %>
 <!DOCTYPE html>
 <html>
  <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Airports</title>
  </head>
  <body>
      <h1>Airports</h1>
                      <%
                      List<Airport> airports = (List) request.getAttribute("airports");
                      %>
                          <table border="1">
                              <thead>
                                  <tr>
                                      <th>Code</th>
                                      <th>Name</th>
                                      <th>City</th>
                                      <th>Coordinates</th>
                                      <th>Timezone</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <% for (Airport airport : airports) { %>
                                    <tr>
                                      <td><%= airport.getAirport_code() %></td>
                                      <td><%= airport.getAirport_name() %></td>
                                      <td><%= airport.getCity() %></td>
                                      <td><%= airport.getCoordinates() %></td>
                                      <td><%= airport.getTimezone() %></td>
                                    </tr>
                                  <% } %>
                              </tbody>
                          </table>
  </body>
  </html>
