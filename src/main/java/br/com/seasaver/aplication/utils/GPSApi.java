package br.com.seasaver.aplication.utils;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;
public class GPSApi {
    private final String apiKey;

    public GPSApi() {
        // Utilizando uma chave API falsa
        this.apiKey = "AIzaSyDKnpAVGGT9QzUoDtVcvuUX8mYJB6vlYhM";
    }

    public LatLng getCoordinates(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        if (results.length > 0) {
            return results[0].geometry.location;
        }
        return null;
        }

    }

