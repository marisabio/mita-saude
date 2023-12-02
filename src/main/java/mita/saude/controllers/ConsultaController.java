package mita.saude.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import mita.saude.domain.DTOs.consulta.DadosAtualizacaoConsulta;
import mita.saude.domain.DTOs.consulta.DadosCadastroConsulta;
import mita.saude.domain.DTOs.consulta.DadosListagemConsulta;
import mita.saude.domain.DTOs.consulta.RepositoryConsulta;
import mita.saude.domain.entities.consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consulta")
@Tag(name = "Consulta", description = "CRUD de consulta.")
public class ConsultaController {

    @Autowired
    private RepositoryConsulta repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de consulta", description = "Endpoint do cadastro de novas consultas.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConsulta dados, UriComponentsBuilder uriBuilder) {
        var consulta = new consulta(dados);
        repository.save(consulta);
        var uri = uriBuilder.path("/consulta/{id_consulta}").buildAndExpand(consulta.getId_consulta()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemConsulta(consulta));
    }

    @GetMapping
    @Operation(summary = "Listagem de nascimentos", description = "Endpoint da listagem de consultas cadastradas.")
    public ResponseEntity<Page<DadosListagemConsulta>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemConsulta::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id_consulta}")
    @Operation(summary = "Exibir consulta", description = "Endpoint da exibição de uma única consulta cadastrada.")
    public ResponseEntity exibir(@PathVariable Long consulta) {
        var consulta_crianca = repository.getReferenceById(consulta);
        return ResponseEntity.ok(new DadosListagemConsulta(consulta_crianca));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar consulta", description = "Endpoint da atualização de uma única consulta cadastrada.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConsulta dados) {
        var consulta = repository.getReferenceById(dados.id_consulta());
        consulta.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemConsulta(consulta));
    }

    @DeleteMapping("/{id_consulta}")
    @Transactional
    @Operation(summary = "Excluir consulta", description = "Endpoint da exclusão de uma única consulta cadastrada.")
    public ResponseEntity excluir(@PathVariable Long consulta) {
        repository.deleteById(consulta);
        return ResponseEntity.ok().body("consulta " + consulta + " deletado.");
    }
}
