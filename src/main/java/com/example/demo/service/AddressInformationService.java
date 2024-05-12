package com.example.demo.service;

import com.example.demo.entity.AddressInformation;

import java.util.List;
import java.util.Optional;

public interface AddressInformationService {

    List<AddressInformation> getAllAddressInformation();

    Optional<AddressInformation> getAddressInformationById(Integer id);

    AddressInformation createAddressInformation(AddressInformation addressInformation);

    AddressInformation updateAddressInformation(Integer id, AddressInformation updatedAddressInformation);

    void deleteAddressInformation(Integer id);
}
