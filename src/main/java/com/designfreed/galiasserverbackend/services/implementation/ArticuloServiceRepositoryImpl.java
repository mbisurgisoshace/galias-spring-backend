package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.crm.Articulo;
import com.designfreed.galiasserverbackend.domain.crm.Equivalencia;
import com.designfreed.galiasserverbackend.domain.crm.Unidad;
import com.designfreed.galiasserverbackend.domain.tango.ArticuloTango;
import com.designfreed.galiasserverbackend.domain.tango.EquivalenciaTango;
import com.designfreed.galiasserverbackend.domain.tango.PrecioTango;
import com.designfreed.galiasserverbackend.repositories.ArticuloRepository;
import com.designfreed.galiasserverbackend.repositories.EquivalenciaRepository;
import com.designfreed.galiasserverbackend.repositories.PrecioRepository;
import com.designfreed.galiasserverbackend.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Profile("jpa_repository")
public class ArticuloServiceRepositoryImpl implements ArticuloService {
    private ArticuloRepository articuloRepository;
    private EquivalenciaRepository equivalenciaRepository;
    private PrecioRepository precioRepository;

    @Autowired
    public void setArticuloRepository(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Autowired
    public void setEquivalenciaRepository(EquivalenciaRepository equivalenciaRepository) {
        this.equivalenciaRepository = equivalenciaRepository;
    }

    @Autowired
    public void setPrecioRepository(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    @Override
    public List<ArticuloTango> findAll() {
        return (List<ArticuloTango>) this.articuloRepository.findAll();
    }

    @Override
    public ArticuloTango findById(Long id) {
        return this.articuloRepository.findOne(id);
    }

    @Override
    public ArticuloTango findByCodigo(String codigo) {
        return this.articuloRepository.findByCodigo(codigo);
    }


    @Override
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public ArticuloTango saveOrUpdate(Articulo articulo) {
        try {
            ArticuloTango articuloTango = findByCodigo(articulo.getCodigo());

            if (articuloTango == null) {
                articuloTango = new ArticuloTango();
            }

            articuloTango.setCodigo(articulo.getCodigo());
            articuloTango.setIiVentas(21);
            articuloTango.setIiCompras(40);
            articuloTango.setIvaVentas(getIva(articulo.getIva()));
            articuloTango.setIvaCompras(getIva(articulo.getIva()));
            articuloTango.setPercepIiVentas(41);
            articuloTango.setPercepIiCompras(0);
            articuloTango.setPercepIvaVentas(11);
            articuloTango.setPercepIvaCompras(0);
            articuloTango.setDescripcion(articulo.getDescripcion());
            articuloTango.setEquivalenciaVenta(articulo.getUnidadesVta().get(0).getEquivalencia().floatValue());
            articuloTango.setFechaAlta(new Date());
            articuloTango.setPerfil("A");
            articuloTango.setTipo("A");
            articuloTango.setStock(true);
            articuloTango.setEscala("N");
            articuloTango.setPartida(articulo.getLote());
            articuloTango.setDescarga("VTO");
            articuloTango.setOrden("A");
            articuloTango.setRemitible("S");
            articuloTango.setCodigoTabla11(articulo.getCodigo());
            articuloTango.setUnidadStock(getUnidad(articulo.getUnidadStock()));
            articuloTango.setUnidadVenta(getUnidad(articulo.getUnidadesVta().get(0).getUnidad()));
            articuloTango.setStockNegativo(true);

            ArticuloTango newArticulo = articuloRepository.save(articuloTango);

            if(newArticulo != null) {
                generateUnidadesCompra(articulo, articuloTango.getId());
                generatePrecio(articulo);
            }

            return newArticulo;
        } catch (Exception e) {
            return null;
        }
    }

    private Integer getIva(Double iva) {
       if (iva == 10.5) {
           return 2;
       }

       if (iva == 21) {
           return 1;
       }

       if (iva == 27) {
           return 3;
       }

       return 1;
    }

    private Integer getUnidad(Unidad uni) {
        switch (uni.getSigla()) {
            case "uni":
                return 4;
            case "cja":
                return 5;
            default:
                return 4;
        }
    }

    private void generateUnidadesCompra(Articulo articulo, Long id) {
        EquivalenciaTango deletedEquivalenciaTango = equivalenciaRepository.findByArticulo(id);
        equivalenciaRepository.delete(deletedEquivalenciaTango.getId());

        for (Equivalencia equivalencia: articulo.getUnidadesCpa()) {
            EquivalenciaTango equivalenciaTango = new EquivalenciaTango();

            equivalenciaTango.setArticulo(id);
            equivalenciaTango.setUnidad(getUnidad(equivalencia.getUnidad()));
            equivalenciaTango.setEquivalencia(equivalencia.getEquivalencia().floatValue());
            equivalenciaTango.setHabitual(equivalencia.getDefecto());

            equivalenciaRepository.save(equivalenciaTango);
        }
    }

    private void generatePrecio(Articulo articulo) {
        PrecioTango precioConIva = precioRepository.findByArticuloAndNumero(articulo.getCodigo(), 1);
        PrecioTango precioSinIva = precioRepository.findByArticuloAndNumero(articulo.getCodigo(), 2);

        if (precioConIva != null) {
            precioConIva.setPrecio(articulo.getPrecioVta());
            precioConIva.setFechaModificacion(new Date());
        } else {
            precioConIva = new PrecioTango();
            precioConIva.setArticulo(articulo.getCodigo());
            precioConIva.setNumero(1);
            precioConIva.setPrecio(articulo.getPrecioVta());
            precioConIva.setFechaModificacion(new Date());
        }

        if (precioSinIva != null) {
            precioSinIva.setPrecio(articulo.getPrecioVta() / (1 + articulo.getIva() / 100));
            precioSinIva.setFechaModificacion(new Date());
        } else {
            precioSinIva = new PrecioTango();
            precioSinIva.setArticulo(articulo.getCodigo());
            precioSinIva.setNumero(2);
            precioSinIva.setPrecio(articulo.getPrecioVta() / (1 + articulo.getIva() / 100));
            precioSinIva.setFechaModificacion(new Date());
        }

        precioRepository.save(precioConIva);
        precioRepository.save(precioSinIva);
    }
}
