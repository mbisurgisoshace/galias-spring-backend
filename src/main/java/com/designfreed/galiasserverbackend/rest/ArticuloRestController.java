package com.designfreed.galiasserverbackend.rest;

import com.designfreed.galiasserverbackend.domain.crm.Articulo;
import com.designfreed.galiasserverbackend.domain.tango.ArticuloTango;
import com.designfreed.galiasserverbackend.services.ArticuloService;
import com.designfreed.galiasserverbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/articulo")
public class ArticuloRestController {
    private StockService stockService;
    private ArticuloService articuloService;

    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    @Autowired
    public void setArticuloService(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/list")
    public List<ArticuloTango> findAll() {
        return this.articuloService.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<ArticuloTango> add(@RequestBody Articulo articulo) {
        ArticuloTango savedArticulo = articuloService.saveOrUpdate(articulo);

        ResponseEntity<ArticuloTango> response;

        if (savedArticulo != null) {
            response = ResponseEntity.ok(savedArticulo);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @PatchMapping("/update")
    public ResponseEntity<ArticuloTango> update(@RequestBody Articulo articulo) {
        ArticuloTango savedArticulo = articuloService.saveOrUpdate(articulo);

        ResponseEntity<ArticuloTango> response;

        if (savedArticulo != null) {
            response = ResponseEntity.ok(savedArticulo);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @PatchMapping("/update/precios")
    public ResponseEntity<Boolean> updatePrecios(@RequestBody List<Articulo> articulos) {
        Boolean precios = articuloService.precios(articulos);

        ResponseEntity<Boolean> response;

        if (precios != null) {
            response = ResponseEntity.ok(precios);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @GetMapping("/stock/{articulo}")
    public Integer getStock(@PathVariable(name = "articulo") String articulo) {
        return this.stockService.findStockByArticulo(articulo);
    }
}
