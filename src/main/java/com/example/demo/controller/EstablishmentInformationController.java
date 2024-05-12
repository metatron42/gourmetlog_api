package com.example.demo.controller;

import com.example.demo.entity.EstablishmentInformation;
import com.example.demo.repository.EstablishmentInformationRepository;
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
@RequestMapping("/api/establishment-information")
@Tag(name = "Establishment Information")
public class EstablishmentInformationController {

    @Autowired
    private EstablishmentInformationRepository establishmentInformationRepository;

    @Operation(summary = "Retrieve all establishment information")
    @GetMapping
    public List<EstablishmentInformation> getAllEstablishmentInformation() {
        return establishmentInformationRepository.findAll();
    }

    @Operation(summary = "Retrieve establishment information by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the establishment information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstablishmentInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Establishment information not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<EstablishmentInformation> getEstablishmentInformationById(@PathVariable Integer id) {
        return establishmentInformationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create establishment information")
    @ApiResponse(responseCode = "201", description = "Establishment information created")
    @PostMapping
    public EstablishmentInformation createEstablishmentInformation(@RequestBody EstablishmentInformation establishmentInformation) {
        return establishmentInformationRepository.save(establishmentInformation);
    }

    @Operation(summary = "Update establishment information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Establishment information updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstablishmentInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Establishment information not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstablishmentInformation> updateEstablishmentInformation(@PathVariable Integer id, @RequestBody EstablishmentInformation updatedEstablishmentInformation) {
        return establishmentInformationRepository.findById(id)
                .map(existingInfo -> {
                    existingInfo.setStoreEstablishmentAddressId(updatedEstablishmentInformation.getStoreEstablishmentAddressId());
                    existingInfo.setStoreEstablishmentCookingId(updatedEstablishmentInformation.getStoreEstablishmentCookingId());
                    existingInfo.setStoreEstablishmentServiceId(updatedEstablishmentInformation.getStoreEstablishmentServiceId());
                    existingInfo.setStoreEstablishmentSubscribeNumber(updatedEstablishmentInformation.getStoreEstablishmentSubscribeNumber());
                    existingInfo.setStoreEstablishmentEmp(updatedEstablishmentInformation.getStoreEstablishmentEmp());
                    existingInfo.setStoreEstablishmentFantasyName(updatedEstablishmentInformation.getStoreEstablishmentFantasyName());
                    existingInfo.setStoreEstablishmentResp(updatedEstablishmentInformation.getStoreEstablishmentResp());
                    existingInfo.setStoreEstablishmentEmail(updatedEstablishmentInformation.getStoreEstablishmentEmail());
                    existingInfo.setStoreEstablishmentPhone(updatedEstablishmentInformation.getStoreEstablishmentPhone());
                    existingInfo.setStoreEstablishmentSeats(updatedEstablishmentInformation.getStoreEstablishmentSeats());
                    return ResponseEntity.ok(establishmentInformationRepository.save(existingInfo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete establishment information")
    @ApiResponse(responseCode = "204", description = "Establishment information deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstablishmentInformation(@PathVariable Integer id) {
        establishmentInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
