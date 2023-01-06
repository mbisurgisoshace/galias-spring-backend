package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.view.CuentaCorrienteView;
import com.designfreed.galiasserverbackend.services.CuentaCorrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctacte")
public class CuentaCorrienteRestController {
    private CuentaCorrienteService cuentaCorrienteService;

    @Autowired
    public void setCuentaCorrienteService(CuentaCorrienteService cuentaCorrienteService) {
        this.cuentaCorrienteService = cuentaCorrienteService;
    }

    @GetMapping("/pendientes/{cliente}")
    public CuentaCorrienteView findPendientes(@PathVariable(name = "cliente") String cliente) {
        return this.cuentaCorrienteService.getCuentaCorriente(cliente);
    }
}
