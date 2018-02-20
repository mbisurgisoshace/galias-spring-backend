package com.designfreed.galiasserverbackend.domain.crm;

public class Cliente {
    private String codigo;
    private String razonSocial;
    private String cuit;
    private String iva;
    private String nombreComercial;
    private Direccion direccion;
    private Integer condicionPago;

    public Cliente() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(Integer condicionPago) {
        this.condicionPago = condicionPago;
    }
}
