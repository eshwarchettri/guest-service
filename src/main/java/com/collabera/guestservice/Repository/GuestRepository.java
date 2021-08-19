package com.collabera.guestservice.Repository;

import com.collabera.guestservice.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest,String> {
List<Guest> findAllByIsDeletedFalse();
}
