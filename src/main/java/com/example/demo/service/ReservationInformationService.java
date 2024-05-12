package com.example.demo.service;

import com.example.demo.entity.ReservationInformation;

import java.util.List;
import java.util.Optional;

public interface ReservationInformationService {

    List<ReservationInformation> getAllReservations();

    Optional<ReservationInformation> getReservationById(Integer id);

    ReservationInformation createReservation(ReservationInformation reservation);

    ReservationInformation updateReservation(Integer id, ReservationInformation updatedReservation);

    void deleteReservation(Integer id);
}
