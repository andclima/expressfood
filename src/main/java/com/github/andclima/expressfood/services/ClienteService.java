package com.github.andclima.expressfood.services;

import java.util.List;
import java.util.Optional;

import com.github.andclima.expressfood.model.Cliente;
import com.github.andclima.expressfood.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void adiciona(Cliente cliente) {
        cliente.setId(null);
        repository.save(cliente);
    }

    public void atualiza(Cliente cliente) {
        repository.save(cliente);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Cliente busca(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);
    }

    public List<Cliente> lista() {
        return repository.findAll();
    }
    
}
