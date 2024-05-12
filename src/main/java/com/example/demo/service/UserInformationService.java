package com.example.demo.service;

import com.example.demo.entity.UserInformation;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    List<UserInformation> getAllUserInformation();

    Optional<UserInformation> getUserInformationById(Integer id);

    UserInformation createUserInformation(UserInformation userInformation);

    UserInformation updateUserInformation(Integer id, UserInformation updatedUserInformation);

    void deleteUserInformation(Integer id);

    // Additional method for updating storeUserReserva
    UserInformation updateStoreUserReserva(Integer id, UserInformation updatedUserInformation);
}
