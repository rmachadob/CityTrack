package br.com.fiap.citytrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.citytrack.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
