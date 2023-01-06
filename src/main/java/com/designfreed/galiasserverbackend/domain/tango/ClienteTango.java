package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GVA14")
public class ClienteTango implements Serializable {
    @TableGenerator(name = "cliente-gen", table = "PROVIDERID", pkColumnName = "ID_PROVIDERID", valueColumnName = "ULTIMOID", pkColumnValue = "10", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cliente-gen")
    @Column(name = "ID_GVA14")
    private Long id;

    @Column(name = "COD_CLIENT")
    private String codigo;

    @Column(name = "COD_PROVIN")
    private String provincia;

    @Column(name = "COD_ZONA")
    private String zona;

    @Column(name = "COND_VTA")
    private Integer condicionVenta;

    @Column(name = "CUIT")
    private String cuit;

    @Column(name = "DIR_COM")
    private String direccionComercial;

    @Column(name = "DOMICILIO")
    private String direccion;

    @Column(name = "FECHA_ALTA")
    private Date fechaAlta;

    @Column(name = "II_D")
    private String internosD;

    @Column(name = "II_L")
    private String internosL;

    @Column(name = "IVA_D")
    private String ivaD;

    @Column(name = "IVA_L")
    private String ivaL;

    @Column(name = "NOM_COM")
    private String nombreComercial;

    @Column(name = "RAZON_SOCI")
    private String razonSocial;

    @Column(name = "SOBRE_II")
    private String sobreIi;

    @Column(name = "SOBRE_IVA")
    private String sobreIva;

    @Column(name = "TELEFONO_1")
    private String telefono;

    @Column(name = "TIPO_DOC")
    private Integer tipoDocumento;

    @Column(name = "COD_GVA14")
    private String codigoTabla14;

    @Column(name = "ID_CATEGORIA_IVA")
    private Integer condicionIva;

    @Column(name = "COD_GVA18")
    private String codigoTabla18;

    @Column(name = "COD_GVA05")
    private String codigoTabla05;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "COD_GVA23")
    private String vendedor;

    public ClienteTango() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Integer getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(Integer condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccionComercial() {
        return direccionComercial;
    }

    public void setDireccionComercial(String direccionComercial) {
        this.direccionComercial = direccionComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getInternosD() {
        return internosD;
    }

    public void setInternosD(String internosD) {
        this.internosD = internosD;
    }

    public String getInternosL() {
        return internosL;
    }

    public void setInternosL(String internosL) {
        this.internosL = internosL;
    }

    public String getIvaD() {
        return ivaD;
    }

    public void setIvaD(String ivaD) {
        this.ivaD = ivaD;
    }

    public String getIvaL() {
        return ivaL;
    }

    public void setIvaL(String ivaL) {
        this.ivaL = ivaL;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSobreIi() {
        return sobreIi;
    }

    public void setSobreIi(String sobreIi) {
        this.sobreIi = sobreIi;
    }

    public String getSobreIva() {
        return sobreIva;
    }

    public void setSobreIva(String sobreIva) {
        this.sobreIva = sobreIva;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCodigoTabla14() {
        return codigoTabla14;
    }

    public void setCodigoTabla14(String codigoTabla14) {
        this.codigoTabla14 = codigoTabla14;
    }

    public Integer getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(Integer condicionIva) {
        this.condicionIva = condicionIva;
    }

    public String getCodigoTabla18() {
        return codigoTabla18;
    }

    public void setCodigoTabla18(String codigoTabla18) {
        this.codigoTabla18 = codigoTabla18;
    }

    public String getCodigoTabla05() {
        return codigoTabla05;
    }

    public void setCodigoTabla05(String codigoTabla05) {
        this.codigoTabla05 = codigoTabla05;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
