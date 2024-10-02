package com.wo.gmnt.model;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "gms_areas")
public class GmsArea {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idAre;

    @Column(name = "codare")
    private String codare;

    @Column(name = "desare")
    private String desare;

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


