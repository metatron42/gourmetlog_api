package com.example.demo.service;

import com.example.demo.entity.ServiceInformation;

import java.util.List;
import java.util.Optional;

public interface ServicesInformationService {

    List<ServiceInformation> getAllServicesInformation();

    Optional<ServiceInformation> getServicesInformationById(Integer id);

    ServiceInformation createServicesInformation(ServiceInformation servicesInformation);

    ServiceInformation updateServicesInformation(Integer id, ServiceInformation updatedServicesInformation);

    void deleteServicesInformation(Integer id);
}
