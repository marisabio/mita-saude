package mita.saude.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.nascimento.DadosCadastroNascimento;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nascimento")
public class nascimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_nascimeto;

    @ManyToOne(targetEntity = usuario_crianca.class, fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private List<usuario_crianca> crianca;

    @ManyToOne(targetEntity = usuario_medico.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "crm_medico")
    private List<usuario_medico> medico;

    private double peso_nascimento;
    private double altura_nascimento;
    private Date data_nascimento;
    private double hora_nascimento;
    private boolean teste_pezinho_nascimento;
    private String local_nascimento;

    public nascimento(DadosCadastroNascimento dados) {
        this.id_nascimeto = dados.id_nascimento();
        this.crianca = dados.crianca();
        this.medico = dados.medicos();
        this.peso_nascimento = dados.peso_nascimento();
        this.altura_nascimento = dados.altura_nascimento();
        this.data_nascimento = dados.data_nascimento();
        this.hora_nascimento = dados.hora_nascimento();
        this.teste_pezinho_nascimento = dados.teste_pezinho_nascimento();
        this.local_nascimento = dados.local_nascimento();

    }

    public void atualizarInformacoes(@Valid DadosCadastroNascimento dados) {
        if (dados.id_nascimento() != null) {
            this.id_nascimeto = dados.id_nascimento();
        }
        if (dados.crianca() != null) {
            this.crianca = dados.crianca();
        }
        if (dados.medicos() != null) {
            this.medico = dados.medicos();
        }
        if (dados.peso_nascimento() != 0) {
            this.peso_nascimento = dados.peso_nascimento();
        }
        if (dados.altura_nascimento() != 0) {
            this.altura_nascimento = dados.altura_nascimento();
        }
        if (dados.data_nascimento() != null) {
            this.data_nascimento = dados.data_nascimento();
        }
        if (dados.hora_nascimento() != 0) {
            this.hora_nascimento = dados.hora_nascimento();
        }
        if (dados.local_nascimento() != null) {
            this.local_nascimento = dados.local_nascimento();
        }
    }
}
