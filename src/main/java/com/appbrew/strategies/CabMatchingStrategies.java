package com.appbrew.strategies;

import com.appbrew.model.Cab;
import com.appbrew.model.User;
import lombok.NonNull;

import java.util.List;

public interface CabMatchingStrategies {
     Cab matchCabToUser(@NonNull final User user, @NonNull final List<Cab> candidateCabs);
}
