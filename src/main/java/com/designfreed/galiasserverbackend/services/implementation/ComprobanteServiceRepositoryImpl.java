package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.tango.*;
import com.designfreed.galiasserverbackend.domain.view.ComprobanteItemView;
import com.designfreed.galiasserverbackend.domain.view.ComprobanteView;
import com.designfreed.galiasserverbackend.repositories.ComprobanteCpaRepository;
import com.designfreed.galiasserverbackend.repositories.ComprobanteVtaRepository;
import com.designfreed.galiasserverbackend.repositories.ImputacionCpaRepository;
import com.designfreed.galiasserverbackend.repositories.ImputacionVtaRepository;
import com.designfreed.galiasserverbackend.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ComprobanteServiceRepositoryImpl implements ComprobanteService {
    private ComprobanteVtaRepository comprobanteVtaRepository;
    private ComprobanteCpaRepository comprobanteCpaRepository;
    private ImputacionCpaRepository imputacionCpaRepository;
    private ImputacionVtaRepository imputacionVtaRepository;

    @Autowired
    public void setComprobanteVtaRepository(ComprobanteVtaRepository comprobanteVtaRepository) {
        this.comprobanteVtaRepository = comprobanteVtaRepository;
    }

    @Autowired
    public void setComprobanteCpaRepository(ComprobanteCpaRepository comprobanteCpaRepository) {
        this.comprobanteCpaRepository = comprobanteCpaRepository;
    }

    @Autowired
    public void setImputacionCpaRepository(ImputacionCpaRepository imputacionCpaRepository) {
        this.imputacionCpaRepository = imputacionCpaRepository;
    }

    @Autowired
    public void setImputacionVtaRepository(ImputacionVtaRepository imputacionVtaRepository) {
        this.imputacionVtaRepository = imputacionVtaRepository;
    }

    @Override
    public List<ComprobanteItemView> getComprobantes() {
        List<ComprobanteItemView> result = new ArrayList<>();
        List<ComprobanteItemView> cpas = getComprobantesCpa();
        List<ComprobanteItemView> vtas = getComprobantesVta();

        if (cpas != null && cpas.size() != 0) {
            result.addAll(cpas);
        }

        if (vtas != null && vtas.size() != 0) {
            result.addAll(vtas);
        }

        return result;
    }

    private List<ComprobanteItemView> getComprobantesCpa() {
        List<ComprobanteItemView> result = new ArrayList<>();
        List<ComprobanteCpa> cpas = this.comprobanteCpaRepository.findAllByProcesado(false);

        if (cpas != null && cpas.size() != 0) {
            for (ComprobanteCpa cpa: cpas) {
                if (cpa.gettComp().equals("FAC")) {
                    result.addAll(createComprobanteFromCpa(cpa, null, "fac"));
                }

                if (cpa.gettComp().equals("N/C")) { // Stock
                    result.addAll(createComprobanteFromCpa(cpa, null, "nc"));
                }

                if (cpa.gettComp().equals("NCC")) { // Precio
                    result.addAll(createComprobanteFromCpa(cpa, null, "ncc"));
                }

                if (cpa.gettComp().equals("N/D")) { // Precio
                    result.addAll(createComprobanteFromCpa(cpa, null, "ndc"));
                }

                if (cpa.gettComp().equals("NDC")) { // Precio
                    result.addAll(createComprobanteFromCpa(cpa, null, "ndc"));
                }

                cpa.setProcesado(true);
            }
        }

        this.comprobanteCpaRepository.save(cpas);

        return result;
    }

    private List<ComprobanteItemView> getComprobantesVta() {
        List<ComprobanteItemView> result = new ArrayList<>();
        List<ComprobanteVta> vtas = this.comprobanteVtaRepository.findAllByProcesado(false);

        if (vtas != null && vtas.size() != 0) {
            for (ComprobanteVta vta: vtas) {
                if (vta.gettComp().equals("FAC")) { // Stock
                    result.addAll(createComprobanteFromVta(vta, null, "fac"));
                }

                if (vta.gettComp().equals("N/C")) { // Precio
                    result.addAll(createComprobanteFromVta(vta, null, "ncc"));
                }

                if (vta.gettComp().equals("NCR")) { // Stock
                    result.addAll(createComprobanteFromVta(vta, null, "nc"));
                }

                if (vta.gettComp().equals("N/D")) { // Precio
                    result.addAll(createComprobanteFromVta(vta, null, "ndc"));
                }

                if (vta.gettComp().equals("NDB")) { // Stock
                    result.addAll(createComprobanteFromVta(vta, null, "nd"));
                }

                vta.setProcesado(true);
            }
        }

        this.comprobanteVtaRepository.save(vtas);

        return result;
    }

    private List<ComprobanteItemView> createComprobanteFromCpa(ComprobanteCpa cpa, List<String> imputacion, String tipo) {
        List<ComprobanteItemView> result =  new ArrayList<>();

        for (ItemComprobanteCpa item: cpa.getItems()) {
            result.add(new ComprobanteItemView(item.getCodArticu(), cpa.getFecha().getTime(), "cpa", tipo, cpa.getnComp(), item.getCantidad(), item.getPrecioNet()));
        }

        return result;
    }

    private List<String> getImputacionesCpa(ComprobanteCpa cpa) {
        List<String> result = null;
        List<ImputacionCpa> imputaciones = this.imputacionCpaRepository.findAllByNumCompCanAndTipoCompCan(cpa.getnComp(), cpa.gettComp());

        if (imputaciones != null && imputaciones.size() != 0) {
            result = new ArrayList<>();

            for (ImputacionCpa imp: imputaciones) {
                result.add(createNumComprobante(imp.getTipoCompFac(), imp.getNumCompFac()));
            }
        }

        return result;
    }

    private List<ComprobanteItemView> createComprobanteFromVta(ComprobanteVta vta, List<String> imputacion, String tipo) {
        List<ComprobanteItemView> result =  new ArrayList<>();

        for (ItemComprobanteVta item: vta.getItems()) {
            result.add(new ComprobanteItemView(item.getCodArticu(), vta.getFecha().getTime(), "vta", tipo, vta.getnComp(), item.getCantidad(), item.getPrecioNet()));
        }

        return result;
    }

    private List<String> getImputacionesVta(ComprobanteVta vta) {
        List<String> result = null;
        List<ImputacionVta> imputaciones = this.imputacionVtaRepository.findAllByNumCompCanAndTipoCompCan(vta.getnComp(), vta.gettComp());

        if (imputaciones != null && imputaciones.size() != 0) {
            result = new ArrayList<>();

            for (ImputacionVta imp: imputaciones) {
                result.add(createNumComprobante(imp.getTipoCompFac(), imp.getNumCompFac()));
            }
        }

        return result;
    }

    private String createNumComprobante(String tipo, String numero) {
        return tipo + " " + numero;
    }
}
