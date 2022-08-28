package com.appbrew.service;

import com.appbrew.model.Cab;

public interface CabService {
    void registerCab(Cab newCab);
    void pushLocation(final String cabId, final Double newX, final Double newY);
}
