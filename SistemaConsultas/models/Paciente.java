package models;

public class Paciente extends Pessoa {
    private String historicoMedico;

    public Paciente(String nome, String cpf, String telefone, String historicoMedico) {
        super(nome, cpf, telefone);
        this.historicoMedico = historicoMedico;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return super.toString() + ", Histórico Médico: " + historicoMedico;
    }
}