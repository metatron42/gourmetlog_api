package com.example.demo.service.impl;

import com.example.demo.entity.ServiceInformation;
import com.example.demo.repository.ServicesInformationRepository;
import com.example.demo.service.ServicesInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesInformationServiceImpl implements ServicesInformationService {

    @Autowired
    private ServicesInformationRepository servicesInformationRepository;

    @Override
    public List<ServiceInformation> getAllServicesInformation() {
        return (List<ServiceInformation>) servicesInformationRepository.findAll();
    }

    @Override
    public Optional<ServiceInformation> getServicesInformationById(Integer id) {
        return servicesInformationRepository.findById(id);
    }

    @Override
    public ServiceInformation createServicesInformation(ServiceInformation servicesInformation) {
        return servicesInformationRepository.save(servicesInformation);
    }

    @Override
    public ServiceInformation updateServicesInformation(Integer id, ServiceInformation updatedServicesInformation) {
        ServiceInformation existingServicesInformation = servicesInformationRepository.findById(id).orElse(null);
        if (existingServicesInformation != null) {
            // Update existing services information fields
            existingServicesInformation.setStoreWifi(updatedServicesInformation.getStoreWifi());
            existingServicesInformation.setStoreAr(updatedServicesInformation.getStoreAr());
            existingServicesInformation.setStorePet(updatedServicesInformation.getStorePet());
            existingServicesInformation.setStoreCouvert(updatedServicesInformation.getStoreCouvert());
            existingServicesInformation.setStoreEstacionamento(updatedServicesInformation.getStoreEstacionamento());
            existingServicesInformation.setStorKids(updatedServicesInformation.getStorKids());
            existingServicesInformation.setStoreArLivre(updatedServicesInformation.getStoreArLivre());
            existingServicesInformation.setStoreDeficiente(updatedServicesInformation.getStoreDeficiente());
            existingServicesInformation.setStoreFumante(updatedServicesInformation.getStoreFumante());
            existingServicesInformation.setStoreSelfService(updatedServicesInformation.getStoreSelfService());
            existingServicesInformation.setStoreRodizio(updatedServicesInformation.getStoreRodizio());

            // Save updated services information
            return servicesInformationRepository.save(existingServicesInformation);
        } else {
            return null; // Handle not found
        }
    }

    @Override
    public void deleteServicesInformation(Integer id) {
        servicesInformationRepository.deleteById(id);
    }
}
