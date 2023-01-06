package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GVA12")
public class FacturaVtaTango {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA12")
    private Long id;

    @Column(name = "COD_CLIENT")
    private String cliente;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_EMIS")
    private Date fecha;

    @Column(name = "IMPORTE")
    private Float importe;

    @Column(name = "N_COMP")
    private String comprobante;

    @Column(name = "T_COMP")
    private String tipoComp;

    public FacturaVtaTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
