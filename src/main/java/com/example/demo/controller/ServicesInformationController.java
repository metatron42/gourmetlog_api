package com.example.demo.controller;

import com.example.demo.entity.ServiceInformation;
import com.example.demo.repository.ServicesInformationRepository;
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
@RequestMapping("/api/services-information")
@Tag(name = "Services Information")
public class ServicesInformationController {

    @Autowired
    private ServicesInformationRepository servicesInformationRepository;

    @Operation(summary = "Retrieve all service information")
    @GetMapping
    public List<ServiceInformation> getAllServicesInformation() {
        return servicesInformationRepository.findAll();
    }

    @Operation(summary = "Retrieve service information by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the service information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Service information not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ServiceInformation> getServicesInformationById(@PathVariable Integer id) {
        return servicesInformationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new service information")
    @ApiResponse(responseCode = "201", description = "Service information created")
    @PostMapping
    public ServiceInformation createServicesInformation(@RequestBody ServiceInformation servicesInformation) {
        return servicesInformationRepository.save(servicesInformation);
    }

    @Operation(summary = "Update existing service information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Service information updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Service information not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ServiceInformation> updateServicesInformation(@PathVariable Integer id, @RequestBody ServiceInformation updatedServicesInformation) {
        return servicesInformationRepository.findById(id)
                .map(existingServices -> {
                    existingServices.setStoreWifi(updatedServicesInformation.getStoreWifi());
                    existingServices.setStoreAr(updatedServicesInformation.getStoreAr());
                    existingServices.setStorePet(updatedServicesInformation.getStorePet());
                    existingServices.setStoreCouvert(updatedServicesInformation.getStoreCouvert());
                    existingServices.setStoreEstacionamento(updatedServicesInformation.getStoreEstacionamento());
                    existingServices.setStorKids(updatedServicesInformation.getStorKids());
                    existingServices.setStoreArLivre(updatedServicesInformation.getStoreArLivre());
                    existingServices.setStoreDeficiente(updatedServicesInformation.getStoreDeficiente());
                    existingServices.setStoreFumante(updatedServicesInformation.getStoreFumante());
                    existingServices.setStoreSelfService(updatedServicesInformation.getStoreSelfService());
                    existingServices.setStoreRodizio(updatedServicesInformation.getStoreRodizio());
                    return ResponseEntity.ok(servicesInformationRepository.save(existingServices));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete service information")
    @ApiResponse(responseCode = "204", description = "Service information deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicesInformation(@PathVariable Integer id) {
        servicesInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
