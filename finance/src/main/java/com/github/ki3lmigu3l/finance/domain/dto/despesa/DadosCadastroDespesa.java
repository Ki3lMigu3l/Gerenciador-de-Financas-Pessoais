package com.github.ki3lmigu3l.finance.domain.dto.despesa;

import com.github.ki3lmigu3l.finance.domain.model.Categoria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosCadastroDespesa(
        String descricao,
        BigDecimal valor,
        LocalDateTime data,
        Categoria categoria
) {
}
