package com.appbrew.repository;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import lombok.NonNull;

import java.util.List;

public interface CabRepository {
    void createCab( @NonNull final Cab newCab);
    Cab getCab(@NonNull final String cabId);
    void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation);
    void bookCab(@NonNull final String cabId);
    void releaseCab(@NonNull final String cabId);
    List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance);
}
