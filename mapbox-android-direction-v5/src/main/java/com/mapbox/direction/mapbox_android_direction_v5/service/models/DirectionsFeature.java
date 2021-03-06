package com.mapbox.direction.mapbox_android_direction_v5.service.models;

/**
 * Created by antonio on 11/6/15.
 */
public class DirectionsFeature {

    private String type;
    private FeatureGeometry geometry;
    private FeatureProperties properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FeatureGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(FeatureGeometry geometry) {
        this.geometry = geometry;
    }

    public FeatureProperties getProperties() {
        return properties;
    }

    public void setProperties(FeatureProperties properties) {
        this.properties = properties;
    }
}
