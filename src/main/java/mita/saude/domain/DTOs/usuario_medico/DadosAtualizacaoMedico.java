package mita.saude.domain.DTOs.usuario_medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico (
    @NotNull
    Long crm_medico,
    String nome_medico,
    String senha_medico,
    @Email
    String email_medico,
    String telefone_medico) {
}
