package com.reciclatown.controller;

import com.reciclatown.model.Fornecedor;
import com.reciclatown.repository.FornecedorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@Api(value = "Fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorRepository repository;

    @ApiOperation(value = "Buscar fornecedores")
    @GetMapping(value = "/fornecedores", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fornecedor> buscarTodosFornecedores() {
        return repository.findAll();
    }

    @ApiOperation(value = "Cadastrar um novo fornecedor")
    @PostMapping(value = "/fornecedores", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fornecedor cadastrarNovoFornecedor(@RequestBody Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    @ApiOperation(value = "Buscar dados de um fornecedor pelo ID")
    @GetMapping(value = "/fornecedores/{id}")
    public Optional<Fornecedor> buscarFornecedorPeloId(@PathVariable String id) {
        return repository.findById(id);
    }

    @ApiOperation(value = "Ataualização de dados de um fornecedor")
    @PutMapping(value = "/fornecedores/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizarDadosDoFornecedor(@RequestBody Fornecedor fornecedor) {
        repository.save(fornecedor);
    }

    @ApiOperation(value = "Excluir um fornecedor")
    @DeleteMapping(value = "/fornecedores/{id}")
    public void excluirFornecedor(@PathVariable String id) {
        Fornecedor st = new Fornecedor();
        st.setId(id);
        repository.delete(st);
    }

}
