package com.example.demo.controller;

import com.example.demo.entity.CookingInformation;
import com.example.demo.repository.CookingInformationRepository;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cooking-information")
@Tag(name = "Cooking Information")
public class CookingInformationController {

    @Autowired
    private CookingInformationRepository cookingInformationRepository;

    @Operation(summary = "Get all cooking information entries")
    @GetMapping
    public List<CookingInformation> getAllCookingInformation() {
        return cookingInformationRepository.findAll();
    }

    @Operation(summary = "Get cooking information by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the cooking information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CookingInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Cooking information not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public Optional<CookingInformation> getCookingInformationById(@PathVariable Integer id) {
        return cookingInformationRepository.findById(id);
    }

    @Operation(summary = "Create new cooking information")
    @ApiResponse(responseCode = "201", description = "Cooking information created")
    @PostMapping
    public CookingInformation createCookingInformation(@RequestBody CookingInformation cookingInformation) {
        return cookingInformationRepository.save(cookingInformation);
    }

    @Operation(summary = "Update an existing cooking information entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cooking information updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CookingInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "Cooking information not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CookingInformation> updateCookingInformation(@PathVariable Integer id, @RequestBody CookingInformation updatedCookingInformation) {
        CookingInformation existingCookingInformation = cookingInformationRepository.findById(id).orElse(null);
        if (existingCookingInformation != null) {
            // Update existing cooking information fields
            existingCookingInformation.setStoreItaliana(updatedCookingInformation.getStoreItaliana());
            existingCookingInformation.setStoreJaponesa(updatedCookingInformation.getStoreJaponesa());
            existingCookingInformation.setStoreNordestina(updatedCookingInformation.getStoreNordestina());
            existingCookingInformation.setStoreMexicana(updatedCookingInformation.getStoreMexicana());
            existingCookingInformation.setStorePizzaria(updatedCookingInformation.getStorePizzaria());
            existingCookingInformation.setStoreMineira(updatedCookingInformation.getStoreMineira());
            existingCookingInformation.setStoreChinesa(updatedCookingInformation.getStoreChinesa());
            existingCookingInformation.setStoreArabe(updatedCookingInformation.getStoreArabe());
            existingCookingInformation.setStoreGrega(updatedCookingInformation.getStoreGrega());
            existingCookingInformation.setStoreFrancesa(updatedCookingInformation.getStoreFrancesa());
            existingCookingInformation.setStoreCoreana(updatedCookingInformation.getStoreCoreana());
            return ResponseEntity.ok(cookingInformationRepository.save(existingCookingInformation));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Delete cooking information")
    @ApiResponse(responseCode = "204", description = "Cooking information deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCookingInformation(@PathVariable Integer id) {
        cookingInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
