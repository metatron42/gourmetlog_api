package com.example.demo;

import com.example.demo.repository.UserInformationRepository;
import com.example.demo.repository.AddressInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	UserInformationRepository userInformationRepository;

	@Autowired
	AddressInformationRepository addressInformationRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws ParseException {
//		AddressInformation addressBruna = new AddressInformation("Rua Teste", "113", "Bairro Teste", "Municipio Teste", "000000", true);
//		AddressInformation addressToUse = addressInformationRepository.save(addressBruna);
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date birthDate = sdf.parse("23/03/1999");
//
//		UserInformation bruna = new UserInformation("Bruna", "Antunes", "xxxxxxx", "antunes.bruna@hotmail.com", "teste12345", "12345678912", birthDate, addressToUse);
//		userInformationRepository.save(bruna);

//		userInformationRepository.findByStoreUserName("Bruna").forEach(
//				val -> System.out.println(val)
//		);
//
//		userInformationRepository.findByStoreLastName("Antunes").forEach(
//				val -> System.out.println(val)
//		);
//
//		userInformationRepository.findByStorePhoneNumber("xxxxxxx").forEach(
//				val -> System.out.println(val)
//		);
//
//		System.out.println(userInformationRepository.count());
//
//		userInformationRepository.findById(2).ifPresent(
//				val -> System.out.println(val)
//		);
//
//		userInformationRepository.deleteById(2);
//	}
}