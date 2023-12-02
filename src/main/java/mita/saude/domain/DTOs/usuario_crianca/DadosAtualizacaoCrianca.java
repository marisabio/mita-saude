package mita.saude.domain.DTOs.usuario_crianca;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCrianca(
        @NotNull
        Long cpf_crian,
        String nome_crian,
        String condicoes_preexistentes_crian,
        String comunidade_crian,
        String etinia_crian) {
}
