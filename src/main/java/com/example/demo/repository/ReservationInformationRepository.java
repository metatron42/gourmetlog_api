package com.example.demo.repository;

import com.example.demo.entity.ReservationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationInformationRepository extends JpaRepository<ReservationInformation, Integer> {

}
