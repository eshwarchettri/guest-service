package com.collabera.guestservice.sharedobject;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomSharedObject implements Serializable {
    private Long roomId;
    private Long roomNumber;
}
