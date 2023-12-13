package com.github.ki3lmigu3l.finance.service;

import com.github.ki3lmigu3l.finance.domain.model.Despesa;
import com.github.ki3lmigu3l.finance.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa save(Despesa despesa) {
        return despesaRepository.save(despesa);
    }
}
