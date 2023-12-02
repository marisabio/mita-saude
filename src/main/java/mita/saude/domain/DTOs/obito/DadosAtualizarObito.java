package mita.saude.domain.DTOs.obito;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mita.saude.domain.entities.usuario_crianca;

import java.util.Date;
import java.util.List;

public record DadosAtualizarObito(

        @NotNull
        Long id_obito,
        @Valid
        List<usuario_crianca> crianca,
        String causa_obito,
        String local_obito,
        Date data_obito,
        double hora_obito
) {
}
