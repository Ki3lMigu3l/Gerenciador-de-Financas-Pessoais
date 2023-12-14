package com.github.ki3lmigu3l.finance.service;

import com.github.ki3lmigu3l.finance.domain.model.Despesa;
import com.github.ki3lmigu3l.finance.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa save(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Optional<Despesa> findById(UUID id) {
        return despesaRepository.findById(id);
    }

    public void delete(Despesa despesa) {
        despesaRepository.delete(despesa);
    }
}
