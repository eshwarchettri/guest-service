package com.collabera.guestservice.sharedObjectToEntityTranformer;

import com.example.guestbook.entities.Guest;
import com.example.guestbook.sharedobject.GuestSharedObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GuestEntityTransformer {
    public Guest transfer(GuestSharedObject sharedObject) {
        Guest guest = new Guest();
        BeanUtils.copyProperties(sharedObject, guest);

        return guest;
    }
}
