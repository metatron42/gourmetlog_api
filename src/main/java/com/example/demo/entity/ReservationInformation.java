package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "treserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ReservationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_reserva")
    private Integer storeReservationId;


    @ManyToOne
    @JoinColumn(name = "tusuario_nid_usuario", referencedColumnName = "nid_usuario")
    private UserInformation storeReservationUserId;

    @ManyToOne
    @JoinColumn(name = "testabelecimento_nid_estabelecimento", referencedColumnName = "nid_estabelecimento")
    private EstablishmentInformation storeReservationEstablishmentId;


//    @Column(name = "tusuario_nid_usuario")
//    private Integer storeReservationUserId;
//
//    @Column(name = "testabelecimento_nid_estabelecimento")
//    private Integer storeReservationEstablishmentId;

    @Column(name = "numpessoas_reserva")
    private String storeReservationCountPeople;

    @Column(name = "horario_reserva")
    private String storeReservationTime;

    @Column(name = "nome_reserva")
    private String storeReservationName;

    @Column(name = "data_reserva")
    private String storeReservationDate;

    @Column(name = "avaliacao_reserva")
    private String storeReservationRating;

    @Column(name = "obs_reserva")
    private String storeReservationObs;

    @Column(name = "confirmacao_reserva")
    private String storeReservationConfirm;

    @Column(name = "fim_reserva")
    private String storeReservationEnd;


}
