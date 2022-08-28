package com.appbrew.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
public class Trip extends BaseModel{
    private User user;
    private Cab cab;
    private Location startingPoint;
    private Location destination;
    public String getId(){
        return super.getId();
    }

    public Trip(String Id, User user, Cab cab, Location startingPoint, Location destination) {
        super.setId(Id);
        super.setCreatedAt(new Date());
        this.user = user;
        this.cab = cab;
        this.startingPoint = startingPoint;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Id='" + Id + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", cab=" + cab +
                ", startingPoint=" + startingPoint +
                ", destination=" + destination +
                '}';
    }
}
