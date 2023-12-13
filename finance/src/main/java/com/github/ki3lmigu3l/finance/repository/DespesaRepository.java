package com.github.ki3lmigu3l.finance.repository;

import com.github.ki3lmigu3l.finance.domain.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DespesaRepository extends JpaRepository<Despesa, UUID> {

}
