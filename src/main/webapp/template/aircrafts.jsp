
<%@ page import="org.alexey.bookings.dto.Aircraft" %>
<%@ page import="java.util.List" %>
 <!DOCTYPE html>
 <html>
  <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Aircrafts</title>
  </head>
  <body>
      <h1>Aircrafts</h1>
                      <%
                      List<Aircraft> aircrafts = (List) request.getAttribute("crafts");
                      %>
                          <table border="1">
                              <thead>
                                  <tr>
                                      <th>Code</th>
                                      <th>Model</th>
                                      <th>Range</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <% for (Aircraft aircraft : aircrafts) { %>
                                    <tr>
                                      <td><%= aircraft.getAircraft_code() %></td>
                                      <td><%= aircraft.getModel() %></td>
                                      <td><%= aircraft.getRange() %></td>
                                    </tr>
                                  <% } %>
                              </tbody>
                          </table>
  </body>
  </html>