package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STA11")
public class ArticuloTango implements Serializable {
    @TableGenerator(name = "articulo-gen", table = "PROVIDERID", pkColumnName = "ID_PROVIDERID", valueColumnName = "ULTIMOID", pkColumnValue = "29", allocationSize=1)
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

    @Column(name = "STOCK")
    private Boolean stock;

    @Column(name = "USA_ESC")
    private String escala;

    @Column(name = "USA_PARTID")
    private Boolean partida;

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
    @JoinColumn(name = "COD_ARTICU", referencedColumnName = "COD_ARTICU", nullable = false)
    private List<PrecioTango> precios = new ArrayList<>();

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PrecioTango> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioTango> precios) {
        this.precios = precios;
    }
}
