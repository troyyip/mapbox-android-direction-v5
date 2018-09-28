package com.mapbox.direction.mapbpx_android_direction_v5.service.models;

/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public class Waypoint {

    private double latitude;
    private double longitude;
    private String radius;
    private String waypointName;

    public Waypoint(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getWaypointName() {
        return waypointName;
    }

    public void setWaypointName(String waypointName) {
        this.waypointName = waypointName;
    }
}
