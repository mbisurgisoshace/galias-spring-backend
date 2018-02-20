package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.crm.Cliente;
import com.designfreed.galiasserverbackend.domain.crm.Direccion;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.repositories.ClienteRepository;
import com.designfreed.galiasserverbackend.services.ClienteService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Profile("jpa_repository")
public class ClienteServiceRepositoryImpl implements ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteTango> findAll() {
        return (List<ClienteTango>) this.clienteRepository.findAll();
    }

    @Override
    public ClienteTango findById(Long id) {
        return this.clienteRepository.findOne(id);
    }

    @Override
    public ClienteTango saveOrUpdate(Cliente cliente) {
        ClienteTango clienteTango = new ClienteTango();

        clienteTango.setCodigo(cliente.getCodigo());
        clienteTango.setProvincia("14");
        clienteTango.setZona("1");
        clienteTango.setCondicionVenta(getCondicionPago(cliente.getCondicionPago()));
        clienteTango.setCuit(cliente.getCuit());
        clienteTango.setDireccionComercial(formatDireccion(cliente.getDireccion()));
        clienteTango.setDireccion(clienteTango.getDireccionComercial());
        clienteTango.setFechaAlta(new Date());
        clienteTango.setInternosD("N");
        clienteTango.setInternosL("N");
        clienteTango.setIvaD(getDiscriminaIva(cliente.getIva()));
        clienteTango.setIvaL("S");
        clienteTango.setNombreComercial(cliente.getNombreComercial());
        clienteTango.setRazonSocial(cliente.getRazonSocial());
        clienteTango.setSobreIi("N");
        clienteTango.setSobreIva("N");
        clienteTango.setTelefono("");
        clienteTango.setTipoDocumento(getTipoDocumento(cliente.getIva()));
        clienteTango.setCodigoTabla14(cliente.getCodigo());
        clienteTango.setCondicionIva(getCondicionIva(cliente.getIva()));
        clienteTango.setCodigoTabla18(clienteTango.getProvincia());
        clienteTango.setCodigoTabla05(clienteTango.getZona());


        return clienteRepository.save(clienteTango);
    }

    private Integer getCondicionPago(Integer dias) {
        switch (dias) {
            case 0:
                return 1;
            case 7:
                return 2;
            case 15:
                return 3;
            default:
                return 0;
        }
    }

    private String getDiscriminaIva(String iva) {
        String discrimina = "N";

        if (iva.equals("ri")) {
            discrimina = "S";
        }

        return discrimina;
    }

    private Integer getCondicionIva(String iva) {
        Integer condicionIva = 0;

        if (iva.equals("ri")) {
            condicionIva = 1;
        }

        if (iva.equals("cf")) {
            condicionIva = 2;
        }

        if (iva.equals("rs")) {
            condicionIva = 4;
        }

        if (iva.equals("ex")) {
            condicionIva = 5;
        }

        return condicionIva;
    }

    private Integer getTipoDocumento(String iva) {
        Integer tipoDocumento = 0;

        if(iva.equals("ri") || iva.equals("rs") || iva.equals("ex")) {
            tipoDocumento = 80;
        }

        if(iva.equals("cf")) {
            tipoDocumento = 99;
        }

        return tipoDocumento;
    }

    private String formatDireccion(Direccion direccion) {
        String calle = direccion.getCalle();
        String altura = direccion.getAltura();

        return String.format("%s %s", calle, altura);
    }
}
