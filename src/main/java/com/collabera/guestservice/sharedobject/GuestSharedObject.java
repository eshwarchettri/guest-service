package com.collabera.guestservice.sharedobject;

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
    private Boolean isDeleted=false;

}
