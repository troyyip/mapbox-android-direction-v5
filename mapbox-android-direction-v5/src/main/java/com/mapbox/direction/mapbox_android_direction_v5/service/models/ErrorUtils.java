package com.mapbox.direction.mapbox_android_direction_v5.service.models;

import com.mapbox.direction.mapbox_android_direction_v5.MapboxDirections;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.lang.annotation.Annotation;
import retrofit.Converter;
import retrofit.Response;

/**
 * Created by troy on 27/09/18.
 */
public class ErrorUtils {
    public static APIError parseError(Response<?> response, MapboxDirections md){

        Converter<ResponseBody, APIError> converter =

                md.retrofit().responseConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}
