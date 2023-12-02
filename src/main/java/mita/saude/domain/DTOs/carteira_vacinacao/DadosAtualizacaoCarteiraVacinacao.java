package mita.saude.domain.DTOs.carteira_vacinacao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mita.saude.domain.entities.usuario_crianca;

import java.util.List;

public record DadosAtualizacaoCarteiraVacinacao(
        @NotNull
        Long id_carteira_vacinacao,
        @Valid
        List<usuario_crianca> crianca,
        String vacina_ao_nascer,
        String vacina_mes_1,
        String vacina_mes_2,
        String vacina_mes_4,
        String vacina_mes_6,
        String vacina_mes_9,
        String vacina_mes_12,
        String vacina_mes_15) {
}
