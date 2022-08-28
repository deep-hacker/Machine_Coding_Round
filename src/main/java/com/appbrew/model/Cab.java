package com.appbrew.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.appbrew.strategies.CabMatchingStrategies;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class Cab extends BaseModel {
  String driverName;
  Trip currentTrip;
  Location currentLocation;
  CabMatchingStrategies cabMatchingStrategy;
  CabBookingStatus cabBookingStatus;

  public Cab(String Id,String driverName, Trip currentTrip, Location currentLocation, CabMatchingStrategies cabMatchingStrategy, CabBookingStatus cabBookingStatus) {
    super.setId(Id);
    super.setCreatedAt(new Date());
    this.driverName = driverName;
    this.currentTrip = currentTrip;
    this.currentLocation = currentLocation;
    this.cabMatchingStrategy = cabMatchingStrategy;
    this.cabBookingStatus = cabBookingStatus;
  }

  public String getId(){
    return super.getId();
  }

  public Boolean isAvailable(){
    return this.cabBookingStatus.equals(CabBookingStatus.NOT_ALLOCATED);
  }

  public void bookCab() throws RuntimeException{
    if(isAvailable()) setCabBookingStatus(CabBookingStatus.ALLOCATED);
    else{
      throw new RuntimeException("Cab already booked");
    }
  }

  public void releaseCab() {
    setCabBookingStatus(CabBookingStatus.NOT_ALLOCATED);
  }

  @Override
  public String toString() {
    return "Cab{" +
            "Id='" + Id + '\'' +
            ", createdAt=" + createdAt +
            ", driverName='" + driverName + '\'' +
            ", currentLocation=" + currentLocation +
            ", cabMatchingStrategy=" + cabMatchingStrategy +
            ", cabBookingStatus=" + cabBookingStatus +
            '}';
  }
}
