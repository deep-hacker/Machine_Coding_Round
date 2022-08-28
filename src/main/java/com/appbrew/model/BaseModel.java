package com.appbrew.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String Id;
    @CreatedDate
    public Date createdAt;
}
