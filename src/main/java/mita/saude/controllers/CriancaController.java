package mita.saude.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mita.saude.domain.DTOs.usuario_crianca.DadosAtualizacaoCrianca;
import mita.saude.domain.DTOs.usuario_crianca.DadosCadastroCrianca;
import mita.saude.domain.DTOs.usuario_crianca.DadosListagemCrianca;
import mita.saude.domain.DTOs.usuario_crianca.RepositoryUsuarioCrianca;
import mita.saude.domain.entities.usuario_crianca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/criancas")
@Tag(name = "Criança", description = "CRUD da criança.")
public class CriancaController {

    @Autowired
    private RepositoryUsuarioCrianca repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de criança", description = "Endpoint do cadastro de novas criancas.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCrianca dados, UriComponentsBuilder uriBuilder) {
        var crianca = new usuario_crianca(dados);
        repository.save(crianca);
        var uri = uriBuilder.path("/criancas/{usuario_crianca}").buildAndExpand(crianca.getCpf_crian()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCrianca(crianca));
    }

    @GetMapping
    @Operation(summary = "Listagem de crianças", description = "Endpoint da listagem de crianças cadastradas.")
    public ResponseEntity<Page<DadosListagemCrianca>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemCrianca::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{usuario_crianca}")
    @Operation(summary = "Exibir criança", description = "Endpoint da exibição de uma única criança cadastrada.")
    public ResponseEntity exibir(@PathVariable Long usuario_crianca) {
        var crianca = repository.getReferenceById(usuario_crianca);
        return ResponseEntity.ok(new DadosListagemCrianca(crianca));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar criança", description = "Endpoint da atualização de uma única criança cadastrada.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCrianca dados) {
        var crianca = repository.getReferenceById(dados.cpf_crian());
        crianca.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCrianca(crianca));
    }

    @DeleteMapping("/{usuario_crianca}")
    @Transactional
    @Operation(summary = "Excluir criança", description = "Endpoint da exclusão de uma única criança cadastrada.")
    public ResponseEntity excluir(@PathVariable Long usuario_crianca) {
        repository.deleteById(usuario_crianca);
        return ResponseEntity.ok().body("Criança " + usuario_crianca + " deletada.");
    }
}
