package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.crm.Cliente;
import com.designfreed.galiasserverbackend.domain.crm.Direccion;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.domain.tango.DireccionEntregaTango;
import com.designfreed.galiasserverbackend.repositories.ClienteRepository;
import com.designfreed.galiasserverbackend.repositories.DireccionEntregaRepository;
import com.designfreed.galiasserverbackend.services.ClienteService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Profile("jpa_repository")
@Transactional
public class ClienteServiceRepositoryImpl implements ClienteService {
    private ClienteRepository clienteRepository;
    private DireccionEntregaRepository direccionEntregaRepository;

    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Autowired
    public void setDireccionEntregaRepository(DireccionEntregaRepository direccionEntregaRepository) {
        this.direccionEntregaRepository = direccionEntregaRepository;
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
    public ClienteTango findByCodigo(String codigo) {
        return this.clienteRepository.findByCodigo(codigo);
    }

    @Override
    public ClienteTango saveOrUpdate(Cliente cliente) {
        try {
            ClienteTango clienteTango = findByCodigo(cliente.getCodigo());

            if (clienteTango == null) {
                clienteTango = new ClienteTango();
            }

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
            clienteTango.setTipoDocumento(getTipoDocumento(cliente.getIva(), cliente.getCuit()));
            clienteTango.setCodigoTabla14(cliente.getCodigo());
            clienteTango.setCondicionIva(getCondicionIva(cliente.getIva()));
            clienteTango.setCodigoTabla18(clienteTango.getProvincia());
            clienteTango.setCodigoTabla05(clienteTango.getZona());

            ClienteTango newCliente = clienteRepository.save(clienteTango);

            if(newCliente != null) {
                generateDireccionEntrega(cliente);
            }

            return newCliente;
        } catch (Exception e) {
            return null;
        }
    }

    private Integer getCondicionPago(Integer dias) {
        switch (dias) {
            case 0:
                return 1;
            case 1:
                return 6;
            case 15:
                return 2;
            case 21:
                return 4;
            case 30:
                return 3;
            case 45:
                return 5;
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

    private Integer getTipoDocumento(String iva, String cuit) {
        Integer tipoDocumento = 0;

        if(iva.equals("ri") || iva.equals("rs") || iva.equals("ex")) {
            tipoDocumento = 80;
        }

        if(iva.equals("cf") && !cuit.isEmpty()) {
            tipoDocumento = 96;
        }

        if(iva.equals("cf") && cuit.isEmpty()) {
            tipoDocumento = 99;
        }

        return tipoDocumento;
    }

    private String formatDireccion(Direccion direccion) {
        String calle = direccion.getCalle();
        String altura = direccion.getAltura();

        return String.format("%s %s", calle, altura);
    }

    private void generateDireccionEntrega(Cliente cliente) {
        DireccionEntregaTango direccionTango = direccionEntregaRepository.findByCodigoAndCliente("PRINCIPAL", cliente.getCodigo());

        if (direccionTango == null) {
            direccionTango = new DireccionEntregaTango();
            direccionTango.setCodigo("PRINCIPAL");
            direccionTango.setCliente(cliente.getCodigo());
        }

        //DireccionEntregaTango direccionTango = new DireccionEntregaTango();
        direccionTango.setDireccion(formatDireccion(cliente.getDireccion()));
        direccionTango.setProvincia("14");
        direccionTango.setLocalidad(cliente.getDireccion().getLocalidad());
        direccionTango.setHabitual("S");
        direccionTango.setCodigoPostal(cliente.getDireccion().getCodigoPostal());
        direccionTango.setTelefono("");
        direccionTango.setHabilitado("S");

        direccionEntregaRepository.save(direccionTango);
    }
}
