package org.alexey.bookings.dto;

import org.postgresql.geometric.PGpoint;

public class Airport {
    private String airport_code;
    private String airport_name;
    private String city;
    private PGpoint coordinates;
    private String timezone;

    public Airport(String airport_code, String airport_name, String city, PGpoint coordinates, String timezone) {
        this.airport_code = airport_code;
        this.airport_name = airport_name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PGpoint getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(PGpoint coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airport_code='" + airport_code + '\'' +
                ", airport_name='" + airport_name + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
