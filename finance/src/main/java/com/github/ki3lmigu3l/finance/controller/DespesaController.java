package com.github.ki3lmigu3l.finance.controller;

import com.github.ki3lmigu3l.finance.domain.dto.despesa.DadosCadastroDespesa;
import com.github.ki3lmigu3l.finance.domain.dto.despesa.DadosDetalhesDespesa;
import com.github.ki3lmigu3l.finance.domain.model.Despesa;
import com.github.ki3lmigu3l.finance.service.DespesaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DadosDetalhesDespesa> saveDespesa (@RequestBody DadosCadastroDespesa despesaDto) {
        var despesa = new Despesa();
        BeanUtils.copyProperties(despesaDto, despesa);
        despesaService.save(despesa);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhesDespesa(despesa));
    }
}
