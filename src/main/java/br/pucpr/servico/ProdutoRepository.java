package br.pucpr.servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository<produto, integer> extends JpaRepository<produto, integer=""> {}
