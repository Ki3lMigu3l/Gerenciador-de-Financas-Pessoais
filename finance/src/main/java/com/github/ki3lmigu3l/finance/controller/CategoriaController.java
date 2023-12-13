package com.github.ki3lmigu3l.finance.controller;

import com.github.ki3lmigu3l.finance.domain.dto.categoria.DadosCadastroCategoria;
import com.github.ki3lmigu3l.finance.domain.model.Categoria;
import com.github.ki3lmigu3l.finance.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> saveCategoria (@RequestBody DadosCadastroCategoria categoriaDto) {
        var categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }
}
