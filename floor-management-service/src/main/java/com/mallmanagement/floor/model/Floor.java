package com.mallmanagement.floor.model;

public class Floor {
    private Integer floorId;
    private Integer floorNumber;
    private String floorName;
    private String description;

    // Empty Constructor
    public Floor() {
    }

    // Full Constructor
    public Floor(Integer floorId, Integer floorNumber, String floorName, String description) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.description = description;
    }

    // Getters and Setters
    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}