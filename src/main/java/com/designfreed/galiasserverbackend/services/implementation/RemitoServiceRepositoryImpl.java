package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.crm.RemitoItem;
import com.designfreed.galiasserverbackend.domain.tango.InventarioTango;
import com.designfreed.galiasserverbackend.domain.tango.RemitoItemTango;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.domain.view.RemitoView;
import com.designfreed.galiasserverbackend.domain.view.RemitoViewItem;
import com.designfreed.galiasserverbackend.domain.view.SyncView;
import com.designfreed.galiasserverbackend.repositories.InventarioRepository;
import com.designfreed.galiasserverbackend.repositories.RemitoItemRepository;
import com.designfreed.galiasserverbackend.repositories.RemitoRepository;
import com.designfreed.galiasserverbackend.repositories.TalonarioRepository;
import com.designfreed.galiasserverbackend.services.RemitoService;
import com.designfreed.galiasserverbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class RemitoServiceRepositoryImpl implements RemitoService {
    private RemitoRepository remitoRepository;
    private RemitoItemRepository remitoItemRepository;
    private InventarioRepository inventarioRepository;
    private TalonarioRepository talonarioRepository;
    private StockService stockService;

    @Autowired
    public void setRemitoRepository(RemitoRepository remitoRepository) {
        this.remitoRepository = remitoRepository;
    }

    @Autowired
    public void setRemitoItemRepository(RemitoItemRepository remitoItemRepository) {
        this.remitoItemRepository = remitoItemRepository;
    }

    @Autowired
    public void setInventarioRepository(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Autowired
    public void setTalonarioRepository(TalonarioRepository talonarioRepository) {
        this.talonarioRepository = talonarioRepository;
    }

    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public RemitoTango findTopByInterno() {
        return remitoRepository.findFirst1ByOrderByInternoDesc();
    }

    @Override
    public String getProximo() {
        return getProximoNroRemito();
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
                //remitoItemTango.setPrecioRemito(getTotalRemito(remitoTango));
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

    @Override
    public Boolean sync(RemitoView remito) {
        try {
            RemitoTango remitoTango = new RemitoTango();

            remitoTango.setCliente(remito.getCliente());
            remitoTango.setEstado("P");
            remitoTango.setFecha(remito.getFecha());
            remitoTango.setMonedaCte(true);
            remitoTango.setComprobante(getProximoNroRemito());
            remitoTango.setRemito(getProximoNroRemito());
            remitoTango.setInterno(getProximoNroInterno());
            remitoTango.setTipo("REM");
            remitoTango.setTalonario(28);
            remitoTango.setTipoTango("RE");
            remitoTango.setTransporte("2");

            Integer renglon = 1;

            List<RemitoItemTango> items = new ArrayList<>();

            for (RemitoViewItem item: remito.getItems()) {
                RemitoItemTango remitoItemTango = new RemitoItemTango();

                remitoItemTango.setCantidadEquivalenteVentas(1F);
                remitoItemTango.setCantidadPendiente(new Float(item.getCantidad()));
                remitoItemTango.setCantidad(new Float(item.getCantidad()));
                remitoItemTango.setArticulo(item.getArticulo());
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

                for (RemitoItemTango item: items) {
                    InventarioTango inv = inventarioRepository.findByArticuloAndDeposito(item.getArticulo(), "ZZ");

                    if(inv != null) {
                        Float cant = inv.getCantidad();
                        inv.setCantidad(cant - item.getCantidad());

                        inventarioRepository.save(inv);
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public SyncView syncAll(List<RemitoView> remitos) {
        SyncView result = new SyncView();
        Map<String, Integer> remanente = new HashMap<>();

        for(RemitoView remito: remitos) {
                Boolean procesar = true;
//                Map<String, Integer> map = new HashMap<>();
//
//                for (RemitoViewItem item: remito.getItems()) {
//                   if (map.containsKey(item.getArticulo())) {
//                       Integer cantidad = map.get(item.getArticulo()) + item.getCantidad();
//                       map.replace(item.getArticulo(), cantidad);
//                   } else {
//                       map.put(item.getArticulo(), item.getCantidad());
//                   }
//                }
//
//                Iterator it = map.keySet().iterator();
//
//                while(it.hasNext()){
//                    String art = (String)it.next();
//                    Integer cant = map.get(art);
//
//                    if (remanente.containsKey(art)) {
//                        Integer cantidad = remanente.get(art);
//
//                        if (cantidad >= cant) {
//                            cantidad = cantidad - cant;
//                            remanente.replace(art, cantidad);
//                        } else {
//                            procesar = false;
//
//                            if (result.getAdvertencias().containsKey(remito.getPedido())) {
//                                result.getAdvertencias().get(remito.getPedido()).add(art);
//                            } else {
//                                List<String> advertencias = new ArrayList<>();
//                                advertencias.add(art);
//                                result.getAdvertencias().put(remito.getPedido(), advertencias);
//                            }
//                        }
//                    } else {
//                        Integer inicial = this.stockService.findStockByArticulo(art);
//
//                        if (inicial >= cant) {
//                            inicial = inicial - cant;
//                        } else {
//                            procesar = false;
//
//                            if (result.getAdvertencias().containsKey(remito.getPedido())) {
//                                result.getAdvertencias().get(remito.getPedido()).add(art);
//                            } else {
//                                List<String> advertencias = new ArrayList<>();
//                                advertencias.add(art);
//                                result.getAdvertencias().put(remito.getPedido(), advertencias);
//                            }
//                        }
//
//                        remanente.put(art, inicial);
//                    }
//                }

                if (procesar) {
                    try {
                        RemitoTango remitoTango = new RemitoTango();

                        remitoTango.setCliente(remito.getCliente());
                        remitoTango.setEstado("P");
                        remitoTango.setFecha(remito.getFecha());
                        remitoTango.setMonedaCte(true);
                        remitoTango.setComprobante(getProximoNroRemito());
                        remitoTango.setRemito(getProximoNroRemito());
                        remitoTango.setInterno(getProximoNroInterno());
                        remitoTango.setTipo("REM");
                        remitoTango.setTalonario(28);
                        remitoTango.setTipoTango("RE");
                        remitoTango.setTransporte("2");

                        Integer renglon = 1;

                        List<RemitoItemTango> items = new ArrayList<>();

                        for (RemitoViewItem item: remito.getItems()) {
                            RemitoItemTango remitoItemTango = new RemitoItemTango();

                            remitoItemTango.setCantidadEquivalenteVentas(1F);
                            remitoItemTango.setCantidadPendiente(new Float(item.getCantidad()));
                            remitoItemTango.setCantidad(new Float(item.getCantidad()));
                            remitoItemTango.setArticulo(item.getArticulo());
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

                            for (RemitoItemTango item: items) {
                                InventarioTango inv = inventarioRepository.findByArticuloAndDeposito(item.getArticulo(), "ZZ");

                                if(inv != null) {
                                    Float cant = inv.getCantidad();
                                    inv.setCantidad(cant - item.getCantidad());

                                    inventarioRepository.save(inv);
                                }
                            }
                        }

                        result.getSincronizados().add(remito.getPedido());
                    } catch (Exception e) {
                        result.getErrores().add(remito.getPedido());
                    }
                }
        }

        return result;
    }

    private String getProximoNroInterno() {
        String ultimoInterno = remitoRepository.findFirst1ByOrderByInternoDesc().getInterno();

        Integer proximoInterno = Integer.valueOf(ultimoInterno) + 1;

        return String.format("%08d", proximoInterno);
    }

    private String getProximoNroRemito() {
        RemitoTango remito = remitoRepository.findFirst1ByTalonarioOrderByComprobanteDesc(5);

        if (remito == null) {
            return "R0000100000001";
        } else {
            String ultimoComprobante = remito.getComprobante().substring(6);

            Integer proximoComprobante = Integer.valueOf(ultimoComprobante.replaceFirst("^0+(?!$)", "")) + 1;

            return "R00001" + String.format("%08d", proximoComprobante);
        }
    }

    private Float getTotalRemito(RemitoView remito) {
        Float total = 0F;

        for (RemitoViewItem item: remito.getItems()) {
            total = total + (item.getPrecio() * item.getCantidad());
        }

        return total;
    }
}
