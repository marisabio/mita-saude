package mita.saude.domain.DTOs.carteira_vacinacao;

import jakarta.validation.Valid;
import mita.saude.domain.entities.carteira_vacinacao;
import mita.saude.domain.entities.usuario_crianca;

import java.util.List;

public record DadosListagemCarteiraVacinacao(
        Long id_carteira_vacinacao,
        List<usuario_crianca> crianca,
        String vacina_ao_nascer,
        String vacina_mes_1,
        String vacina_mes_2,
        String vacina_mes_4,
        String vacina_mes_6,
        String vacina_mes_9,
        String vacina_mes_12,
        String vacina_mes_15) {
    public DadosListagemCarteiraVacinacao(carteira_vacinacao carteira_vacinacao) {
        this(carteira_vacinacao.getId_carteira_vacina(), carteira_vacinacao.getCrianca(), carteira_vacinacao.getVacina_ao_nascer(), carteira_vacinacao.getVacina_mes_1(),
                carteira_vacinacao.getVacina_mes_2(), carteira_vacinacao.getVacina_mes_4(), carteira_vacinacao.getVacina_mes_6(), carteira_vacinacao.getVacina_mes_9(),
                carteira_vacinacao.getVacina_mes_12(), carteira_vacinacao.getVacina_mes_15());
    }
}
