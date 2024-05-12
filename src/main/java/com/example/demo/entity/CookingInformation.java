package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tculinaria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CookingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nid_culinaria")
    private Integer storeCookingId;

    @Column(name = "italiana")
    private Boolean storeItaliana;

    @Column(name = "japonesa")
    private Boolean storeJaponesa;

    @Column(name = "nordestina")
    private Boolean storeNordestina;

    @Column(name = "mexicana")
    private Boolean storeMexicana;

    @Column(name = "pizzaria")
    private Boolean storePizzaria;

    @Column(name = "mineira")
    private Boolean storeMineira;

    @Column(name = "chinesa")
    private Boolean storeChinesa;

    @Column(name = "arabe")
    private Boolean storeArabe;

    @Column(name = "grega")
    private Boolean storeGrega;

    @Column(name = "francesa")
    private Boolean storeFrancesa;

    @Column(name = "coreana")
    private Boolean storeCoreana;

}
