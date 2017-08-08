package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.Cliente;
import com.designfreed.galiasserverbackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Cliente> findAll() {
        return this.clienteService.findAll();
    }
}
