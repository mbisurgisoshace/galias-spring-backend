package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.tango.ArticuloTango;
import com.designfreed.galiasserverbackend.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulo")
public class ArticuloRestController {
    private ArticuloService articuloService;

    @Autowired
    public void setArticuloService(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/list")
    public List<ArticuloTango> findAll() {
        return this.articuloService.findAll();
    }
}
