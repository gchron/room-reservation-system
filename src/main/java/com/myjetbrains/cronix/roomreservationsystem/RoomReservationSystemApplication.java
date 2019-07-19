package com.myjetbrains.cronix.roomreservationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySource(value = {"application.properties", "application-ext.properties"},
        ignoreResourceNotFound = true)
@EnableTransactionManagement
public class RoomReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomReservationSystemApplication.class, args);
    }

}
