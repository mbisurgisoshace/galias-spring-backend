package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.tango.StockTango;
import com.designfreed.galiasserverbackend.repositories.StockRepository;
import com.designfreed.galiasserverbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceRepositoryImpl implements StockService {
    private StockRepository stockRepository;

    @Autowired
    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Integer findStockByArticulo(String articulo) {
//        List<StockTango> stock = this.stockRepository.findByArticulo(articulo);
//
//        Integer cantidad = 0;
//
//        for (StockTango it: stock) {
//            if (it.getDeposito() == "ZZ") {
//                cantidad+= it.getCantidad();
//            }
//        }
//
//        return cantidad;
        StockTango stock = this.stockRepository.findByArticuloAndDeposito(articulo, "ZZ");

        if (stock == null) {
            return 0;
        }

        return stock.getCantidad();
    }

    @Override
    public Integer findStockByArticuloAndDeposito(String articulo, String deposito) {
        StockTango stock = this.stockRepository.findByArticuloAndDeposito(articulo, deposito);

        if (stock == null) {
            return 0;
        }

        return stock.getCantidad();
    }

    @Override
    public Boolean hasStock(String articulo, String deposito, Integer cantidad) {
        StockTango stock = this.stockRepository.findByArticuloAndDeposito(articulo, deposito);

        if (stock == null) {
            return false;
        }

        return stock.getCantidad() >= cantidad;
    }

    @Override
    public List<StockTango> findAll() {
        return null;
    }

    @Override
    public StockTango findById(Long id) {
        return null;
    }

    @Override
    public StockTango saveOrUpdate(Long domainObject) {
        return null;
    }
}
