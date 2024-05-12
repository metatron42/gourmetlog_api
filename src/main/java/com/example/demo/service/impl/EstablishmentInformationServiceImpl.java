package com.example.demo.service.impl;

import com.example.demo.entity.EstablishmentInformation;
import com.example.demo.repository.EstablishmentInformationRepository;
import com.example.demo.service.EstablishmentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstablishmentInformationServiceImpl implements EstablishmentInformationService {

    @Autowired
    private EstablishmentInformationRepository establishmentInformationRepository;

    @Override
    public List<EstablishmentInformation> getAllEstablishmentInformation() {
        return (List<EstablishmentInformation>) establishmentInformationRepository.findAll();
    }

    @Override
    public Optional<EstablishmentInformation> getEstablishmentInformationById(Integer id) {
        return establishmentInformationRepository.findById(id);
    }

    @Override
    public EstablishmentInformation createEstablishmentInformation(EstablishmentInformation establishmentInformation) {
        return establishmentInformationRepository.save(establishmentInformation);
    }

    @Override
    public EstablishmentInformation updateEstablishmentInformation(Integer id, EstablishmentInformation updatedEstablishmentInformation) {
        EstablishmentInformation existingEstablishmentInformation = establishmentInformationRepository.findById(id).orElse(null);
        if (existingEstablishmentInformation != null) {
            // Update existing establishment information fields
            existingEstablishmentInformation.setStoreEstablishmentAddressId(updatedEstablishmentInformation.getStoreEstablishmentAddressId());
            existingEstablishmentInformation.setStoreEstablishmentCookingId(updatedEstablishmentInformation.getStoreEstablishmentCookingId());
            existingEstablishmentInformation.setStoreEstablishmentServiceId(updatedEstablishmentInformation.getStoreEstablishmentServiceId());
            existingEstablishmentInformation.setStoreEstablishmentSubscribeNumber(updatedEstablishmentInformation.getStoreEstablishmentSubscribeNumber());
            existingEstablishmentInformation.setStoreEstablishmentEmp(updatedEstablishmentInformation.getStoreEstablishmentEmp());
            existingEstablishmentInformation.setStoreEstablishmentFantasyName(updatedEstablishmentInformation.getStoreEstablishmentFantasyName());
            existingEstablishmentInformation.setStoreEstablishmentResp(updatedEstablishmentInformation.getStoreEstablishmentResp());
            existingEstablishmentInformation.setStoreEstablishmentEmail(updatedEstablishmentInformation.getStoreEstablishmentEmail());
            existingEstablishmentInformation.setStoreEstablishmentPhone(updatedEstablishmentInformation.getStoreEstablishmentPhone());
            existingEstablishmentInformation.setStoreEstablishmentSeats(updatedEstablishmentInformation.getStoreEstablishmentSeats());

            // Save updated establishment information
            return establishmentInformationRepository.save(existingEstablishmentInformation);
        } else {
            return null; // Handle not found
        }
    }

    @Override
    public void deleteEstablishmentInformation(Integer id) {
        establishmentInformationRepository.deleteById(id);
    }
}
