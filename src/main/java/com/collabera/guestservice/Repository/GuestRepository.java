package com.collabera.guestservice.Repository;

import com.collabera.guestservice.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {

}
