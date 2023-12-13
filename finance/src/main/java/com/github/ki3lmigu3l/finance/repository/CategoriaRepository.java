package com.github.ki3lmigu3l.finance.repository;

import com.github.ki3lmigu3l.finance.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
