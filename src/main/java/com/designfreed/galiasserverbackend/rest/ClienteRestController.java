package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.crm.Cliente;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    private ClienteService clienteService;

    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/list")
    public List<ClienteTango> findAll() {
        return this.clienteService.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<ClienteTango> add(@RequestBody Cliente cliente) {
        ClienteTango savedCliente = clienteService.saveOrUpdate(cliente);

        ResponseEntity<ClienteTango> response;

        if (savedCliente != null) {
            response = ResponseEntity.ok(savedCliente);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @PatchMapping("/update")
    public ResponseEntity<ClienteTango> update(@RequestBody Cliente cliente) {
        ClienteTango savedCliente = clienteService.saveOrUpdate(cliente);

        ResponseEntity<ClienteTango> response;

        if (savedCliente != null) {
            response = ResponseEntity.ok(savedCliente);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }
}
