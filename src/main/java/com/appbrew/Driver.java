package com.appbrew;

import com.appbrew.model.Cab;
import com.appbrew.model.*;
import com.appbrew.model.Location;
import com.appbrew.model.User;
import com.appbrew.strategies.CabMatchingStrategies;
import com.appbrew.strategies.DefaultCabMatchingStrategiesImpl;

import java.util.List;

public class Driver {

    public static void main(String[] args) {


        User user1 = new User("1","Vivek");
        User user2 = new User("2","Mayan");
        CabMatchingStrategies cabMatchingStrategies = new DefaultCabMatchingStrategiesImpl();
        Cab cab = new Cab("1","Driver1",null,new Location(1.0,2.0),cabMatchingStrategies, CabBookingStatus.NOT_ALLOCATED);
        EntryPoint.userService.registerUser(user1);
        EntryPoint.userService.registerUser(user2);
        EntryPoint.cabService.registerCab(cab);
        EntryPoint.userService.bookCab(user1,new Location(3.0,4.0),new Location(5.0,6.0));
        List<Trip> trips = EntryPoint.userService.getAllTripHistory(user1);
        for(Trip trip:trips){
            System.out.println(trip.toString());
        }

    }
/*
User
Id
Name

Driver
Id
Name
gridId
VehicleInfo
Status Free

Location
latitude
longitude
DriverId

VehicleInfo
Id
Model

Trip
Id TimeStamp+Userid
UserId
DriverId
Rating
Date

GET /findAllPastTrips?userId="123"&offset=0size=25

Select * FROM User Inner Join Trip on User.Id = Trip.UserId  where User.Id = :userId

SELECT * From Driver where gridId = :gridId and Status = free;
UPDATE
*/

}






