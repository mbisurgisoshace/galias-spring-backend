package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.services.RemitoService;
import com.google.gson.JsonObject;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remito")
public class RemitoRestController {
    private RemitoService remitoService;

    @Autowired
    public void setRemitoService(RemitoService remitoService) {
        this.remitoService = remitoService;
    }

    @GetMapping("/interno/top")
    public RemitoTango findTop() {
        return this.remitoService.findTopByInterno();
    }

    @PostMapping("/new")
    public ResponseEntity<RemitoTango> add(@RequestBody JsonObject remito) {
        RemitoTango savedRemito = remitoService.saveOrUpdate(null);

        ResponseEntity<RemitoTango> response;

        if (savedRemito != null) {
            response = ResponseEntity.ok(savedRemito);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }
}
