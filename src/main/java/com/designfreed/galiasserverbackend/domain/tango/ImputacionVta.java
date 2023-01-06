package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GVA07")
public class ImputacionVta implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA07")
    private Long id;

    @Column(name = "N_COMP_CAN")
    private String numCompCan;

    @Column(name = "N_COMP")
    private String numCompFac;

    @Column(name = "T_COMP_CAN")
    private String tipoCompCan;

    @Column(name = "T_COMP")
    private String tipoCompFac;

    public ImputacionVta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCompCan() {
        return numCompCan;
    }

    public void setNumCompCan(String numCompCan) {
        this.numCompCan = numCompCan;
    }

    public String getNumCompFac() {
        return numCompFac;
    }

    public void setNumCompFac(String numCompFac) {
        this.numCompFac = numCompFac;
    }

    public String getTipoCompCan() {
        return tipoCompCan;
    }

    public void setTipoCompCan(String tipoCompCan) {
        this.tipoCompCan = tipoCompCan;
    }

    public String getTipoCompFac() {
        return tipoCompFac;
    }

    public void setTipoCompFac(String tipoCompFac) {
        this.tipoCompFac = tipoCompFac;
    }
}
