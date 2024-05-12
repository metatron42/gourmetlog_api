package com.example.demo.service.impl;

import com.example.demo.entity.AddressInformation;
import com.example.demo.repository.AddressInformationRepository;
import com.example.demo.service.AddressInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressInformationServiceImpl implements AddressInformationService {

    @Autowired
    private AddressInformationRepository addressInformationRepository;

    @Override
    public List<AddressInformation> getAllAddressInformation() {
        return (List<AddressInformation>) addressInformationRepository.findAll();
    }

    @Override
    public Optional<AddressInformation> getAddressInformationById(Integer id) {
        return addressInformationRepository.findById(id);
    }

    @Override
    public AddressInformation createAddressInformation(AddressInformation addressInformation) {
        return addressInformationRepository.save(addressInformation);
    }

    @Override
    public AddressInformation updateAddressInformation(Integer id, AddressInformation updatedAddressInformation) {
        AddressInformation existingAddressInformation = addressInformationRepository.findById(id).orElse(null);
        if (existingAddressInformation != null) {

            existingAddressInformation.setStoreAddressRoad(updatedAddressInformation.getStoreAddressRoad());
            existingAddressInformation.setStoreAddressNumber(updatedAddressInformation.getStoreAddressNumber());
            existingAddressInformation.setStoreAddressNeighborhood(updatedAddressInformation.getStoreAddressNeighborhood());
            existingAddressInformation.setStoreAddressCounty(updatedAddressInformation.getStoreAddressCounty());
            existingAddressInformation.setStoreAddressCEP(updatedAddressInformation.getStoreAddressCEP());
            existingAddressInformation.setStoreAddressTypeUser(updatedAddressInformation.getStoreAddressTypeUser());

            return addressInformationRepository.save(existingAddressInformation);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAddressInformation(Integer id) {
        addressInformationRepository.deleteById(id);
    }
}
