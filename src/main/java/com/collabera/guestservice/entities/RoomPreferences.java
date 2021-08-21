package com.collabera.guestservice.entities;


import lombok.Getter;

public enum RoomPreferences {
    standard("STANDARD"),
    delux("DELUX"),
    suite("SUITE");

    @Getter
    private String value;

    RoomPreferences(String value) {
        this.value = value;
    }
}
