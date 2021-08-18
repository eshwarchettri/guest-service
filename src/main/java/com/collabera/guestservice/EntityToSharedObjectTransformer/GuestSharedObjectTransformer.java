package com.collabera.guestservice.EntityToSharedObjectTransformer;

import com.example.guestbook.entities.Guest;
import com.example.guestbook.sharedobject.GuestSharedObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GuestSharedObjectTransformer {

    public  GuestSharedObject transfer(Guest g) {
    GuestSharedObject guestSharedObject = new GuestSharedObject();
        BeanUtils.copyProperties(g, guestSharedObject);
        return  guestSharedObject;
    }
}
