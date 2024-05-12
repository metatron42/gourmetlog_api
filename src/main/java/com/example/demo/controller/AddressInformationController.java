package com.example.demo.controller;

import com.example.demo.entity.AddressInformation;
import com.example.demo.repository.AddressInformationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store-addresses")
@Tag(name = "Address Information")
public class AddressInformationController {

    @Autowired
    private AddressInformationRepository addressInformationRepository;

    @Operation(summary = "Get all store addresses")
    @GetMapping
    public List<AddressInformation> getAllStoreAddresses() {
        return addressInformationRepository.findAll();
    }

    @Operation(summary = "Get a store address by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the address",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public Optional<AddressInformation> getStoreAddressById(@PathVariable Integer id) {
        return addressInformationRepository.findById(id);
    }

    @Operation(summary = "Create a new store address")
    @ApiResponse(responseCode = "201", description = "Address created")
    @PostMapping
    public AddressInformation createStoreAddress(@RequestBody AddressInformation addressInformation) {
        return addressInformationRepository.save(addressInformation);
    }

    @Operation(summary = "Update an existing store address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Address not found")
    })
    @PutMapping("/{id}")
    public AddressInformation updateStoreAddress(@PathVariable Integer id, @RequestBody AddressInformation updatedAddress) {
        AddressInformation existingAddress = addressInformationRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setStoreAddressRoad(updatedAddress.getStoreAddressRoad());
            existingAddress.setStoreAddressNumber(updatedAddress.getStoreAddressNumber());
            existingAddress.setStoreAddressNeighborhood(updatedAddress.getStoreAddressNeighborhood());
            existingAddress.setStoreAddressCounty(updatedAddress.getStoreAddressCounty());
            existingAddress.setStoreAddressCEP(updatedAddress.getStoreAddressCEP());
            existingAddress.setStoreAddressTypeUser(updatedAddress.getStoreAddressTypeUser());
            return addressInformationRepository.save(existingAddress);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
    }

    @Operation(summary = "Delete a store address")
    @ApiResponse(responseCode = "204", description = "Address deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreAddress(@PathVariable Integer id) {
        addressInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
