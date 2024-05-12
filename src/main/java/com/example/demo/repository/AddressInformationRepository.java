package com.example.demo.repository;

import com.example.demo.entity.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressInformationRepository extends JpaRepository<AddressInformation, Integer> {

    List<AddressInformation> findByStoreAddressRoad(String name);

    List<AddressInformation> findByStoreAddressCEP(String cep);

    List<AddressInformation> findAll();
}
