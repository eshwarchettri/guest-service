package com.collabera.guestservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "GUEST_DTLS")
public class Guest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "GUEST_ID", updatable = false, nullable = false, length = 40)
    private String guestId;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String guestFirstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String guestLastName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CHECKIN_DATETIME", nullable = false)
    private LocalDateTime checkinDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "CHECKOUT_DATETIME", nullable = false)
    private LocalDateTime checkoutDateTime;

    @Column(name = "FIRST_ADDRESS", nullable = false, length = 55)
    private String firstAddress;

    @Column(name = "SECOND_ADDRESS")
    private String secondAddress;

    @Column(name = "CITY", nullable = false, length = 40)
    private String city;

    @Column(name = "STATE", nullable = false, length = 40)
    private String state;

    @Column(name = "PHONE", nullable = false, length = 12)
    private String phone;

    @Column(name = "SPECIAL_INSTRUCTION", length = 140)
    private String specialInstruction;

    @Column(name = "E_MAIL", nullable = false)
    private String email;

    @Column(name = "ZIP_CODE", nullable = false, length = 6)
    private Long zipCode;

    @Column(name = "ADULTS", nullable = false)
    private Long adults;

    @Column(name = "CHILDREN", nullable = false)
    private Long children;

    @Column(name="ROOM_PREFERENCE", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomPreferences roomPreferences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

}
