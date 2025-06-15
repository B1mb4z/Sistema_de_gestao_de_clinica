package models;

import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String descricao;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String descricao) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                ", dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}