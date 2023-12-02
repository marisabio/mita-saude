package mita.saude.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.usuario_medico.DadosAtualizacaoMedico;
import mita.saude.domain.DTOs.usuario_medico.DadosCadastroMedico;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario_medico")
public class usuario_medico {

    @Id
    private Long crm_medico;
    private String nome_medico;
    private String senha_medico;
    private String email_medico;
    private String telefone_medico;

    public usuario_medico(DadosCadastroMedico dados) {
        this.crm_medico = dados.crm_medico();
        this.nome_medico = dados.nome_medico();
        this.senha_medico = dados.senha_medico();
        this.email_medico = dados.email_medico();
        this.telefone_medico = dados.telefone_medico();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados){
        if(dados.crm_medico() != null){
            this.crm_medico = dados.crm_medico();
        }
        if(dados.nome_medico() != null){
            this.nome_medico = dados.nome_medico();
        }
        if(dados.senha_medico() != null){
            this.senha_medico = dados.senha_medico();
        }
        if(dados.email_medico() != null){
            this.email_medico = dados.email_medico();
        }
        if(dados.telefone_medico() != null){
            this.telefone_medico = dados.telefone_medico();
        }
    }
}
