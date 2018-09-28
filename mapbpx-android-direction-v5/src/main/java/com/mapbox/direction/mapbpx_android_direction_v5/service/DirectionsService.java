package com.mapbox.direction.mapbpx_android_direction_v5.service;

import com.mapbox.direction.mapbpx_android_direction_v5.service.models.DirectionsResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public interface DirectionsService {

    @GET("/directions/v5/mapbox/{profile}/{waypoints}")
    Call<DirectionsResponse> calculate(
            @Path("profile") String profile,
            @Path("waypoints") String waypoints,
            @Query("access_token") String accessToken,
            @Query("alternatives") boolean alternatives,
            @Query("annotations") String annotations,
            @Query("approaches") String approaches,
            @Query("banner_instructions") Boolean banner_instructions,
            @Query("instructions") String instructions,
            @Query("geometries") String geometry,
            @Query("steps") boolean steps,
            @Query("exclude") String exclude,
            @Query("continue_straight") Boolean continue_straight,
            @Query("language") String language,
            @Query("radiuses") String radiuses,
            @Query("roundabout_exits") Boolean roundabout_exits,
            @Query("voice_instructions") Boolean voice_instructions,
            @Query("voice_units") String voice_units,
            @Query("waypoint_names") String waypoint_names

    );

}
