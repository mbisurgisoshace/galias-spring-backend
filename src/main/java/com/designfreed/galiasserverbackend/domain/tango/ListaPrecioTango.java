package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;

@Entity
@Table(name = "GVA10")
public class ListaPrecioTango {
    @Id
    @GeneratedValue
    @Column(name = "ID_GVA10")
    private Long id;

    @Column(name = "DECIMALES")
    private Integer decimales;

    @Column(name = "HABILITADA")
    private Boolean habilitada;

    @Column(name = "INCLUY_IVA")
    private Boolean iva;

    @Column(name = "NOMBRE_LIS")
    private String nombre;

    @Column(name = "NRO_DE_LIS")
    private Integer numero;
}
