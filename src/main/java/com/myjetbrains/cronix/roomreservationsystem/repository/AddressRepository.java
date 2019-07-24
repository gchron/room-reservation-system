package com.myjetbrains.cronix.roomreservationsystem.repository;

import com.myjetbrains.cronix.roomreservationsystem.model.Address;
import com.myjetbrains.cronix.roomreservationsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressesByUser(User user);
}
