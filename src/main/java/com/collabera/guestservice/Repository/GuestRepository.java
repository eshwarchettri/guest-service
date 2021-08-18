package com.collabera.guestservice.Repository;

import com.example.guestbook.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {

}
