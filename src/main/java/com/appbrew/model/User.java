package com.appbrew.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class User extends BaseModel {
    String name;

    public User(String Id,String name) {
        super.setId(Id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getId(){
        return super.getId();
    }
}
