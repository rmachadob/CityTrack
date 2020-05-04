package br.com.fiap.citytrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.citytrack.model.Categoria;
import br.com.fiap.citytrack.repository.CategoriaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@RestController
	@Api(value = "Categoria")
	@RequestMapping("categoria")
	public class CategoriaResource {
	    @Autowired
	    private CategoriaRepository categoriaRepository;
	    @ApiOperation(value = "Listar categorias")
	    @GetMapping
	    public List<Categoria> listar() {
	        return categoriaRepository.findAll();
	    }
	    @ApiOperation(value = "Buscar pelo código")
	    @GetMapping("{codigo}")
	    public Categoria buscar(@PathVariable int codigo) {
	        return categoriaRepository.findById(codigo).get();
	    }
	    @ApiOperation(value = "Cadastrar categoria")
	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping
	    public Categoria cadastrar(@RequestBody Categoria categoria) {
	        return categoriaRepository.save(categoria);
	    }
	    @ApiOperation(value = "Atualizar categoria")
	    @PutMapping("{id}")
	    public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable int id) {
	        categoria.setCodigo(id);
	        return categoriaRepository.save(categoria);
	    }
	    @ApiOperation(value = "Deletar categoria")
	    @DeleteMapping("{codigo}")
	    public void remover(@PathVariable int codigo) {
	        categoriaRepository.deleteById(codigo);
	    }
	}
