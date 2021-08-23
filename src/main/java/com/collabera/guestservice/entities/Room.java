package com.collabera.guestservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOM_DTLS")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID", nullable = false)
    private Long roomId;

    @Column(name = "ROOM_NUMBER")
    private Long roomNumber;

    @Column(name = "IS_AVAILABLE")
    private Boolean isAvailable;

    @Column(name = "ROOM_TYPE")
    @Enumerated(EnumType.STRING)
    private RoomPreferences roomType;

}
