package com.example.demo.controller;

import com.example.demo.entity.ReservationInformation;
import com.example.demo.repository.ReservationInformationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation-information")
@Tag(name = "Reservation Information")
public class ReservationInformationController {

    @Autowired
    private ReservationInformationRepository reservationInformationRepository;

    @Operation(summary = "Retrieve all reservation information")
    @GetMapping
    public List<ReservationInformation> getAllReservationInformation() {
        return reservationInformationRepository.findAll();
    }

    @Operation(summary = "Retrieve reservation information by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the reservation information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReservationInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Reservation information not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReservationInformation> getReservationInformationById(@PathVariable Integer id) {
        return reservationInformationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new reservation information")
    @ApiResponse(responseCode = "201", description = "Reservation information created")
    @PostMapping
    public ReservationInformation createReservationInformation(@RequestBody ReservationInformation reservationInformation) {
        return reservationInformationRepository.save(reservationInformation);
    }

    @Operation(summary = "Update reservation information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation information updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReservationInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Reservation information not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ReservationInformation> updateReservationInformation(@PathVariable Integer id, @RequestBody ReservationInformation updatedReservationInformation) {
        return reservationInformationRepository.findById(id)
                .map(existingInfo -> {
                    existingInfo.setStoreReservationUserId(updatedReservationInformation.getStoreReservationUserId());
                    existingInfo.setStoreReservationEstablishmentId(updatedReservationInformation.getStoreReservationEstablishmentId());
                    existingInfo.setStoreReservationCountPeople(updatedReservationInformation.getStoreReservationCountPeople());
                    existingInfo.setStoreReservationTime(updatedReservationInformation.getStoreReservationTime());
                    existingInfo.setStoreReservationName(updatedReservationInformation.getStoreReservationName());
                    existingInfo.setStoreReservationDate(updatedReservationInformation.getStoreReservationDate());
                    existingInfo.setStoreReservationRating(updatedReservationInformation.getStoreReservationRating());
                    existingInfo.setStoreReservationObs(updatedReservationInformation.getStoreReservationObs());
                    existingInfo.setStoreReservationConfirm(updatedReservationInformation.getStoreReservationConfirm());
                    existingInfo.setStoreReservationEnd(updatedReservationInformation.getStoreReservationEnd());
                    return ResponseEntity.ok(reservationInformationRepository.save(existingInfo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete reservation information")
    @ApiResponse(responseCode = "204", description = "Reservation information deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationInformation(@PathVariable Integer id) {
        reservationInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
