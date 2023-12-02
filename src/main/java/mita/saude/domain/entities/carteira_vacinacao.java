package mita.saude.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.carteira_vacinacao.DadosCadastroCarteiraVacinacao;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "carteira_vacinacao")
public class carteira_vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carteira_vacina;

    @ManyToOne(targetEntity = carteira_vacinacao.class, fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private List<usuario_crianca> crianca;

    private String vacina_ao_nascer;
    private String vacina_mes_1;
    private String vacina_mes_2;
    private String vacina_mes_4;
    private String vacina_mes_6;
    private String vacina_mes_9;
    private String vacina_mes_12;
    private String vacina_mes_15;

    public carteira_vacinacao(DadosCadastroCarteiraVacinacao dados) {
        this.id_carteira_vacina = dados.id_carteira_vacinacao();
        this.crianca = dados.crianca();
        this.vacina_ao_nascer = dados.vacina_ao_nascer();
        this.vacina_mes_1 = dados.vacina_mes_1();
        this.vacina_mes_2 = dados.vacina_mes_2();
        this.vacina_mes_4 = dados.vacina_mes_4();
        this.vacina_mes_6 = dados.vacina_mes_6();
        this.vacina_mes_9 = dados.vacina_mes_9();
        this.vacina_mes_12 = dados.vacina_mes_12();
        this.vacina_mes_15 = dados.vacina_mes_15();

    }

    public void atualizarInformacoes(@Valid DadosCadastroCarteiraVacinacao dados) {
        if (dados.id_carteira_vacinacao() != null) {
            this.id_carteira_vacina = dados.id_carteira_vacinacao();
        }
        if (dados.crianca() != null) {
            this.crianca = dados.crianca();
        }
        if (dados.vacina_ao_nascer() != null) {
            this.vacina_ao_nascer = dados.vacina_ao_nascer();
        }
        if (dados.vacina_mes_1() != null) {
            this.vacina_mes_1 = dados.vacina_mes_1();
        }
        if (dados.vacina_mes_2() != null) {
            this.vacina_mes_2 = dados.vacina_mes_2();
        }
        if (dados.vacina_mes_4() != null) {
            this.vacina_mes_4 = dados.vacina_mes_4();
        }
        if (dados.vacina_mes_6() != null) {
            this.vacina_mes_6 = dados.vacina_mes_6();
        }
        if (dados.vacina_mes_9() != null) {
            this.vacina_mes_9 = dados.vacina_mes_9();
        }
        if (dados.vacina_mes_12() != null) {
            this.vacina_mes_12 = dados.vacina_mes_12();
        }
        if (dados.vacina_mes_15() != null) {
            this.vacina_mes_15 = dados.vacina_mes_15();
        }
    }
}
