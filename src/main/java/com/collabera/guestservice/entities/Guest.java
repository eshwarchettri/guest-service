package com.collabera.guestservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="GUEST_ID")
    private long guestId;

    @Column(name = "GUEST_FIRST_NAME")
    private String guestFirstName;

    @Column(name = "GUEST_LAST_NAME")
    private String guestLastName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CHECKIN_DATETIME")
    private LocalDateTime checkinDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name="CHECKOUT_DATETIME")
    private LocalDateTime checkoutDateTime;

    @OneToOne(mappedBy = "ROOM_ID" ,cascade = CascadeType.ALL)
    private Room room;

    private Boolean isDeleted = false;

}
