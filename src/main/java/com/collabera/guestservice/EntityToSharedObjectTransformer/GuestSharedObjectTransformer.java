package com.collabera.guestservice.EntityToSharedObjectTransformer;


import com.collabera.guestservice.entities.Guest;
import com.collabera.guestservice.sharedobject.GuestSharedObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestSharedObjectTransformer {

    public GuestSharedObject transfer(Guest g) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(g, GuestSharedObject.class);
    }
}
