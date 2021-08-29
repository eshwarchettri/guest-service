package com.collabera.guestservice.Repository;

import com.collabera.guestservice.entities.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GuestRepository extends PagingAndSortingRepository<Guest,String> {
Page<Guest> findAllByIsDeletedFalse(Pageable paging);
}
