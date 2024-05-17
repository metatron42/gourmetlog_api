package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "testabelecimento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstablishmentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_estabelecimento")
    private Integer storeEstablishmentId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tendereco_nid_endereco", referencedColumnName = "nid_endereco")
    private AddressInformation storeEstablishmentAddressId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tculinaria_nid_culinaria", referencedColumnName = "nid_culinaria")
    private CookingInformation storeEstablishmentCookingId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tservicos_nid_servicos", referencedColumnName = "nid_servicos")
    private ServiceInformation storeEstablishmentServiceId;

//    @Column(name = "tendereco_nid_endereco")
//    private Integer storeEstablishmentAddressId;
//
//    @Column(name = "tculinaria_nid_culinaria")
//    private Integer storeEstablishmentCookingId;
//
//    @Column(name = "tservicos_nid_servicos")
//    private Integer storeEstablishmentServiceId;

    @Column(name = "ninscr_estabelecimento")
    private String storeEstablishmentSubscribeNumber;

    @Column(name = "nomeemp_estabelecimento")
    private String storeEstablishmentEmp;

    @Column(name = "nomefantasia_estabelecimento")
    private String storeEstablishmentFantasyName;

    @Column(name = "nomeresp_estabelecimento")
    private String storeEstablishmentResp; //Rever

    @Column(name = "email_estabelecimento")
    private String storeEstablishmentEmail;

    @Column(name = "tel_estabelecimento")
    private String storeEstablishmentPhone;

    @Column(name = "nlugares_estabelecimento")
    private String storeEstablishmentSeats;

}
