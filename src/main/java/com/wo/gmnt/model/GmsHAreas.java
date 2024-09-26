package com.wo.gmnt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gms_hareas")
public class GmsHAreas {
    @Id
    @Column(name = "id_har")
    private String idHar;

    @ManyToOne
    @JoinColumn(name = "id_eqp")
    private GmsEquip gmsEquip;

    @ManyToOne
    @JoinColumn(name = "id_are")
    private GmsArea gmsArea;

    @Column(name = "codeqp")
    private String codeqp;

    @Column(name = "codare")
    private String codare;

    @Column(name = "numitm")
    private String numitm;

    @Column(name = "fch_in")
    private java.sql.Date fchIn;

    @Column(name = "fch_fi")
    private java.sql.Date fchFi;

    @Column(name = "fchini")
    private String fchini;

    @Column(name = "fchfin")
    private String fchfin;

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
