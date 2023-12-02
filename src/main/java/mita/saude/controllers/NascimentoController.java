package mita.saude.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mita.saude.domain.DTOs.nascimento.DadosCadastroNascimento;
import mita.saude.domain.DTOs.nascimento.DadosListagemNascimento;
import mita.saude.domain.DTOs.nascimento.RepositoryNascimento;
import mita.saude.domain.entities.nascimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/nascimento")
@Tag(name = "Nascimento", description = "CRUD de nascimento.")
public class NascimentoController {

    @Autowired
    private RepositoryNascimento repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de nascimentos", description = "Endpoint do cadastro de novos nascimento.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroNascimento dados, UriComponentsBuilder uriBuilder) {
        var nascimento_crianca = new nascimento(dados);
        repository.save(nascimento_crianca);
        var uri = uriBuilder.path("/nascimento/{nascimento}").buildAndExpand(nascimento_crianca.getId_nascimeto()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemNascimento(nascimento_crianca));
    }

    @GetMapping
    @Operation(summary = "Listagem de nascimentos", description = "Endpoint da listagem de nascimentos cadastrados.")
    public ResponseEntity<Page<DadosListagemNascimento>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemNascimento::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{nascimento}")
    @Operation(summary = "Exibir nascimento", description = "Endpoint da exibição de um único nascimento cadastrado.")
    public ResponseEntity exibir(@PathVariable Long nascimento) {
        var nascimento_crianca = repository.getReferenceById(nascimento);
        return ResponseEntity.ok(new DadosListagemNascimento(nascimento_crianca));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar nascimento", description = "Endpoint da atualização de um único nascimento cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroNascimento dados) {
        var nascimento_crianca = repository.getReferenceById(dados.id_nascimento());
        nascimento_crianca.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemNascimento(nascimento_crianca));
    }

    @DeleteMapping("/{nascimento}")
    @Transactional
    @Operation(summary = "Excluir nascimento", description = "Endpoint da exclusão de um único nascimento cadastrado.")
    public ResponseEntity excluir(@PathVariable Long nascimento) {
        repository.deleteById(nascimento);
        return ResponseEntity.ok().body("nascimento " + nascimento + " deletado.");
    }

}
