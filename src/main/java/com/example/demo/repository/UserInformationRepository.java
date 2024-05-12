package com.example.demo.repository;

import com.example.demo.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {

    List<UserInformation> findByStoreUserName(String name);

    List<UserInformation> findByStoreUserLastName(String lastName);

    List<UserInformation> findByStoreUserCPF(String cpf);

    List<UserInformation> findByStoreUserEmail(String email);
}
