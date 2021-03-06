package com.collabera.guestservice.controller;

import com.collabera.guestservice.config.RestResponsePage;
import com.collabera.guestservice.services.GuestServices;
import com.collabera.guestservice.sharedobject.GuestSharedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    private GuestServices guestServices;

    @GetMapping("/guests")
    public Page<GuestSharedObject> getAllGuestDetails(Pageable pageable) {

        return this.guestServices.getAllGuestDetails(pageable);
    }

    @GetMapping("/guest/{id}")
    public GuestSharedObject getByGuestId(@PathVariable("id") String id) {
        return guestServices.getByGuestId(id);
    }

    @PostMapping("/save-guest")
    public GuestSharedObject addGuest(@RequestBody GuestSharedObject guest) {
        return guestServices.addGuest(guest);
    }

    @PutMapping("/guest")
    public void updateGuestDetails(@RequestBody GuestSharedObject guest, @PathVariable("id") String id) {
        guestServices.updateGuestDetails(guest, id);
    }

    @DeleteMapping("/delete-guest/{id}")
    public void deleteGuest(@PathVariable("id") String id, @RequestParam(name="reasonForDelete") String reasonToDelete) {
        guestServices.deleteGuest(id, reasonToDelete);
    }

}
