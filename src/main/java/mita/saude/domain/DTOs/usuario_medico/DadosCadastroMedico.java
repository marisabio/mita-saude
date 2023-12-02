package mita.saude.domain.DTOs.usuario_medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMedico (
        @NotBlank
        long crm_medico,
        @NotBlank
        String nome_medico,
        @NotBlank
        String senha_medico,
        @NotBlank
        @Email
        String email_medico,
        @NotBlank
        String telefone_medico
){
}
