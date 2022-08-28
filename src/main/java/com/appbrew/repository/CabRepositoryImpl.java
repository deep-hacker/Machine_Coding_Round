package com.appbrew.repository;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabRepositoryImpl implements CabRepository {

    Map<String, Cab> cabs = new HashMap<>();
    @Override
    public void createCab(@NonNull Cab newCab) {
        if (cabs.containsKey(newCab.getId())) {
            throw new RuntimeException("Cabs Already Exists");
        }
        cabs.put(newCab.getId(), newCab);
    }

    @Override
    public Cab getCab(@NonNull String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new RuntimeException("Cab Not Found");
        }
        return cabs.get(cabId);
    }

    @Override
    public void updateCabLocation(@NonNull String cabId, @NonNull Location newLocation) {
        if (!cabs.containsKey(cabId)) {
            throw new RuntimeException("Cab Not Found");
        }
        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    @Override
    public void bookCab(@NonNull String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new RuntimeException("Cab Not Found");
        }
        cabs.get(cabId).bookCab();


    }

    @Override
    public void releaseCab(@NonNull String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new RuntimeException("Cab Not Found");
        }
        cabs.get(cabId).releaseCab();
    }

    @Override
    public List<Cab> getCabs(@NonNull Location fromPoint, @NonNull Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.isAvailable() && Double.compare(cab.getCurrentLocation().distance(fromPoint), distance)<=0) {
                result.add(cab);
            }
        }
        return result;
    }
}

