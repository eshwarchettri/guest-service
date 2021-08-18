package com.collabera.guestservice.controller;

import com.example.guestbook.services.GuestServices;
import com.example.guestbook.sharedobject.GuestSharedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

@Autowired
    private GuestServices guestServices;

    @GetMapping("/guests")
    public List<GuestSharedObject> getAllGuestDetails() {

        return this.guestServices.getAllGuestDetails();
    }
    @GetMapping("/guest/{id}")
    public GuestSharedObject getByGuestId(@PathVariable("id")Long id)
    {
        return guestServices.getByGuestId(id);
    }

    @PostMapping("/guest")
    public GuestSharedObject addGuest(@RequestBody GuestSharedObject guest)
    {
        return guestServices.addGuest(guest);
    }
    @PutMapping("/guest")
    public void updateGuestDetails(@RequestBody GuestSharedObject guest,@PathVariable("id") Long id)
    {
         guestServices.updateGuestDetails(guest,id);
    }
    @DeleteMapping("/guest/{id}")
    public void deleteGuest(@PathVariable("id") Long id)
    {
        guestServices.deleteGuest(id);
    }

}