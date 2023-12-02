package mita.saude.domain.DTOs.usuario_crianca;


import mita.saude.domain.entities.usuario_crianca;

public record DadosListagemCrianca(
        Long cpf_crian,
        String nome_crian,
        String condicoes_preexistentes_crian,
        String comunidade_crian,
        String etinia_crian) {

    public DadosListagemCrianca(usuario_crianca crianca) {
        this(crianca.getCpf_crian(), crianca.getNome_crian(), crianca.getCondicoes_preexistentes_crian(), crianca.getComunidade_crian(), crianca.getEtinia_crian());
    }
}
