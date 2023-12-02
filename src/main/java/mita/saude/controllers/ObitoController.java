package mita.saude.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mita.saude.domain.DTOs.obito.DadosCadastroObito;
import mita.saude.domain.DTOs.obito.DadosListagemObito;
import mita.saude.domain.DTOs.obito.RepositoryObito;
import mita.saude.domain.entities.obito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/obito")
@Tag(name = "Óbito", description = "CRUD de óbito.")
public class ObitoController {

    @Autowired
    private RepositoryObito repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de óbito", description = "Endpoint do cadastro de novos óbitos.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroObito dados, UriComponentsBuilder uriBuilder) {
        var obito_crianca = new obito(dados);
        repository.save(obito_crianca);
        var uri = uriBuilder.path("/obito/{id_obito}").buildAndExpand(obito_crianca.getId_obito()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemObito(obito_crianca));
    }

    @GetMapping
    @Operation(summary = "Listagem de óbito", description = "Endpoint da listagem de óbitos cadastrados.")
    public ResponseEntity<Page<DadosListagemObito>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemObito::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id_obito}")
    @Operation(summary = "Exibir óbito", description = "Endpoint da exibição de um único óbito cadastrado.")
    public ResponseEntity exibir(@PathVariable Long obito) {
        var obito_crianca = repository.getReferenceById(obito);
        return ResponseEntity.ok(new DadosListagemObito(obito_crianca));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar óbito", description = "Endpoint da atualização de um único óbito cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroObito dados) {
        var obito_crianca = repository.getReferenceById(dados.id_obito());
        obito_crianca.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemObito(obito_crianca));
    }

    @DeleteMapping("/{id_obito}")
    @Transactional
    @Operation(summary = "Excluir óbito", description = "Endpoint da exclusão de um único óbito cadastrado.")
    public ResponseEntity excluir(@PathVariable Long obito) {
        repository.deleteById(obito);
        return ResponseEntity.ok().body("Óbito " + obito  + " deletado.");
    }
}
