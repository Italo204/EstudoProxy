package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import com.finan.orcamento.repositories.Proxy.OrcamentoProxy;
import com.finan.orcamento.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping(path="/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService orcamentoService;
    @Autowired
    private OrcamentoRepository orcamentoRepository;
    @Autowired
    private OrcamentoProxy orcamentoProxy;

    @GetMapping
    public ResponseEntity<List<OrcamentoModel>>buscaTodosOrcamentos(){
        return ResponseEntity.ok(orcamentoService.buscarCadastro());
    }
    
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<OrcamentoModel>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(orcamentoProxy.buscaporId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrcamentoModel>cadastraOrcamento(@RequestBody OrcamentoModel orcamentoModel){
        return ResponseEntity.ok(orcamentoService.cadastrarOrcamento(orcamentoModel));
    }

    @PostMapping(path="/put/{id}")
    public ResponseEntity<OrcamentoModel>atualizaOrcamento(@RequestBody OrcamentoModel orcamentoModel, @PathVariable Long id){
        OrcamentoModel orcamentoNewObj= orcamentoService.atualizaCadastro(orcamentoModel, id);
        return ResponseEntity.ok().body(orcamentoNewObj);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteOrcamento(@PathVariable Long id){
        orcamentoService.deletaOrcamento(id);
    }
}
