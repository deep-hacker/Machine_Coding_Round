package com.appbrew.service;

import com.appbrew.model.Cab;
import com.appbrew.model.Location;
import com.appbrew.repository.CabRepository;
import com.appbrew.repository.CabRepositoryImpl;
import com.appbrew.repository.TripRepository;
import com.appbrew.repository.TripRepositoryImpl;

public class CabServiceImpl implements CabService {
    private CabRepository cabRepository;
    private TripRepository tripRepository;

    public CabServiceImpl(CabRepositoryImpl cabRepository, TripRepositoryImpl tripRepository) {
        this.cabRepository = cabRepository;
        this.tripRepository = tripRepository;
    }

    public void registerCab(Cab newCab){
        cabRepository.createCab(newCab);
    }

    public void pushLocation(final String cabId, final Double newX, final Double newY) {

        cabRepository.updateCabLocation(cabId, new Location(newX, newY));
    }

}
