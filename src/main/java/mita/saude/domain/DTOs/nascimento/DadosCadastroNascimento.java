package mita.saude.domain.DTOs.nascimento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import mita.saude.domain.entities.usuario_crianca;
import mita.saude.domain.entities.usuario_medico;

import java.util.Date;
import java.util.List;

public record DadosCadastroNascimento(
        @NotBlank
        Long id_nascimento,
        @NotBlank
        @Valid
        List<usuario_crianca> crianca,
        @NotBlank
        @Valid
        List<usuario_medico> medicos,
        @NotBlank
        double peso_nascimento,
        @NotBlank
        double altura_nascimento,
        @NotBlank
        Date data_nascimento,
        @NotBlank
        double hora_nascimento,
        @NotBlank
        boolean teste_pezinho_nascimento,
        @NotBlank
        String local_nascimento
        ) {


}
