package mita.saude.domain.DTOs.obito;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import mita.saude.domain.entities.usuario_crianca;

import java.util.Date;
import java.util.List;

public record DadosCadastroObito(
        @NotBlank
        Long id_obito,
        @NotBlank
        @Valid
        List<usuario_crianca> crianca,
        @NotBlank
        String causa_obito,
        @NotBlank
        String local_obito,
        @NotBlank
        Date data_obito,
        @NotBlank
        double hora_obito

) {
}
