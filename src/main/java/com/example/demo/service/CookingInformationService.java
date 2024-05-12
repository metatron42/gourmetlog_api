package com.example.demo.service;

import com.example.demo.entity.CookingInformation;

import java.util.List;
import java.util.Optional;

public interface CookingInformationService {

    List<CookingInformation> getAllCookingInformation();

    Optional<CookingInformation> getCookingInformationById(Integer id);

    CookingInformation createCookingInformation(CookingInformation cookingInformation);

    CookingInformation updateCookingInformation(Integer id, CookingInformation updatedCookingInformation);

    void deleteCookingInformation(Integer id);
}
