package com.example.demo.repository;

import com.example.demo.entity.CookingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CookingInformationRepository extends JpaRepository<CookingInformation, Integer> {

    List<CookingInformation> findAll();
}
