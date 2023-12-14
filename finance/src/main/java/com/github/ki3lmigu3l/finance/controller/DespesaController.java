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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<Despesa>> getAllDespesas () {
        return ResponseEntity.status(HttpStatus.OK).body(despesaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getDespesaById (@PathVariable (value = "id") UUID id) {
        Optional<Despesa> despesaOptional = despesaService.findById(id);

        if (despesaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(despesaOptional.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDespesaById (@PathVariable UUID id) {
        Optional<Despesa> despesaOptional = despesaService.findById(id);

        if (despesaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrada.");
        }

        var despesa = despesaOptional.get();
        despesaService.delete(despesa);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Despesa deletada com sucesso");
    }
}
