package com.mapbox.direction.mapbox_android_direction_v5.service.models;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by troy on 27/09/18.
 */

public class RouteLeg {
    private String summary;
    private float distance;
    private float duration;
    private float weight;
    private List<RouteStep> steps;

    public RouteLeg() {
        steps = new ArrayList<>();
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<RouteStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RouteStep> steps) {
        this.steps = steps;
    }
}
