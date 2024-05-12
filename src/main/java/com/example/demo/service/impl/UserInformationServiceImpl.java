package com.example.demo.service.impl;

import com.example.demo.entity.UserInformation;
import com.example.demo.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInformationServiceImpl {

    @Autowired
    private UserInformationRepository userInformationRepository;

    public List<UserInformation> getAllUserInformation() {
        return (List<UserInformation>) userInformationRepository.findAll();
    }

    public Optional<UserInformation> getUserInformationById(Integer id) {
        return userInformationRepository.findById(id);
    }

    public UserInformation createUserInformation(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    public UserInformation updateUserInformation(Integer id, UserInformation updatedUserInformation) {
        UserInformation existingUserInformation = userInformationRepository.findById(id).orElse(null);
        if (existingUserInformation != null) {
            // Update existing user information fields
            existingUserInformation.setStoreUserName(updatedUserInformation.getStoreUserName());
            existingUserInformation.setStoreUserLastName(updatedUserInformation.getStoreUserLastName());
            existingUserInformation.setStoreUserPhoneNumber(updatedUserInformation.getStoreUserPhoneNumber());
            existingUserInformation.setStoreUserEmail(updatedUserInformation.getStoreUserEmail());
            existingUserInformation.setStoreUserPassword(updatedUserInformation.getStoreUserPassword());
            existingUserInformation.setStoreUserCPF(updatedUserInformation.getStoreUserCPF());
            existingUserInformation.setStoreUserBirthDate(updatedUserInformation.getStoreUserBirthDate());
            existingUserInformation.setStoreUserAddress(updatedUserInformation.getStoreUserAddress()); // Update storeUserReserva

            // Save updated user information
            return userInformationRepository.save(existingUserInformation);
        } else {
            return null; // Handle not found
        }
    }

    public void deleteUserInformation(Integer id) {
        userInformationRepository.deleteById(id);
    }
}
