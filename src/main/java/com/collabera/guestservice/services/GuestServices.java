package com.collabera.guestservice.services;

import com.collabera.guestservice.EntityToSharedObjectTransformer.GuestSharedObjectTransformer;

import com.collabera.guestservice.Repository.GuestRepository;
import com.collabera.guestservice.entities.Guest;
import com.collabera.guestservice.sharedObjectToEntityTranformer.GuestEntityTransformer;
import com.collabera.guestservice.sharedobject.GuestSharedObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuestServices {

    private GuestSharedObjectTransformer guestSharedObjectTransformer;
    private GuestEntityTransformer entityTransformer;
    private GuestRepository guestRepository;

    public List<GuestSharedObject> getAllGuestDetails() {
        return guestRepository.findAll().stream().map(guest -> guestSharedObjectTransformer.transfer(guest)).collect(Collectors.toList());
    }

    public GuestSharedObject getByGuestId(Long id) {
        return  guestSharedObjectTransformer.transfer(guestRepository.findById(id).orElse(new Guest()));

    }

    public GuestSharedObject addGuest(GuestSharedObject g) {

         Guest guest = guestRepository.save(entityTransformer.transfer(g));
        return guestSharedObjectTransformer.transfer(guest);
    }

    public void updateGuestDetails(GuestSharedObject g, Long id) {
        guestRepository.findById(id).ifPresent(guest1 -> {
            guest1.setCheckinDateTime(g.getCheckinDateTime());
            guest1.setCheckoutDateTime(g.getCheckoutDateTime());
            guest1.setGuestFirstName(g.getGuestFirstName());
            guest1.setGuestLastName(g.getGuestLastName());
            guestRepository.save(guest1);

        });
    }

    public void deleteGuest(Long id) {
        guestRepository.findById(id).ifPresent(d -> guestRepository.delete(d));
    }

}
