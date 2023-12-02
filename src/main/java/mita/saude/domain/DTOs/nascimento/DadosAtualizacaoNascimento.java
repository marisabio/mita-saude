package mita.saude.domain.DTOs.nascimento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mita.saude.domain.entities.usuario_crianca;
import mita.saude.domain.entities.usuario_medico;

import java.util.Date;
import java.util.List;

public record DadosAtualizacaoNascimento(
        @NotNull
        Long id_nascimento,
        @Valid
        List<usuario_crianca> crianca,
        @Valid
        List<usuario_medico> medicos,
        double peso_nascimento,
        double altura_nascimento,
        Date data_nascimento,
        double hora_nascimento,
        boolean teste_pezinho_nascimento,
        String local_nascimento

) {
}
