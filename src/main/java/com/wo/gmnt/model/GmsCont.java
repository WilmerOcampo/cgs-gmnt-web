package com.wo.gmnt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gms_cont")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GmsCont {
    @Id
    @Column(name = "id_con")
    private String idCont;

    @Column(name = "ubicon", length = 10)
    private String ubiCon;

    @Column(name = "nomcon")
    private String nomCon;
}
