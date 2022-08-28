package com.appbrew.service;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import com.appbrew.model.Trip;
import com.appbrew.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User newUser);
    void bookCab(User newUser, Location source, Location destination);
    List<Trip> getAllTripHistory(final User user);
}
