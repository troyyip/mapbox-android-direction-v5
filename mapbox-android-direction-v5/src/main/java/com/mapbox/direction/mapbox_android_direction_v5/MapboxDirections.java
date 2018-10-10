package com.mapbox.direction.mapbox_android_direction_v5;

import android.text.TextUtils;
import android.util.Log;

import com.mapbox.direction.mapbox_android_direction_v5.service.DirectionsService;
import com.mapbox.direction.mapbox_android_direction_v5.service.models.DirectionsResponse;
import com.mapbox.direction.mapbox_android_direction_v5.service.models.Waypoint;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import com.mapbox.direction.mapbox_android_direction_v5.DirectionsCriteria;


/**
 * Created by antonio on 11/6/15.
 * Modified by troy on 27/09/18.
 */
public class MapboxDirections {

    private final static String LOG_TAG = "MapboxDirections";

    public static String BASE_URL = "https://api.mapbox.com";

    private static Retrofit _retrofit;

    // 0.1 miles
    public final static double OFF_ROUTE_THRESHOLD = 0.1;

    private Call<DirectionsResponse> _call;

    public MapboxDirections(Builder builder) {
        //Log.e("endpoint", builder._endPoint);
        DirectionsService service = getService();
        _call = service.calculate(
                builder._profile,
                builder.getWaypointsFormatted("waypoint"),
                builder._accessToken,
                builder._alternatives,
                builder._annotations,
                builder._approaches,
                builder._bannerInstructions,
                builder._instructions,
                builder._geometry,
                builder._steps,
                builder._exclude,
                builder._continueStraight,
                builder._language,
                builder.getRadiusesFormatted(),
                builder._roundaboutExists,
                builder._voiceInstructions,
                builder._voiceUnits,
                builder.getWayNameFormatted()
                );
    }

    /*
     * Retrofit API
     */

    public Response<DirectionsResponse> execute() throws IOException {
        return _call.execute();
    }

    public void enqueue(Callback<DirectionsResponse> callback) {
        _call.enqueue(callback);
    }

    public void cancel() {
        _call.cancel();
    }

    public static void setEndpoint (@DirectionsCriteria.DirectionsEndpoint String newApiBaseUrl){
        BASE_URL = newApiBaseUrl;
    }

    public Call<DirectionsResponse> clone() {
        return _call.clone();
    }

    DirectionsService getService() {
        // Log the URL for debugging purposes
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Log.d(LOG_TAG, String.format("Mapbox URL: %s", request.url()));
                com.squareup.okhttp.Response response = chain.proceed(request);
                return response;
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DirectionsService service = retrofit.create(DirectionsService.class);
        _retrofit = retrofit;
        return service;

    }


    public static Retrofit retrofit(){
        return _retrofit;
    }

    /*
     * Builder
     */

    public static class Builder {

        private String _endPoint;
        private String _accessToken;
        private String _profile;
        private List<Waypoint> _waypoints;
        private Waypoint _origin;
        private Waypoint _destination;
        private boolean _alternatives;
        private String _annotations = null;
        private String _approaches = null;
        private Boolean _bannerInstructions;
        private String _exclude;
        private Boolean _continueStraight;
        private String _language;
        private boolean _radiuses;
        private Boolean _roundaboutExists;
        private Boolean _voiceInstructions;
        private String _voiceUnits;
        private boolean _waypointName;

        private String _instructions;
        private String _geometry;
        private boolean _steps;

        public Builder setEndPoint(@DirectionsCriteria.DirectionsEndpoint String endPoint){
            BASE_URL = endPoint;
            _endPoint = endPoint;
            return this;
        }

        public Builder setAccessToken(String accessToken) {
            _accessToken = accessToken;
            return this;
        }

        public Builder setProfile(@DirectionsCriteria.DirectionsProfile String profile) {
            _profile = profile;
            return this;
        }

        /*
         * We offer some convenience for the typical case where we only have an origin
         * and a destination. Instead of having to create a List of waypoints, we just
         * call setOrigin() and setDestination() which is more meaningful. That's taken
         * into account in getWaypointsFormatted()
         */

        public Builder setWaypoints(List<Waypoint> waypoints) {
            _waypoints = waypoints;
            return this;
        }

        public Builder setOrigin(Waypoint origin) {
            _origin = origin;
            return this;
        }

        public Builder setDestination(Waypoint destination) {
            _destination = destination;
            return this;
        }

        public String getWaypointsFormatted(String option) {
            String waypointsFormatted = "";

            // Set origin and destination
            if (_origin != null && _destination != null) {
                _waypoints = new ArrayList<>(Arrays.asList(_origin, _destination));
            }

            // Empty list
            if (_waypoints == null || _waypoints.size() == 0) {
                return waypointsFormatted;
            }

            // Convert to {lon},{lat} coordinate pairs
            List<String> pieces = new ArrayList<>();
            List<String> wayNames = new ArrayList<>();
            for (Waypoint waypoint: _waypoints) {
                pieces.add(String.format("%f,%f", waypoint.getLongitude(), waypoint.getLatitude()));
            }

            // The waypoints parameter should be a semicolon-separated list of locations to visit
            waypointsFormatted = TextUtils.join(";", pieces);

            return waypointsFormatted;
        }

        public String getRadiusesFormatted(){
            String radiusesFormatted = null;
            // Set origin and destination
            if (_origin != null && _destination != null) {
                _waypoints = new ArrayList<>(Arrays.asList(_origin, _destination));
            }
            List<String> radiuses = new ArrayList<>();

            if(_radiuses){
                radiusesFormatted = "";
                for (Waypoint waypoint: _waypoints) {
                    if(waypoint.getRadius()!=null){
                        radiuses.add(waypoint.getRadius());
                    }else{
                        radiuses.add("");
                    }
                }
                radiusesFormatted = TextUtils.join(";",radiuses);
            }
            return radiusesFormatted;
        }

        public String getWayNameFormatted(){
            String waynamesFormatted = null;
            if (_origin != null && _destination != null) {
                _waypoints = new ArrayList<>(Arrays.asList(_origin, _destination));
            }
            List<String> waynames = new ArrayList<>();
            if(_waypointName){
                waynamesFormatted = "";
                for (Waypoint waypoint: _waypoints) {
                    if(waypoint.getWaypointName()!=null){
                        waynames.add(waypoint.getWaypointName());
                    }else{
                        waynames.add("");
                    }
                }
                waynamesFormatted = TextUtils.join(";",waynames);
            }
            return waynamesFormatted;

        }

        public Builder setAlternatives(boolean alternatives) {
            _alternatives = alternatives;
            return this;
        }

        public Builder setInstructions(@DirectionsCriteria.DirectionsInstructions String instructions) {
            _instructions = instructions;
            return this;
        }

        public Builder setGeometry(@DirectionsCriteria.DirectionsGeometry String geometry) {
            _geometry = geometry;
            return this;
        }

        public Builder setSteps(boolean steps) {
            _steps = steps;
            return this;
        }

        public Builder setAnnotations(@DirectionsCriteria.DirectionsAnnotations String annotations){
            _annotations = annotations;
            return this;
        }

        public Builder setApproaches(@DirectionsCriteria.DirectionsApproaches String approaches){
            _approaches = approaches;
            return this;
        }

        public Builder setBannerInstructions(Boolean bannerInstructions){
            _bannerInstructions = bannerInstructions;
            return this;
        }

        public Builder setExclude(@DirectionsCriteria.DirectionsExclude String exclude){
            _exclude = exclude;
            return this;
        }

        public Builder setContinueStraight(Boolean continueStraight){
            _continueStraight = continueStraight;
            return this;
        }

        public Builder setLanguage(String language){
            _language = language;
            return this;
        }

        public Builder setRadiuses(boolean radiuses){
            _radiuses = radiuses;
            return this;
        }

        public Builder setRoundaboutExist(Boolean roundaboutExist){
            _roundaboutExists = roundaboutExist;
            return this;
        }

        public Builder setVoiceInstructions(Boolean voiceInstructions){
            _voiceInstructions = voiceInstructions;
            return this;
        }

        public Builder setVoiceUnits(@DirectionsCriteria.DirectionsVoiceUnit String voiceUnits){
            _voiceUnits = voiceUnits;
            return this;
        }

        public Builder setWaypointName(boolean waypointName){
            _waypointName = waypointName;
            return this;
        }

        // Checks if the given token is valid
        private void validateAccessToken(String accessToken) {
            if (TextUtils.isEmpty(accessToken) || (!accessToken.startsWith("pk.") && !accessToken.startsWith("sk."))) {
                throw new RuntimeException("Using the Mapbox Directions API requires setting a valid access token.");
            }
        }

        public MapboxDirections build() {
            validateAccessToken(_accessToken);
            return new MapboxDirections(this);
        }

    }
}
