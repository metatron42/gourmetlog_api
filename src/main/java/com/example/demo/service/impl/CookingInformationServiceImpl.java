package com.example.demo.service.impl;

import com.example.demo.entity.CookingInformation;
import com.example.demo.repository.CookingInformationRepository;
import com.example.demo.service.CookingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookingInformationServiceImpl implements CookingInformationService {

    @Autowired
    private CookingInformationRepository cookingInformationRepository;

    @Override
    public List<CookingInformation> getAllCookingInformation() {
        return (List<CookingInformation>) cookingInformationRepository.findAll();
    }

    @Override
    public Optional<CookingInformation> getCookingInformationById(Integer id) {
        return cookingInformationRepository.findById(id);
    }

    @Override
    public CookingInformation createCookingInformation(CookingInformation cookingInformation) {
        return cookingInformationRepository.save(cookingInformation);
    }

    @Override
    public CookingInformation updateCookingInformation(Integer id, CookingInformation updatedCookingInformation) {
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

            // Save updated cooking information
            return cookingInformationRepository.save(existingCookingInformation);
        } else {
            return null; // Handle not found
        }
    }

    @Override
    public void deleteCookingInformation(Integer id) {
        cookingInformationRepository.deleteById(id);
    }
}
