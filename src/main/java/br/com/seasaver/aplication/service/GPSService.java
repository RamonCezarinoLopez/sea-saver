package br.com.seasaver.aplication.service;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GPSService {
    private final String apiKey; // Sua chave de API do Google Maps

    public GPSService() {
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
