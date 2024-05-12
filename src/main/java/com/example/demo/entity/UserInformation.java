package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tusuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_usuario")
    private Integer storeUserId;

    @Column(name = "nome_usuario")
    private String storeUserName;

    @Column(name = "sobren_usuario")
    private String storeUserLastName;

    @Column(name = "cel_usuario")
    private String storeUserPhoneNumber;

    @Column(name = "email_usuario")
    private String storeUserEmail;

    @Column(name = "senha_usuario")
    private String storeUserPassword;

    @Column(name = "cpf_usuario")
    private String storeUserCPF;

    @Temporal(TemporalType.DATE)
    @Column(name = "nasc_usuario")
    private Date storeUserBirthDate;

//    @ManyToOne
//    @JoinColumn(name = "tendereco_nid_endereco", referencedColumnName = "nid_endereco")
//    private AddressInformation storeUserAddress;

    @Column(name = "tendereco_nid_endereco")
    private Integer storeUserAddress;

}
