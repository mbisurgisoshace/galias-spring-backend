package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.crm.Remito;
import com.designfreed.galiasserverbackend.domain.tango.ClienteTango;
import com.designfreed.galiasserverbackend.domain.tango.RemitoTango;
import com.designfreed.galiasserverbackend.domain.view.RemitoView;
import com.designfreed.galiasserverbackend.domain.view.SyncView;
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

    @GetMapping("/proximo")
    public String findProximo() {
        return this.remitoService.getProximo();
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> add(@RequestBody RemitoView remito) {
        Boolean savedRemito = remitoService.sync(remito);

        ResponseEntity<Boolean> response;

        if (savedRemito != null) {
            response = ResponseEntity.ok(savedRemito);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @PostMapping("/syncAll")
    public ResponseEntity<SyncView> syncAll(@RequestBody List<RemitoView> remitos) {
        SyncView result = remitoService.syncAll(remitos);

        ResponseEntity<SyncView> response;

        if (result != null) {
            response = ResponseEntity.ok(result);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }
}
