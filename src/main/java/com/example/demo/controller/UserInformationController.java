package com.example.demo.controller;

import com.example.demo.entity.UserInformation;
import com.example.demo.repository.UserInformationRepository;
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
@RequestMapping("/api/user-information")
@Tag(name = "User Information")
public class UserInformationController {

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Operation(summary = "Retrieve all user information")
    @GetMapping
    public List<UserInformation> getAllUserInformation() {
        return userInformationRepository.findAll();
    }

    @Operation(summary = "Retrieve user information by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user information",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "User information not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserInformation> getUserInformationById(@PathVariable Integer id) {
        return userInformationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new user information")
    @ApiResponse(responseCode = "201", description = "User information created")
    @PostMapping
    public UserInformation createUserInformation(@RequestBody UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    @Operation(summary = "Update existing user information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User information updated successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserInformation.class)) }),
            @ApiResponse(responseCode = "404", description = "User information not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserInformation> updateUserInformation(@PathVariable Integer id, @RequestBody UserInformation updatedUserInformation) {
        return userInformationRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setStoreUserName(updatedUserInformation.getStoreUserName());
                    existingUser.setStoreUserLastName(updatedUserInformation.getStoreUserLastName());
                    existingUser.setStoreUserPhoneNumber(updatedUserInformation.getStoreUserPhoneNumber());
                    existingUser.setStoreUserEmail(updatedUserInformation.getStoreUserEmail());
                    existingUser.setStoreUserPassword(updatedUserInformation.getStoreUserPassword());
                    existingUser.setStoreUserCPF(updatedUserInformation.getStoreUserCPF());
                    existingUser.setStoreUserBirthDate(updatedUserInformation.getStoreUserBirthDate());
                    existingUser.setStoreUserAddress(updatedUserInformation.getStoreUserAddress());
                    return ResponseEntity.ok(userInformationRepository.save(existingUser));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete user information")
    @ApiResponse(responseCode = "204", description = "User information deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserInformation(@PathVariable Integer id) {
        userInformationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}