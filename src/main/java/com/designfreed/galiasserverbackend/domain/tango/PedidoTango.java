package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "GVA21")
public class PedidoTango implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA21")
    private Long id;

    @Column(name = "COD_CLIENT")
    private String cliente;

    @Column(name = "ESTADO")
    private Integer estado;
    
    @Column(name = "FECHA_PEDI")
    private Date fecha;

    @Column(name = "FECHA_APRU")
    private Date fechaAprobacion;

    @Column(name = "FECHA_ENTR")
    private Date fechaEntregra;

    @Column(name = "MON_CTE")
    private Boolean monedaCte;

    @Column(name = "N_PEDIDO")
    private String pedido;

    @Column(name = "COND_VTA")
    private Integer condicionVenta;

    @Column(name = "NRO_SUCURS")
    private Integer sucursal;

    @Column(name = "TALONARIO")
    private Integer talonario;

    @Column(name = "TALON_PED")
    private Integer talonarioPedido;

    @Column(name = "TOTAL_PEDI")
    private Float total;

    @Column(name = "COD_SUCUR")
    private String sucursalEmp;

    @Column(name = "COD_TRANSP")
    private String transporte;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "NCOMP_IN_S", referencedColumnName = "NCOMP_IN_S", nullable = false)
//    private List<RemitoItemTango> items = new ArrayList<>();

    public PedidoTango() {
    }

    
}
