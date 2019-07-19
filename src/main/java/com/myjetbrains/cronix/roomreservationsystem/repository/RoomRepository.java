package com.myjetbrains.cronix.roomreservationsystem.repository;

import com.myjetbrains.cronix.roomreservationsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
