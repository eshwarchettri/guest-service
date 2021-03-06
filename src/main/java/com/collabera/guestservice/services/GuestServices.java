package com.collabera.guestservice.services;

import com.collabera.guestservice.EntityToSharedObjectTransformer.GuestSharedObjectTransformer;
import com.collabera.guestservice.Repository.GuestRepository;
import com.collabera.guestservice.config.RestResponsePage;
import com.collabera.guestservice.entities.Guest;
import com.collabera.guestservice.sharedObjectToEntityTranformer.GuestEntityTransformer;
import com.collabera.guestservice.sharedobject.GuestSharedObject;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuestServices {

    private final GuestSharedObjectTransformer guestSharedObjectTransformer;
    private final GuestEntityTransformer entityTransformer;
    private final GuestRepository guestRepository;

    public Page<GuestSharedObject> getAllGuestDetails(Pageable pageable) {

        Page<Guest> guests =  guestRepository.findAllByIsDeletedFalse(pageable);
        List<GuestSharedObject> guestSharedObjectList = guests.getContent().stream().map(guestSharedObjectTransformer::transfer).collect(Collectors.toList());


        return new PageImpl<>(guestSharedObjectList, pageable, guests.getTotalElements());
    }

    public GuestSharedObject getByGuestId(String id) {
        return  guestSharedObjectTransformer.transfer(guestRepository.findById(id).orElse(new Guest()));

    }

    public GuestSharedObject addGuest(GuestSharedObject g) {

         Guest guest = guestRepository.save(entityTransformer.transfer(g));
        return guestSharedObjectTransformer.transfer(guest);
    }

    public void updateGuestDetails(GuestSharedObject g, String id) {
        guestRepository.findById(id).ifPresent(guest1 -> {
            guest1.setCheckinDateTime(g.getCheckinDateTime());
            guest1.setCheckoutDateTime(g.getCheckoutDateTime());
            guest1.setGuestFirstName(g.getGuestFirstName());
            guest1.setGuestLastName(g.getGuestLastName());
            guestRepository.save(guest1);

        });
    }

    public void deleteGuest(String id , String reasonToDelete) {
        guestRepository.findById(id).ifPresent(guest -> {
            guest.setIsDeleted(true);
            guest.setReasonToDelete(reasonToDelete);
            guestRepository.save(guest);
        });
    }

}
