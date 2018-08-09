package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STA11")
public class ArticuloTango implements Serializable {
    @TableGenerator(name = "articulo-gen", table = "PROVIDERID", pkColumnName = "ID_PROVIDERID", valueColumnName = "ULTIMOID", pkColumnValue = "10", allocationSize=1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "articulo-gen")
    @Column(name = "ID_STA11")
    private Long id;

    @Column(name = "COD_ARTICU")
    private String codigo;

    @Column(name = "COD_II")
    private Integer iiVentas;

    @Column(name = "COD_II_CO")
    private Integer iiCompras;

    @Column(name = "COD_IVA")
    private Integer ivaVentas;

    @Column(name = "COD_IVA_CO")
    private Integer ivaCompras;

    @Column(name = "COD_S_II")
    private Integer percepIiVentas;

    @Column(name = "COD_S_II_C")
    private Integer percepIiCompras;

    @Column(name = "COD_S_IVA")
    private Integer percepIvaVentas;

    @Column(name = "COD_S_IV_C")
    private Integer percepIvaCompras;

    @Column(name = "DESCRIPCIO")
    private String descripcion;

    @Column(name = "EQUIVALE_V")
    private Float equivalenciaVenta;

    @Column(name = "FECHA_ALTA")
    private Date fechaAlta;

    @Column(name = "PERFIL")
    private String perfil;

    @Column(name = "PROMO_MENU")
    private String tipo;

    @Column(name = "STOCK")
    private Boolean stock;

    @Column(name = "USA_ESC")
    private String escala;

    @Column(name = "USA_PARTID")
    private Boolean partida;

    @Column(name = "MET_DES_PA")
    private String descarga;

    @Column(name = "ORD_DES_PA")
    private String orden;

    @Column(name = "REMITIBLE")
    private String remitible;

    @Column(name = "COD_STA11")
    private String codigoTabla11;

    @Column(name = "ID_MEDIDA_STOCK")
    private Integer unidadStock;

    @Column(name = "ID_MEDIDA_VENTAS")
    private Integer unidadVenta;

    @Column(name = "DESCARGA_NEGATIVO_STOCK")
    private Boolean stockNegativo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "COD_ARTICU", referencedColumnName = "COD_ARTICU" ,nullable = false, insertable = false, updatable = false)
    private List<PrecioTango> precios;


    public ArticuloTango() {
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

    public Integer getIiVentas() {
        return iiVentas;
    }

    public void setIiVentas(Integer iiVentas) {
        this.iiVentas = iiVentas;
    }

    public Integer getIiCompras() {
        return iiCompras;
    }

    public void setIiCompras(Integer iiCompras) {
        this.iiCompras = iiCompras;
    }

    public Integer getIvaVentas() {
        return ivaVentas;
    }

    public void setIvaVentas(Integer ivaVentas) {
        this.ivaVentas = ivaVentas;
    }

    public Integer getIvaCompras() {
        return ivaCompras;
    }

    public void setIvaCompras(Integer ivaCompras) {
        this.ivaCompras = ivaCompras;
    }

    public Integer getPercepIiVentas() {
        return percepIiVentas;
    }

    public void setPercepIiVentas(Integer percepIiVentas) {
        this.percepIiVentas = percepIiVentas;
    }

    public Integer getPercepIiCompras() {
        return percepIiCompras;
    }

    public void setPercepIiCompras(Integer percepIiCompras) {
        this.percepIiCompras = percepIiCompras;
    }

    public Integer getPercepIvaVentas() {
        return percepIvaVentas;
    }

    public void setPercepIvaVentas(Integer percepIvaVentas) {
        this.percepIvaVentas = percepIvaVentas;
    }

    public Integer getPercepIvaCompras() {
        return percepIvaCompras;
    }

    public void setPercepIvaCompras(Integer percepIvaCompras) {
        this.percepIvaCompras = percepIvaCompras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getEquivalenciaVenta() {
        return equivalenciaVenta;
    }

    public void setEquivalenciaVenta(Float equivalenciaVenta) {
        this.equivalenciaVenta = equivalenciaVenta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Boolean getPartida() {
        return partida;
    }

    public void setPartida(Boolean partida) {
        this.partida = partida;
    }

    public String getDescarga() {
        return descarga;
    }

    public void setDescarga(String descarga) {
        this.descarga = descarga;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getRemitible() {
        return remitible;
    }

    public void setRemitible(String remitible) {
        this.remitible = remitible;
    }

    public String getCodigoTabla11() {
        return codigoTabla11;
    }

    public void setCodigoTabla11(String codigoTabla11) {
        this.codigoTabla11 = codigoTabla11;
    }

    public Integer getUnidadStock() {
        return unidadStock;
    }

    public void setUnidadStock(Integer unidadStock) {
        this.unidadStock = unidadStock;
    }

    public Integer getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(Integer unidadVenta) {
        this.unidadVenta = unidadVenta;
    }

    public Boolean getStockNegativo() {
        return stockNegativo;
    }

    public void setStockNegativo(Boolean stockNegativo) {
        this.stockNegativo = stockNegativo;
    }

    public List<PrecioTango> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioTango> precios) {
        this.precios = precios;
    }
}
