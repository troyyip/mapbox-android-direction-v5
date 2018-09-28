package com.mapbox.direction.mapbpx_android_direction_v5.service.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 11/6/15.
 */
public class DirectionsResponse {

    private List<DirectionsFeature> waypoints;
    private List<DirectionsRoute> routes;

    public DirectionsResponse() {
        waypoints = new ArrayList<>();
        routes = new ArrayList<>();
    }

    public List<DirectionsFeature> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<DirectionsFeature> waypoints) {
        this.waypoints = waypoints;
    }

    public List<DirectionsRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<DirectionsRoute> routes) {
        this.routes = routes;
    }
}
