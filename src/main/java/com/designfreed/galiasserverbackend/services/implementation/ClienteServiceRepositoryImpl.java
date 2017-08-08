package com.designfreed.galiasserverbackend.services.implementation;

import com.designfreed.galiasserverbackend.domain.Cliente;
import com.designfreed.galiasserverbackend.repositories.ClienteRepository;
import com.designfreed.galiasserverbackend.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa_repository")
public class ClienteServiceRepositoryImpl implements ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return this.clienteRepository.findOne(id);
    }
}
