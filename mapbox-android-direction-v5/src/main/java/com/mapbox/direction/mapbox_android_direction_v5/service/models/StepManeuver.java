package com.mapbox.direction.mapbox_android_direction_v5.service.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by antonio on 11/6/15.
 */
public class StepManeuver {

    @SerializedName("bearing_before") private int bearing_before;
    @SerializedName("bearing_after") private int bearing_after;
    private String instruction;
    private float[] location;
    private String modifier;
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float[] getLocation() {
        return location;
    }

    public void setLocation(float[] location) {
        this.location = location;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
