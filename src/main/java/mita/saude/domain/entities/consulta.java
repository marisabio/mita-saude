package mita.saude.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.consulta.DadosAtualizacaoConsulta;
import mita.saude.domain.DTOs.consulta.DadosCadastroConsulta;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "consulta")
public class consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_consulta;

    @ManyToOne(targetEntity = usuario_crianca.class, fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private List<usuario_crianca> crianca;

    @ManyToOne(targetEntity = usuario_medico.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "crm_medico")
    private List<usuario_medico> medico;

    private String mes_1_consulta;
    private String mes_2_consulta;
    private String mes_3_consulta;
    private String mes_4_consulta;
    private String mes_5_consulta;
    private String mes_6_consulta;
    private String mes_7_consulta;
    private String mes_8_consulta;
    private String mes_9_consulta;
    private String mes_10_consulta;
    private String mes_11_consulta;
    private String mes_12_consulta;
    private String mes_13_consulta;
    private String mes_14_consulta;
    private String mes_15_consulta;
    private String mes_16_consulta;
    private String mes_17_consulta;
    private String mes_18_consulta;
    private String mes_19_consulta;
    private String mes_20_consulta;
    private String mes_21_consulta;
    private String mes_22_consulta;
    private String mes_23_consulta;
    private String mes_24_consulta;

    public consulta(DadosCadastroConsulta dados) {
        this.id_consulta = dados.id_consulta();
        this.crianca = dados.crianca();
        this.medico = dados.medico();
        this.mes_1_consulta = dados.mes_1_consulta();
        this.mes_2_consulta = dados.mes_2_consulta();
        this.mes_3_consulta = dados.mes_3_consulta();
        this.mes_4_consulta = dados.mes_4_consulta();
        this.mes_5_consulta = dados.mes_5_consulta();
        this.mes_6_consulta = dados.mes_6_consulta();
        this.mes_7_consulta = dados.mes_7_consulta();
        this.mes_8_consulta = dados.mes_8_consulta();
        this.mes_9_consulta = dados.mes_9_consulta();
        this.mes_10_consulta = dados.mes_10_consulta();
        this.mes_11_consulta = dados.mes_11_consulta();
        this.mes_12_consulta = dados.mes_12_consulta();
        this.mes_13_consulta = dados.mes_13_consulta();
        this.mes_14_consulta = dados.mes_14_consulta();
        this.mes_15_consulta = dados.mes_15_consulta();
        this.mes_16_consulta = dados.mes_16_consulta();
        this.mes_17_consulta = dados.mes_17_consulta();
        this.mes_18_consulta = dados.mes_18_consulta();
        this.mes_19_consulta = dados.mes_19_consulta();
        this.mes_20_consulta = dados.mes_20_consulta();
        this.mes_21_consulta = dados.mes_21_consulta();
        this.mes_22_consulta = dados.mes_22_consulta();
        this.mes_23_consulta = dados.mes_23_consulta();
        this.mes_24_consulta = dados.mes_24_consulta();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoConsulta dados) {
        if (dados.id_consulta() != null) {
            this.id_consulta = dados.id_consulta();
        }
        if (dados.crianca() != null) {
            this.crianca = dados.crianca();
        }
        if (dados.medico() != null) {
            this.medico = dados.medico();
        }
        if (dados.mes_1_consulta() != null) {
            this.mes_1_consulta = dados.mes_1_consulta();
        }
        if (dados.mes_2_consulta() != null) {
            this.mes_2_consulta = dados.mes_2_consulta();
        }
        if (dados.mes_3_consulta() != null) {
            this.mes_3_consulta = dados.mes_3_consulta();
        }
        if (dados.mes_4_consulta() != null) {
            this.mes_4_consulta = dados.mes_4_consulta();
        }
        if (dados.mes_5_consulta() != null) {
            this.mes_5_consulta = dados.mes_5_consulta();
        }
        if (dados.mes_6_consulta() != null) {
            this.mes_6_consulta = dados.mes_6_consulta();
        }
        if (dados.mes_7_consulta() != null) {
            this.mes_7_consulta = dados.mes_7_consulta();
        }
        if (dados.mes_8_consulta() != null) {
            this.mes_8_consulta = dados.mes_8_consulta();
        }
        if (dados.mes_9_consulta() != null) {
            this.mes_9_consulta = dados.mes_9_consulta();
        }
        if (dados.mes_10_consulta() != null) {
            this.mes_10_consulta = dados.mes_10_consulta();
        }
        if (dados.mes_11_consulta() != null) {
            this.mes_11_consulta = dados.mes_11_consulta();
        }
        if (dados.mes_12_consulta() != null) {
            this.mes_12_consulta = dados.mes_12_consulta();
        }
        if (dados.mes_13_consulta() != null) {
            this.mes_13_consulta = dados.mes_13_consulta();
        }
        if (dados.mes_14_consulta() != null) {
            this.mes_14_consulta = dados.mes_14_consulta();
        }
        if (dados.mes_15_consulta() != null) {
            this.mes_15_consulta = dados.mes_15_consulta();
        }
        if (dados.mes_16_consulta() != null) {
            this.mes_16_consulta = dados.mes_16_consulta();
        }
        if (dados.mes_17_consulta() != null) {
            this.mes_17_consulta = dados.mes_17_consulta();
        }
        if (dados.mes_18_consulta() != null) {
            this.mes_18_consulta = dados.mes_18_consulta();
        }
        if (dados.mes_19_consulta() != null) {
            this.mes_19_consulta = dados.mes_19_consulta();
        }
        if (dados.mes_20_consulta() != null) {
            this.mes_20_consulta = dados.mes_20_consulta();
        }
        if (dados.mes_21_consulta() != null) {
            this.mes_21_consulta = dados.mes_21_consulta();
        }
        if (dados.mes_22_consulta() != null) {
            this.mes_22_consulta = dados.mes_22_consulta();
        }
        if (dados.mes_23_consulta() != null) {
            this.mes_23_consulta = dados.mes_23_consulta();
        }
        if (dados.mes_24_consulta() != null) {
            this.mes_24_consulta = dados.mes_24_consulta();
        }
    }
}
