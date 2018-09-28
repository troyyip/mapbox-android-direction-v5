package com.mapbox.direction.mapbpx_android_direction_v5.service.models;

import com.google.gson.annotations.SerializedName;
import com.mapbox.direction.mapbpx_android_direction_v5.MapboxDirections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public class DirectionsRoute {

    private float distance;
    private float duration;
    private String summary;
    @SerializedName("weight_name") private String weightyName;
    private RouteGeometry geometry;
    private List<RouteLeg> legs;

    public DirectionsRoute() {
        legs = new ArrayList<>();
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWeightyName() {
        return weightyName;
    }

    public void setWeightyName(String weightyName) {
        this.weightyName = weightyName;
    }

    public RouteGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(RouteGeometry geometry) {
        this.geometry = geometry;
    }

    public List<RouteLeg> getLegs() {
        return legs;
    }

    public void setLegs(List<RouteLeg> legs) {
        this.legs = legs;
    }

    /*
     * A first approximation, reducing external library dependencies, to off-route detection.
     * It checks that the user distance to any of the points that defines the route is less than
     * the OFF_ROUTE_THRESHOLD (0.1 miles).
     */

    public boolean isOffRoute(Waypoint target) {
        List<Waypoint> waypoints = this.getGeometry().getWaypoints();

        double distance;
        for (Waypoint waypoint: waypoints) {
            distance = computeDistance(target, waypoint);
            if (distance <= MapboxDirections.OFF_ROUTE_THRESHOLD) {
                return false;
            }
        }

        return true;
    }

    /*
     * See: https://github.com/Turfjs/turf-distance
     * The result is provided in in miles.
     */

    private double computeDistance(Waypoint from, Waypoint to) {
        double dLat = Math.toRadians(to.getLatitude() - from.getLatitude());
        double dLon = Math.toRadians(to.getLongitude() - from.getLongitude());
        double lat1 = Math.toRadians(from.getLatitude());
        double lat2 = Math.toRadians(to.getLatitude());

        double a = Math.pow(Math.sin(dLat/2), 2) + Math.pow(Math.sin(dLon/2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double R = 3960;

        double distance = R * c;
        return distance;
    }
}
