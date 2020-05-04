package br.com.fiap.citytrack.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import br.com.fiap.citytrack.model.Servico;
import br.com.fiap.citytrack.repository.ServicoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Servico")
@RequestMapping("servico")
public class ServicoResource {
    @Autowired
    private ServicoRepository servicoRepository;
    @ApiOperation(value = "Listar serviços")
    @GetMapping
    public List<Servico> listar() {
        return servicoRepository.findAll();
    }
    @ApiOperation(value = "Buscar pelo código")
    @GetMapping("{codigo}")
    public Servico buscar(@PathVariable int codigo) {
        return servicoRepository.findById(codigo).get();
    }
    @ApiOperation(value = "Cadastrar serviço")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Servico cadastrar(@RequestBody Servico servico) {
    	servico.setDataCriacao(LocalDateTime.now());
        return servicoRepository.save(servico);
    }
    @ApiOperation(value = "Atualizar serviço")
    @PutMapping("{id}")
    public Servico atualizar(@RequestBody Servico servico, @PathVariable int id) {
        servico.setCodigo(id);
        return servicoRepository.save(servico);
    }
    @ApiOperation(value = "Deletar serviço")
    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        servicoRepository.deleteById(codigo);
    }
    @ApiOperation(value = "Pesquisar serviço")
    @GetMapping("pesquisa")
    public List<Servico> buscar(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "false") String prioridade, @RequestParam(defaultValue = "false") String status) {
        return descricao != null ? servicoRepository.findByPrioridade(prioridade) : servicoRepository.findByStatus(status);
    }
}