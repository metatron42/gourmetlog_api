package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tendereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nid_endereco")
    private Integer storeAddressId;

    @Column(name = "rua_endereco")
    private String storeAddressRoad;

    @Column(name = "num_endereco")
    private String storeAddressNumber;

    @Column(name = "bairro_endereco")
    private String storeAddressNeighborhood;

    @Column(name = "municipio_endereco")
    private String storeAddressCounty;

    @Column(name = "cep_endereco")
    private String storeAddressCEP;

    @Column(name = "tipousuario_endereco")
    private Boolean storeAddressTypeUser;

}
