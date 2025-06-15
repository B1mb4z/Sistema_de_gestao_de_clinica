package models;

public class Medico extends Pessoa {
    private String especialidade;
    private String crm;

    public Medico(String nome, String cpf, String telefone, String especialidade, String crm) {
        super(nome, cpf, telefone);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidade: " + especialidade + ", CRM: " + crm;
    }
}