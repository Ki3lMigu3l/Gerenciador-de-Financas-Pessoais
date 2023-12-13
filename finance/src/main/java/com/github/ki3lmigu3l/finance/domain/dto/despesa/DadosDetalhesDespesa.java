package com.github.ki3lmigu3l.finance.domain.dto.despesa;

import com.github.ki3lmigu3l.finance.domain.model.Categoria;
import com.github.ki3lmigu3l.finance.domain.model.Despesa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosDetalhesDespesa(

        String descricao,
        BigDecimal valor,
        LocalDateTime data,
        Categoria categoria)

{
        public DadosDetalhesDespesa (Despesa despesa) {
            this(despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria());
        }

}
