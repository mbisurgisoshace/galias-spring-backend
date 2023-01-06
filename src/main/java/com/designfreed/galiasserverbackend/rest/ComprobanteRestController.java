package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.view.ComprobanteItemView;
import com.designfreed.galiasserverbackend.domain.view.ComprobanteView;
import com.designfreed.galiasserverbackend.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteRestController {
    private ComprobanteService comprobanteService;

    @Autowired
    public void setComprobanteService(ComprobanteService comprobanteService) {
        this.comprobanteService = comprobanteService;
    }

    @GetMapping("/list")
    public List<ComprobanteItemView> findAll() {
        return this.comprobanteService.getComprobantes();
    }
}
