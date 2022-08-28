package com.appbrew.strategies;

import com.appbrew.model.Cab;
import com.appbrew.model.User;
import lombok.NonNull;

import java.util.List;

public class DefaultCabMatchingStrategiesImpl implements CabMatchingStrategies {

    @Override
    public Cab matchCabToUser(
            @NonNull final User rider,
            @NonNull final List<Cab> candidateCabs) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.get(0);
    }

}
