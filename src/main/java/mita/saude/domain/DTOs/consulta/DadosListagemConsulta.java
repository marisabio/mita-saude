package mita.saude.domain.DTOs.consulta;

import mita.saude.domain.entities.consulta;
import mita.saude.domain.entities.usuario_crianca;
import mita.saude.domain.entities.usuario_medico;

import java.util.List;

public record DadosListagemConsulta(
        Long id_consulta,
        List<usuario_crianca> crianca,
        List<usuario_medico> medico,
        String mes_1_consulta,
        String mes_2_consulta,
        String mes_3_consulta,
        String mes_4_consulta,
        String mes_5_consulta,
        String mes_6_consulta,
        String mes_7_consulta,
        String mes_8_consulta,
        String mes_9_consulta,
        String mes_10_consulta,
        String mes_11_consulta,
        String mes_12_consulta,
        String mes_13_consulta,
        String mes_14_consulta,
        String mes_15_consulta,
        String mes_16_consulta,
        String mes_17_consulta,
        String mes_18_consulta,
        String mes_19_consulta,
        String mes_20_consulta,
        String mes_21_consulta,
        String mes_22_consulta,
        String mes_23_consulta,
        String mes_24_consulta) {

    public DadosListagemConsulta(consulta consulta) {
        this(consulta.getId_consulta(), consulta.getCrianca(), consulta.getMedico(), consulta.getMes_1_consulta(), consulta.getMes_2_consulta(),
                consulta.getMes_3_consulta(), consulta.getMes_4_consulta(), consulta.getMes_5_consulta(), consulta.getMes_6_consulta(),
                consulta.getMes_7_consulta(), consulta.getMes_8_consulta(), consulta.getMes_9_consulta(), consulta.getMes_10_consulta(),
                consulta.getMes_11_consulta(), consulta.getMes_12_consulta(), consulta.getMes_13_consulta(), consulta.getMes_14_consulta(),
                consulta.getMes_15_consulta(), consulta.getMes_16_consulta(), consulta.getMes_17_consulta(), consulta.getMes_18_consulta(),
                consulta.getMes_19_consulta(), consulta.getMes_20_consulta(), consulta.getMes_21_consulta(), consulta.getMes_22_consulta(),
                consulta.getMes_23_consulta(), consulta.getMes_24_consulta());
        }
    }
