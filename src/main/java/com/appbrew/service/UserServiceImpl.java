package com.appbrew.service;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import com.appbrew.model.Trip;
import com.appbrew.model.User;
import com.appbrew.repository.*;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TripRepository tripRepository;

    public UserServiceImpl(UserRepository userRepository, TripRepositoryImpl tripRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
    }

    public void registerUser(User newUser){
        userRepository.createUser(newUser);
    }

    public void bookCab(User newUser, Location source, Location destination){
         tripRepository.createTrip(newUser, source,destination);
    }

    public List<Trip> getAllTripHistory(final User user){
       List<Trip> trips = tripRepository.tripHistory(user);
       return trips;
    }
}
