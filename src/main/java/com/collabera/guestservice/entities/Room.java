package com.collabera.guestservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROOM_ID")
    private long roomId;
    @Column(name="ROOM_NUMBER")
    private long roomNumber;

  //  @OneToOne(mappedBy = "room")
    //private Guest guest;

}
