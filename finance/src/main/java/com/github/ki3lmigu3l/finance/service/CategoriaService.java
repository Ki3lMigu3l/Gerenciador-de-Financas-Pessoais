package com.github.ki3lmigu3l.finance.service;

import com.github.ki3lmigu3l.finance.domain.model.Categoria;
import com.github.ki3lmigu3l.finance.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
