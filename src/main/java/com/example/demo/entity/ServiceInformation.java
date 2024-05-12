package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tservico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nid_servicos")
    private Integer storeServicesId;

    @Column(name = "wifi_servicos")
    private Boolean storeWifi;

    @Column(name = "ar_servicos")
    private Boolean storeAr;

    @Column(name = "pet_servicos")
    private Boolean storePet;

    @Column(name = "couvert_servicos")
    private Boolean storeCouvert;

    @Column(name = "estacionamento_servicos")
    private Boolean storeEstacionamento;

    @Column(name = "kids_servicos")
    private Boolean storKids;

    @Column(name = "arlivre_servicos")
    private Boolean storeArLivre;

    @Column(name = "deficiente_servicos")
    private Boolean storeDeficiente;

    @Column(name = "fumante_servicos")
    private Boolean storeFumante;

    @Column(name = "selfservice_servicos")
    private Boolean storeSelfService;

    @Column(name = "rodizio_servicos")
    private Boolean storeRodizio;

}
