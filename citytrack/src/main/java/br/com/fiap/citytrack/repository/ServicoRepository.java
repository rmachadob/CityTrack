package br.com.fiap.citytrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.citytrack.model.Servico;


public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByPrioridade(String prioridade);
    List<Servico> findByStatus(String status);
    
}