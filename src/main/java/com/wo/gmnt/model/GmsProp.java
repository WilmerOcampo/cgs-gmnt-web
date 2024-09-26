package com.wo.gmnt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gms_prop")
public class GmsProp {
    @Id
    @Column(name = "id_pro")
    private String idPro;

    @Column(name = "codpro")
    private String codpro;

    @Column(name = "tpepro")
    private String tpepro;

    @Column(name = "tdipro")
    private String tdipro;

    @Column(name = "nrodid")
    private String nrodid;

    @Column(name = "apppro")
    private String apppro;

    @Column(name = "apmpro")
    private String apmpro;

    @Column(name = "nompro")
    private String nompro;

    @Column(name = "sigpro")
    private String sigpro;

    @Column(name = "codubg")
    private String codubg;

    @Column(name = "dirpro")
    private String dirpro;

    @Column(name = "telpro")
    private String telpro;

    @Column(name = "celpro")
    private String celpro;

    @Column(name = "em_pro")
    private String emPro;

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

    @Column(name = "id_tpe")
    private String idTpe;

    @Column(name = "id_tdi")
    private String idTdi;
}

