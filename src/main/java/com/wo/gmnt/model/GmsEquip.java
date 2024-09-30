package com.wo.gmnt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "gms_equip")
public class GmsEquip {
    @Id
    @Column(name = "id_eqp")
    private String idEqp;

    @Column(name = "codeqp")
    private String codeqp;

    /***/
    @Column(name = "codcla")
    private String codcla;
    /***/
    @Column(name = "codtcl")
    private String codtcl;
    /***/
    @Column(name = "codmar")
    private String codmar;

    @ManyToOne
    @JoinColumn(name = "id_pro")
    private GmsProp gmsProp;

    @ManyToOne
    @JoinColumn(name = "id_are")
    private GmsArea gmsArea;

    @Column(name = "nomeqp")
    private String nomeqp;

    @Column(name = "modeqp")
    private String modeqp;

    @Column(name = "nsreqp")
    private String nsreqp;

    @Column(name = "anofab")
    private String anofab;

    @Column(name = "fchieq")
    private LocalDate fchieq;

    @Column(name = "fching")
    private String fching;

    @Column(name = "esteqp")
    private String esteqp;

    @Column(name = "deseqp")
    private String deseqp;

    @Column(name = "espeqp")
    private String espeqp;

    @Column(name = "codimg")
    private String codimg;

    /***/
    @Column(name = "usrcre")
    private String usrcre;

    @Column(name = "fchcre")
    private String fchcre;

    @Column(name = "hracre")
    private String hracre;

    @Column(name = "usrmod")
    private String usrmod;

    @Column(name = "fchmod")
    private String fchmod;

    @Column(name = "hramod")
    private String hramod;

    @Column(name = "id_cla")
    private String idCla;

    @Column(name = "id_tcl")
    private String idTcl;

    @Column(name = "id_mar")
    private String idMar;
}


