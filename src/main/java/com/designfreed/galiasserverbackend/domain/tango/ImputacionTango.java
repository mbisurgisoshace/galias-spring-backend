package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;

@Entity
@Table(name = "GVA07")
public class ImputacionTango {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA07")
    private Long id;

    @Column(name = "IMPORT_CAN")
    private Float importe;

    @Column(name = "N_COMP")
    private String comprobante;

    @Column(name = "T_COMP")
    private String tipoComp;

    public ImputacionTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getTipoComp() {
        return tipoComp;
    }

    public void setTipoComp(String tipoComp) {
        this.tipoComp = tipoComp;
    }
}
