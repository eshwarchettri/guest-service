package com.collabera.guestservice.entities;


public enum RoomPreferences {
    STANDARD("standard"),
    DELUX("delux"),
    SUITE("suite");
    private String value;

    RoomPreferences(String value) {
        this.value = value;
    }
}
