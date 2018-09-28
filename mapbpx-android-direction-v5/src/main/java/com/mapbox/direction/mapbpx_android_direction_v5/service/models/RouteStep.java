package com.mapbox.direction.mapbpx_android_direction_v5.service.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public class RouteStep {

    private StepManeuver maneuver;
    private float distance;
    private float duration;
    private String ref;
    private String destinations;
    private String exits;
    @SerializedName("driving_side") private String drivingSide;
    private String mode;
    private String pronunciation;
    // private List<Step> intersections;


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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    public String getExits() {
        return exits;
    }

    public void setExits(String exits) {
        this.exits = exits;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public StepManeuver getManeuver() {
        return maneuver;
    }

    public void setManeuver(StepManeuver maneuver) {
        this.maneuver = maneuver;
    }
}
