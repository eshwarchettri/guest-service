package com.collabera.guestservice.sharedobject;

import com.collabera.guestservice.entities.RoomPreferences;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class GuestSharedObject implements Serializable {
    private String guestId;
    private String guestFirstName;
    private String guestLastName;
    private LocalDateTime checkinDateTime;
    private LocalDateTime checkoutDateTime;
    private RoomSharedObject room;
    private Boolean isDeleted = false;

    private long zipCode;

    private String firstAddress;

    private RoomPreferences roomPreferences;

    private String secondAddress;


    private String City;


    private String phone;


    private String specialInstruction;


    private String email;

    private Integer adults;


    private Integer children;


}
