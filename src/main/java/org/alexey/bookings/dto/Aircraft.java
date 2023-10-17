package org.alexey.bookings.dto;


public class Aircraft {

    private String aircraftCode;
    private String model;
    private Integer range;

    public Aircraft(String aircraftCode, String model, Integer range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraft_code='" + aircraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }

}
