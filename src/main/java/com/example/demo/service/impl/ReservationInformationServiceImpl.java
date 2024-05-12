package com.example.demo.service.impl;

import com.example.demo.entity.ReservationInformation;
import com.example.demo.repository.ReservationInformationRepository;
import com.example.demo.service.ReservationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationInformationServiceImpl implements ReservationInformationService {

    @Autowired
    private ReservationInformationRepository reservationRepository;

    @Override
    public List<ReservationInformation> getAllReservations() {
        return (List<ReservationInformation>) reservationRepository.findAll();
    }

    @Override
    public Optional<ReservationInformation> getReservationById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public ReservationInformation createReservation(ReservationInformation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public ReservationInformation updateReservation(Integer id, ReservationInformation updatedReservation) {
        ReservationInformation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            // Update existing reservation fields
            existingReservation.setStoreReservationUserId(updatedReservation.getStoreReservationUserId());
            existingReservation.setStoreReservationEstablishmentId(updatedReservation.getStoreReservationEstablishmentId());
            existingReservation.setStoreReservationCountPeople(updatedReservation.getStoreReservationCountPeople());
            existingReservation.setStoreReservationTime(updatedReservation.getStoreReservationTime());
            existingReservation.setStoreReservationName(updatedReservation.getStoreReservationName());
            existingReservation.setStoreReservationDate(updatedReservation.getStoreReservationDate());
            existingReservation.setStoreReservationRating(updatedReservation.getStoreReservationRating());
            existingReservation.setStoreReservationObs(updatedReservation.getStoreReservationObs());
            existingReservation.setStoreReservationConfirm(updatedReservation.getStoreReservationConfirm());
            existingReservation.setStoreReservationEnd(updatedReservation.getStoreReservationEnd());

            // Save updated reservation
            return reservationRepository.save(existingReservation);
        } else {
            return null; // Handle not found
        }
    }

    @Override
    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }
}
