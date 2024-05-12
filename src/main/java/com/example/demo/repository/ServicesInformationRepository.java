package com.example.demo.repository;

import com.example.demo.entity.ServiceInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesInformationRepository extends JpaRepository<ServiceInformation, Integer> {

}
