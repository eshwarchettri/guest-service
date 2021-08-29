package com.collabera.guestservice.entities;


import lombok.Getter;

public enum RoomPreferences {
    STANDARD("STANDARD"),
    DELUX("DELUX"),
    SUITE("SUITE");

    @Getter
    private String value;

    RoomPreferences(String value) {
        this.value = value;
    }
}
