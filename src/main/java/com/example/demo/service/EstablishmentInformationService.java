package com.example.demo.service;

import com.example.demo.entity.EstablishmentInformation;

import java.util.List;
import java.util.Optional;

public interface EstablishmentInformationService {

    List<EstablishmentInformation> getAllEstablishmentInformation();

    Optional<EstablishmentInformation> getEstablishmentInformationById(Integer id);

    EstablishmentInformation createEstablishmentInformation(EstablishmentInformation establishmentInformation);

    EstablishmentInformation updateEstablishmentInformation(Integer id, EstablishmentInformation updatedEstablishmentInformation);

    void deleteEstablishmentInformation(Integer id);
}
