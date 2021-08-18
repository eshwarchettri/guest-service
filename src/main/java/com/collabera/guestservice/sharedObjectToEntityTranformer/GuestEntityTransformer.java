package com.collabera.guestservice.sharedObjectToEntityTranformer;


import com.collabera.guestservice.entities.Guest;
import com.collabera.guestservice.sharedobject.GuestSharedObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GuestEntityTransformer {
    public Guest transfer(GuestSharedObject sharedObject) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sharedObject, Guest.class);
    }
}
