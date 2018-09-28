package com.mapbox.direction.mapbpx_android_direction_v5;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public class DirectionsCriteria {

    /*
     * DirectionsProfile "typedef"
     */

    @StringDef({PROFILE_DRIVING, PROFILE_WALKING, PROFILE_CYCLING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsProfile {}

    public static final String PROFILE_DRIVING = "driving";
    public static final String PROFILE_WALKING = "walking";
    public static final String PROFILE_CYCLING = "cycling";
    public static final String PROFILE_DRIVING_TRAFFIC = "driving-traffic";
    /*
     * DirectionsInstructions "typedef"
     */

    @StringDef({INSTRUCTIONS_TEXT, INSTRUCTIONS_HTML})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsInstructions {}

    public static final String INSTRUCTIONS_TEXT = "text";
    public static final String INSTRUCTIONS_HTML = "html";

    /*
     * DirectionsGeometry "typedef"
     */

    @StringDef({GEOMETRY_GEOJSON, GEOMETRY_POLYLINE, GEOMETRY_FALSE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsGeometry {}

    public static final String GEOMETRY_GEOJSON = "geojson";
    public static final String GEOMETRY_POLYLINE = "polyline";
    public static final String GEOMETRY_FALSE = "false";

    /*
     * DirectionsAnnotations "typedef"
     */
    @StringDef({ANNOTATION_DURATION, ANNOTATION_DISTANCE, ANNOTATION_SPEED, ANNOTATION_CONGESTION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsAnnotations {}
    public static final String ANNOTATION_DURATION = "duration";
    public static final String ANNOTATION_DISTANCE = "distance";
    public static final String ANNOTATION_SPEED = "speed";
    public static final String ANNOTATION_CONGESTION = "congestion";

    /*
     * DirectionsApproaches "typedef"
     */
    @StringDef({APPROACHES_UNRESTRICTED, APPROACHES_DRIVINGSIDE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsApproaches {}
    public static final String APPROACHES_UNRESTRICTED = "unrestricted";
    public static final String APPROACHES_DRIVINGSIDE = "driving_side";

    /*
     * DirectionsExclude "typedef"
     */
    @StringDef({EXCLUDE_TOLL, EXCLUDE_MOTORWAY, EXCLUDE_FERRY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsExclude {}
    public static final String EXCLUDE_TOLL = "toll";
    public static final String EXCLUDE_MOTORWAY = "motorway";
    public static final String EXCLUDE_FERRY = "ferry";

    /*
     * DirectionsExclude "typedef"
     */
    @StringDef({EXCLUDE_TOLL, EXCLUDE_MOTORWAY, EXCLUDE_FERRY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DirectionsVoiceUnit {}
    public static final String VOICE_UNITS_IMPERIAL = "imperial";
    public static final String VOICE_UNITS_METRIC = "metric";

}
