package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.Articulo;
import com.designfreed.galiasserverbackend.repositories.ArticuloRepository;
import com.designfreed.galiasserverbackend.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa_repository")
public class ArticuloServiceRepositoryImpl implements ArticuloService {
    private ArticuloRepository articuloRepository;

    @Autowired
    public void setArticuloRepository(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) this.articuloRepository.findAll();
    }

    @Override
    public Articulo findById(Long id) {
        return this.articuloRepository.findOne(id);
    }
}
