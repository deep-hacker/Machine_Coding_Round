package com.appbrew.repository;

import com.appbrew.model.Location;
import com.appbrew.model.*;
import com.appbrew.strategies.CabMatchingStrategies;
import com.appbrew.strategies.DefaultCabMatchingStrategiesImpl;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class TripRepositoryImpl implements TripRepository {
    private static Double MAX_ALLOWED_GRID_RADIUS = 5.0;
    private CabRepository cabRepository;
    private CabMatchingStrategies cabMatchingStrategy;
    private Map<String, List<Trip>> trips = new HashMap<>();

    public TripRepositoryImpl(CabRepositoryImpl cabRepository, DefaultCabMatchingStrategiesImpl cabMatchingStrategy) {
        this.cabRepository = cabRepository;
        this.cabMatchingStrategy = cabMatchingStrategy;
    }

    @Override
    public void createTrip(
            @NonNull final User user,
            @NonNull final Location startingPoint,
            @NonNull final Location destination) {
        final List<Cab> closeByCabs =
                cabRepository.getCabs(startingPoint, MAX_ALLOWED_GRID_RADIUS);
        final List<Cab> closeByAvailableCabs =
                closeByCabs.stream()
                        .filter(cab -> cab.getCurrentTrip() == null)
                        .collect(Collectors.toList());

        final Cab selectedCab =
                cabMatchingStrategy.matchCabToUser(user, closeByAvailableCabs);
        if (selectedCab == null) {
            throw new RuntimeException("No Cab Available");
        }

        final Trip newTrip = new Trip(String.valueOf(System.currentTimeMillis())+user.getId(),user, selectedCab, startingPoint, destination);
        if (!trips.containsKey(user.getId())) {
            trips.put(user.getId(), new ArrayList<>());
        }
        trips.get(user.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
        selectedCab.bookCab();
    }

    @Override
    public List<Trip> tripHistory(@NonNull final User rider) {
        return trips.get(rider.getId());
    }

    @Override
    public void endTrip(@NonNull final Cab cab) {
        if (cab.getCurrentTrip() == null) {
            throw new RuntimeException("Trip Not Found");
        }

        cab.releaseCab();
        cab.setCurrentTrip(null);
    }
}
