package org.alexey.bookings.dto;

import java.time.LocalDateTime;

public class Flight {
    private Integer flight_id;
    private String flight_no;
    private LocalDateTime scheduled_departure;
    private LocalDateTime scheduled_arrival;
    private String departure_airport;
    private String arrival_airport;
    private String status;
    private String aircraft_code;
    private LocalDateTime actual_departure;
    private LocalDateTime actual_arrival;

    public Flight(Integer flight_id, String flight_no, LocalDateTime scheduled_departure, LocalDateTime scheduled_arrival, String departure_airport, String arrival_airport, String status, String aircraft_code, LocalDateTime actual_departure, LocalDateTime actual_arrival) {
        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_arrival = scheduled_arrival;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.status = status;
        this.aircraft_code = aircraft_code;
        this.actual_departure = actual_departure;
        this.actual_arrival = actual_arrival;
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public LocalDateTime getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(LocalDateTime scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public LocalDateTime getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(LocalDateTime scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    public LocalDateTime getActual_departure() {
        return actual_departure;
    }

    public void setActual_departure(LocalDateTime actual_departure) {
        this.actual_departure = actual_departure;
    }

    public LocalDateTime getActual_arrival() {
        return actual_arrival;
    }

    public void setActual_arrival(LocalDateTime actual_arrival) {
        this.actual_arrival = actual_arrival;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flight_id +
                ", flight_no='" + flight_no + '\'' +
                ", scheduled_departure=" + scheduled_departure +
                ", scheduled_arrival=" + scheduled_arrival +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", status='" + status + '\'' +
                ", aircraft_code='" + aircraft_code + '\'' +
                ", actual_departure=" + actual_departure +
                ", actual_arrival=" + actual_arrival +
                '}';
    }
}
