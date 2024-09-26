package com.wo.gmnt.Model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gms_areas")
public class Gmsarea {
    @Id
    @Column(name = "id_are")
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


