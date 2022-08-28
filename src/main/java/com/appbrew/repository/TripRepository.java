package com.appbrew.repository;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import com.appbrew.model.Trip;
import com.appbrew.model.User;
import lombok.NonNull;

import java.util.List;

public interface TripRepository {
    void createTrip(
            @NonNull User user,
            @NonNull Location startingPoint,
            @NonNull Location destination);

    List<Trip> tripHistory(@NonNull User rider);

    void endTrip(@NonNull Cab cab);
}
