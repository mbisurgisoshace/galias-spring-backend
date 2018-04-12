package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STA20")
public class RemitoItemTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_STA20")
    private Long id;

    @Column(name = "CAN_EQUI_V")
    private Float cantidadEquivalenteVentas;

    @Column(name = "CANT_PEND")
    private Float cantidadPendiente;

    @Column(name = "CANTIDAD")
    private Float cantidad;

    @Column(name = "COD_ARTICU")
    private String articulo;

    @Column(name = "COD_DEPOSI")
    private String deposito;

    @Column(name = "EQUIVALENC")
    private Float equivalencia;

    @Column(name = "FECHA_MOV")
    private Date fecha;

    @Column(name = "N_RENGL_S")
    private Integer renglon;

    @Column(name = "NCOMP_IN_S")
    private String interno;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "PRECIO_REM")
    private Float precioRemito;

    @Column(name = "TCOMP_IN_S")
    private String tipoComp;

    @Column(name = "TIPO_MOV")
    private String tipoMov;

    public RemitoItemTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCantidadEquivalenteVentas() {
        return cantidadEquivalenteVentas;
    }

    public void setCantidadEquivalenteVentas(Float cantidadEquivalenteVentas) {
        this.cantidadEquivalenteVentas = cantidadEquivalenteVentas;
    }

    public Float getCantidadPendiente() {
        return cantidadPendiente;
    }

    public void setCantidadPendiente(Float cantidadPendiente) {
        this.cantidadPendiente = cantidadPendiente;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public Float getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Float equivalencia) {
        this.equivalencia = equivalencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecioRemito() {
        return precioRemito;
    }

    public void setPrecioRemito(Float precioRemito) {
        this.precioRemito = precioRemito;
    }

    public String getTipoComp() {
        return tipoComp;
    }

    public void setTipoComp(String tipoComp) {
        this.tipoComp = tipoComp;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }
}
