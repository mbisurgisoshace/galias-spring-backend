package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.tango.FacturaVtaTango;
import com.designfreed.galiasserverbackend.domain.tango.ImputacionTango;
import com.designfreed.galiasserverbackend.domain.view.CuentaCorrienteView;
import com.designfreed.galiasserverbackend.repositories.FacturaVtaRepository;
import com.designfreed.galiasserverbackend.repositories.ImputacionRepository;
import com.designfreed.galiasserverbackend.services.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaCorrienteServiceRepositoryImpl implements CuentaCorrienteService {
    private FacturaVtaRepository facturaVtaRepository;
    private ImputacionRepository imputacionRepository;

    @Autowired
    public void setFacturaVtaRepository(FacturaVtaRepository facturaVtaRepository) {
        this.facturaVtaRepository = facturaVtaRepository;
    }

    @Autowired
    public void setImputacionRepository(ImputacionRepository imputacionRepository) {
        this.imputacionRepository = imputacionRepository;
    }

    @Override
    public CuentaCorrienteView getCuentaCorriente(String cliente) {
        List<FacturaVtaTango> result = new ArrayList<>();
        List<FacturaVtaTango> pendientes = getFacturas(cliente);
        CuentaCorrienteView ctacte = new CuentaCorrienteView();

        if (pendientes != null) {
            Float total = 0F;

            for (FacturaVtaTango fac: pendientes) {
                List<ImputacionTango> imputaciones = getImputaciones(fac.getComprobante(), fac.getTipoComp());
                Float importe = 0F;

                if (imputaciones != null || imputaciones.size() > 0) {
                    for (ImputacionTango imp: imputaciones) {
                        importe = importe + imp.getImporte();
                    }
                }

                fac.setImporte(fac.getImporte() - importe);
                total = total + fac.getImporte();

                result.add(fac);
            }

            ctacte.setPendientes(result);
            ctacte.setTotal(total);
        }

        
        return ctacte;
    }

    private List<FacturaVtaTango> getFacturas(String cliente) {
        List<FacturaVtaTango> facturas = new ArrayList<>();

        try {
            facturas = this.facturaVtaRepository.findAllByClienteAndEstado(cliente, "PEN");
        } catch (Exception ex) {
            facturas = null;
        }

        return facturas;
    }

    private List<ImputacionTango> getImputaciones(String comprobante, String tipo) {
        List<ImputacionTango> imputaciones = new ArrayList<>();
        
        try {
            imputaciones = this.imputacionRepository.findAllByComprobanteAndTipoComp(comprobante, tipo);
        } catch (Exception ex) {
            imputaciones = null;
        }
        
        return imputaciones;
    }
}
