package mita.saude.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.usuario_crianca.DadosAtualizacaoCrianca;
import mita.saude.domain.DTOs.usuario_crianca.DadosCadastroCrianca;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario_crianca")
public class usuario_crianca {

    @Id
    private Long cpf_crian;

    private String nome_crian;
    private String condicoes_preexistentes_crian;
    private String comunidade_crian;
    private String etinia_crian;

    public usuario_crianca(DadosCadastroCrianca dados) {
        this.cpf_crian = dados.cpf_crian();
        this.nome_crian = dados.nome_crian();
        this.condicoes_preexistentes_crian = dados.condicoes_preexistentes_crian();
        this.comunidade_crian = dados.comunidade_crian();
        this.etinia_crian = dados.etinia_crian();
    }

    public void atualizarInformacoes(DadosAtualizacaoCrianca dados) {
        if (dados.cpf_crian() != null) {
            this.cpf_crian = dados.cpf_crian();
        }
        if (dados.nome_crian() != null) {
            this.nome_crian = dados.nome_crian();
        }
        if (dados.condicoes_preexistentes_crian() != null) {
            this.condicoes_preexistentes_crian = dados.condicoes_preexistentes_crian();
        }
        if (dados.comunidade_crian() != null) {
            this.comunidade_crian = dados.comunidade_crian();
        }
        if (dados.etinia_crian() != null) {
            this.etinia_crian = dados.etinia_crian();
        }
    }
}
