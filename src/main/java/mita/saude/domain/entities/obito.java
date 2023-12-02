package mita.saude.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mita.saude.domain.DTOs.obito.DadosCadastroObito;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "obito")
public class obito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_obito;

    @ManyToOne(targetEntity = obito.class, fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private List<usuario_crianca> crianca;

    private String causa_obito;
    private String local_obito;
    private Date data_obito;
    private double hora_obito;

    public obito(DadosCadastroObito dados) {
        this.id_obito = dados.id_obito();
        this.crianca = dados.crianca();
        this.causa_obito = dados.causa_obito();
        this.local_obito = dados.local_obito();
        this.data_obito = dados.data_obito();
        this.hora_obito = dados.hora_obito();
    }

    public void atualizarInformacoes(@Valid DadosCadastroObito dados) {
        if (dados.id_obito() != null) {
            this.id_obito = dados.id_obito();
        }
        if (dados.crianca() != null) {
            this.crianca = dados.crianca();
        }
        if (dados.causa_obito() != null) {
            this.causa_obito = dados.causa_obito();
        }
        if (dados.local_obito() != null) {
            this.local_obito = dados.local_obito();
        }
        if (dados.data_obito() != null) {
            this.data_obito = dados.data_obito();
        }
        if (dados.hora_obito() != 0) {
            this.hora_obito = dados.hora_obito();
        }
    }
}
