package br.com.fiap.citytrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.citytrack.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
