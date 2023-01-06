package com.designfreed.galiasserverbackend.domain.tango;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CPA04")
public class ComprobanteCpa implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_CPA04")
    private Long id;

    @Column(name = "NCOMP_IN_C")
    private Long nCompInC;

    @Column(name = "COD_PROVEE")
    private String codProvee;

    @Column(name = "FECHA_EMIS")
    private Date fecha;

    @Column(name = "HORA_INGRESO")
    private String hora;

    @Column(name = "N_COMP")
    private String nComp;

    @Column(name = "T_COMP")
    private String tComp;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "NCOMP_IN_C", referencedColumnName = "NCOMP_IN_C", nullable = false)
    private List<ItemComprobanteCpa> items = new ArrayList<>();

    @Column(name = "PROCESADO")
    private Boolean procesado;

    public ComprobanteCpa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getnCompInC() {
        return nCompInC;
    }

    public void setnCompInC(Long nCompInC) {
        this.nCompInC = nCompInC;
    }

    public String getCodProvee() {
        return codProvee;
    }

    public void setCodProvee(String codProvee) {
        this.codProvee = codProvee;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getnComp() {
        return nComp;
    }

    public void setnComp(String nComp) {
        this.nComp = nComp;
    }

    public String gettComp() {
        return tComp;
    }

    public void settComp(String tComp) {
        this.tComp = tComp;
    }

    public List<ItemComprobanteCpa> getItems() {
        return items;
    }

    public void setItems(List<ItemComprobanteCpa> items) {
        this.items = items;
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
}
