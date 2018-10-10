
# Mapbox directions V5 client for Android

[Mapbox Directions](https://www.mapbox.com/developers/api/directions/) client for Android.
This version is updated from [mapbox-directions-android](https://github.com/mbmc/mapbox-directions-android), it allows all the parameters for the Mapbox Directions V5. 



## Installation

We recommend installing with Gradle. This will automatically install the necessary dependencies and pull the library binaries from the Mapbox Android repository on Maven Central.

To install the current _stable version_ add this to your `build.gradle`:

```
repositories {
    maven { url 'https://dl.bintray.com/troy0826/maven' }
}

dependencies {
   implementation 'com.mapboxsdk.android:mapboxSDK:1.1.3@aar'
}
```



## Usage

To benefit from the full Mapbox Directions API, use the `MapboxDirections` object.

For example, to get walking directions from Dupont Circle to The White House
(in Washington, DC) you could do the following:

```
// Dupont Circle
Waypoint origin = new Waypoint(-77.04341, 38.90962);

// The White House
Waypoint destination = new Waypoint(-77.0365, 38.8977);

MapboxDirections md = new MapboxDirections.Builder()
        .setAccessToken(MAPBOX_ACCESS_TOKEN)
        .setOrigin(origin)
        .setDestination(destination)
        .setProfile(DirectionsCriteria.PROFILE_WALKING)
        .build();
```

Once the `client` object has been created, you can launch a syncronous request
(remember not do this in the main UI thread):

```
Response<DirectionsResponse> response = client.execute();
```

Or an asynchronous request (you need to provide your own `Callback<DirectionsResponse>`):

```
client.enqueue(callback)
```

For China, you can switch the endpoint by passing value to `setEndPoint()`
```
md.setEndPoint(DirectionsCriteria.ENDPOINT_COM)
```

## Response object

The `DirectionsResponse` object contains all the information about the routes as computed by our directions engine.

For example, you can get the distance and duration for the sample route queried above with:

```
DirectionsRoute route = response.body().getRoutes().get(0);
route.getDistance() // 1553 (in meters)
route.getDuration() // 1134 (in seconds)
```

## Draw the route on a map

You can also draw the route path on a [Mapbox map](https://www.mapbox.com/android-sdk/) with only a few lines of code. Convert the route waypoints into a LatLng array, and pass it to the map object:

```
// Convert List<Waypoint> into LatLng[]
List<Waypoint> waypoints = route.getGeometry().getWaypoints();
LatLng[] point = new LatLng[waypoints.size()];
for (int i = 0; i < waypoints.size(); i++) {
    point[i] = new LatLng(
            waypoints.get(i).getLatitude(),
            waypoints.get(i).getLongitude());
}

// Draw Points on MapView
mapView.addPolyline(new PolylineOptions()
        .add(point)
        .color(Color.parseColor("#3887be"))
        .width(5));
```

## Detect when the user is off-route

The `isOffRoute()` method will calculate the distance between the provided `userLocation` and every waypoint in the route, resulting in an off-route status if the distance is always bigger than a threshold (currently 0.1 miles):

```
if (route.isOffRoute(userLocation)) {
    Toast.makeText(this, "You are off-route.", Toast.LENGTH_SHORT).show();
}
```

