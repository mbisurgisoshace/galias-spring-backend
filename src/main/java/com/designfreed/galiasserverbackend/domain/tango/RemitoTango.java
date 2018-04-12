package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STA14")
public class RemitoTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_STA14")
    private Long id;

    @Column(name = "COD_PRO_CL")
    private String cliente;

    @Column(name = "ESTADO_MOV")
    private String estado;

    @Column(name = "FECHA_MOV")
    private Date fecha;

    @Column(name = "MON_CTE")
    private Boolean monedaCte;

    @Column(name = "N_COMP")
    private String comprobante;

    @Column(name = "N_REMITO")
    private String remito;

    @Column(name = "NCOMP_IN_S")
    private String interno;

    @Column(name = "NRO_SUCURS")
    private Integer sucursal;

    @Column(name = "T_COMP")
    private String tipo;

    @Column(name = "TALONARIO")
    private Integer talonario;

    @Column(name = "TCOMP_IN_S")
    private String tipoTango;

    @Column(name = "COD_TRANSP")
    private String transporte;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "NCOMP_IN_S", referencedColumnName = "NCOMP_IN_S", nullable = false)
//    private List<RemitoItemTango> items = new ArrayList<>();

    public RemitoTango() {
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

    public Boolean getMonedaCte() {
        return monedaCte;
    }

    public void setMonedaCte(Boolean monedaCte) {
        this.monedaCte = monedaCte;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getRemito() {
        return remito;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTalonario() {
        return talonario;
    }

    public void setTalonario(Integer talonario) {
        this.talonario = talonario;
    }

    public String getTipoTango() {
        return tipoTango;
    }

    public void setTipoTango(String tipoTango) {
        this.tipoTango = tipoTango;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

//    public List<RemitoItemTango> getItems() {
//        return items;
//    }
//
//    public void setItems(List<RemitoItemTango> items) {
//        this.items = items;
//    }
}
