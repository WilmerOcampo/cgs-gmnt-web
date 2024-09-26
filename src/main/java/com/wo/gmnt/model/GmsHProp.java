package com.wo.gmnt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gms_hprop")
public class GmsHProp {
    @Id
    @Column(name = "id_hpr")
    private String idHpr;

    @ManyToOne
    @JoinColumn(name = "id_eqp")
    private GmsEquip gmsEquip;

    @Column(name = "codeqp")
    private String codeqp;

    @ManyToOne
    @JoinColumn(name = "id_pro")
    private com.wo.gmnt.Model.GmsProp gmsProp;

    @Column(name = "numitm")
    private String numitm;

    @Column(name = "fchhis")
    private java.sql.Date fchhis;

    @Column(name = "fchmov")
    private String fchmov;

    @Column(name = "id_con")
    private String idCon;

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
}
