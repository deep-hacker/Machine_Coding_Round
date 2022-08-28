package com.appbrew;


import com.appbrew.repository.*;
import com.appbrew.service.CabService;
import com.appbrew.service.CabServiceImpl;
import com.appbrew.service.UserService;
import com.appbrew.service.UserServiceImpl;
import com.appbrew.strategies.CabMatchingStrategies;
import com.appbrew.strategies.DefaultCabMatchingStrategiesImpl;

public class EntryPoint {
    private static CabRepositoryImpl cabRepository = new CabRepositoryImpl();
    private static DefaultCabMatchingStrategiesImpl defaultCabMatchingStrategies = new DefaultCabMatchingStrategiesImpl();
    private static TripRepositoryImpl tripRepository = new TripRepositoryImpl(cabRepository,defaultCabMatchingStrategies);
    private static UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public static CabService cabService = new CabServiceImpl(cabRepository,tripRepository);
    public static UserService userService = new UserServiceImpl(userRepository,tripRepository);
}
