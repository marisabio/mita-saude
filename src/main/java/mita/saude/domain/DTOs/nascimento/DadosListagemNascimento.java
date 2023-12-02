package mita.saude.domain.DTOs.nascimento;

import mita.saude.domain.entities.usuario_crianca;
import mita.saude.domain.entities.usuario_medico;
import mita.saude.domain.entities.nascimento;

import java.util.Date;
import java.util.List;

public record DadosListagemNascimento(
        Long id_nascimento,
        List<usuario_crianca> crianca,
        List<usuario_medico> medicos,
        double peso_nascimento,
        double altura_nascimento,
        Date data_nascimento,
        double hora_nascimento,
        String local_nascimento) {
    public DadosListagemNascimento(nascimento nascimento) {
        this(nascimento.getId_nascimeto(), nascimento.getCrianca(), nascimento.getMedico(), nascimento.getPeso_nascimento(), nascimento.getAltura_nascimento(), nascimento.getData_nascimento(), nascimento.getHora_nascimento(), nascimento.getLocal_nascimento());
    }


}
