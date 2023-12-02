package mita.saude.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mita.saude.domain.DTOs.carteira_vacinacao.DadosCadastroCarteiraVacinacao;
import mita.saude.domain.DTOs.carteira_vacinacao.DadosListagemCarteiraVacinacao;
import mita.saude.domain.DTOs.carteira_vacinacao.RepositoryCarteiraVacinacao;
import mita.saude.domain.entities.carteira_vacinacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/carteira_vacinacao")
@Tag(name = "Carteira de vacinação",description = "CRUD de carteira de vacinação.")
public class CarteiraVacinacaoController {

    @Autowired
    private RepositoryCarteiraVacinacao repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de carteira de vacinação", description = "Endpoint do cadastro de novas carteiras vacinação.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCarteiraVacinacao dados, UriComponentsBuilder uriBuilder) {
        var carteiraVacinacao = new carteira_vacinacao(dados);
        repository.save(carteiraVacinacao);
        var uri = uriBuilder.path("/carteira_vacinacao/{id_carteira_vacina}").buildAndExpand(carteiraVacinacao.getId_carteira_vacina()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @GetMapping
    @Operation(summary = "Listagem de carteira de vacinação", description = "Endpoint da listagem de carteiras de vacinação.")
    public ResponseEntity<Page<DadosListagemCarteiraVacinacao>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemCarteiraVacinacao::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id_carteira_vacina}")
    @Operation(summary = "Exibir carteira de vacinação", description = "Endpoint da exibição de uma única carteira de vacinação cadastrada.")
    public ResponseEntity exibir(@PathVariable Long carteira_vacinacao) {
        var carteiraVacinacao = repository.getReferenceById(carteira_vacinacao);
        return ResponseEntity.ok(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar carteira de vacinação", description = "Endpoint da atualização de uma única carteira de vacinação cadastrada.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroCarteiraVacinacao dados) {
        var carteiraVacinacao = repository.getReferenceById(dados.id_carteira_vacinacao());
        carteiraVacinacao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @DeleteMapping("/{id_carteira_vacina}")
    @Transactional
    @Operation(summary = "Excluir carteira de vacinação", description = "Endpoint da exclusão de uma única carteira de vacinação cadastrada.")
    public ResponseEntity excluir(@PathVariable Long carteira_vacinacao) {
        repository.deleteById(carteira_vacinacao);
        return ResponseEntity.ok().body("carteira_vacinacao " + carteira_vacinacao + " deletada.");
    }
}
