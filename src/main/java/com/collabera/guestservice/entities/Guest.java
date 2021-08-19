package com.collabera.guestservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "GUEST_ID", updatable = false, nullable = false, length = 40)
    private String guestId;

    @Column(name = "GUEST_FIRST_NAME")
    private String guestFirstName;

    @Column(name = "GUEST_LAST_NAME")
    private String guestLastName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CHECKIN_DATETIME")
    private LocalDateTime checkinDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "CHECKOUT_DATETIME")
    private LocalDateTime checkoutDateTime;

    @Column(name = "FIRST_ADDRESS")
    private String firstAddress;

    @Column(name = "SECOND_ADDRESS")
    private String secondAddress;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "SPECIAL_INSTRUCTION")
    private String specialInstruction;

    @Column(name = "E-MAIL")
    private String email;

    @Column(name = "ZIP_CODE")
    private Long zipCode;

    @Column(name = "ADULTS")
    private Integer adults;

    @Column(name = "CHILDREN")
    private Integer children;

    @Column(name="ROOM_PREFERENCE")
    @Enumerated(EnumType.STRING)
    private RoomPreferences roomPreferences;

    @JoinColumn(name = "ROOM_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;

}
