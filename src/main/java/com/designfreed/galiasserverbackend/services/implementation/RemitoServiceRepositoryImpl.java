package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.crm.RemitoItem;
import com.designfreed.galiasserverbackend.domain.tango.RemitoItemTango;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.repositories.RemitoItemRepository;
import com.designfreed.galiasserverbackend.repositories.RemitoRepository;
import com.designfreed.galiasserverbackend.services.RemitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemitoServiceRepositoryImpl implements RemitoService {
    private RemitoRepository remitoRepository;
    private RemitoItemRepository remitoItemRepository;

    @Autowired
    public void setRemitoRepository(RemitoRepository remitoRepository) {
        this.remitoRepository = remitoRepository;
    }

    @Autowired
    public void setRemitoItemRepository(RemitoItemRepository remitoItemRepository) {
        this.remitoItemRepository = remitoItemRepository;
    }

    @Override
    public RemitoTango findTopByInterno() {
        return remitoRepository.findFirst1ByOrderByInternoDesc();
        //return null;
    }

    @Override
    public List<RemitoTango> findAll() {
        return null;
    }

    @Override
    public RemitoTango findById(Long id) {
        return null;
    }

    @Override
    public RemitoTango saveOrUpdate(Remito remito) {
        try {
            RemitoTango remitoTango = new RemitoTango();

            remitoTango.setCliente(remito.getCliente().getCodigo());
            remitoTango.setEstado("P");
            remitoTango.setFecha(remito.getFecha());
            remitoTango.setMonedaCte(true);
            remitoTango.setComprobante(remito.getNumero());
            remitoTango.setRemito(remito.getNumero());
            remitoTango.setInterno(getProximoNroInterno());
            remitoTango.setTipo("REM");
            remitoTango.setTalonario(5);
            remitoTango.setTipoTango("RE");
            remitoTango.setTransporte("2");

            Integer renglon = 1;

            List<RemitoItemTango> items = new ArrayList<>();

            for (RemitoItem item: remito.getItems()) {
                RemitoItemTango remitoItemTango = new RemitoItemTango();

                remitoItemTango.setCantidadEquivalenteVentas(1F);
                remitoItemTango.setCantidadPendiente(new Float(item.getCantidad()));
                remitoItemTango.setCantidad(new Float(item.getCantidad()));
                remitoItemTango.setArticulo(item.getArticulo().getCodigo());
                remitoItemTango.setDeposito("ZZ");
                remitoItemTango.setEquivalencia(1F);
                remitoItemTango.setFecha(remito.getFecha());
                remitoItemTango.setRenglon(renglon);
                remitoItemTango.setInterno(remitoTango.getInterno());
                remitoItemTango.setPrecio(item.getPrecio());
                remitoItemTango.setPrecioRemito(getTotalRemito(remito));
                remitoItemTango.setTipoComp("RE");
                remitoItemTango.setTipoMov("S");

                items.add(remitoItemTango);

                renglon++;
            }

            RemitoTango newRemito = remitoRepository.save(remitoTango);

            if (newRemito != null) {
                remitoItemRepository.save(items);
            }

            return remitoRepository.save(remitoTango);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private String getProximoNroInterno() {
        String ultimoInterno = remitoRepository.findFirst1ByOrderByInternoDesc().getInterno();

        Integer proximoInterno = Integer.valueOf(ultimoInterno) + 1;

        return String.format("%08d", proximoInterno);
    }

    private Float getTotalRemito(Remito remito) {
        Float total = 0F;

        for (RemitoItem item: remito.getItems()) {
            total = total + (item.getPrecio() * item.getCantidad());
        }

        return total;
    }
}
