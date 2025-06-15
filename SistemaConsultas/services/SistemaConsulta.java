package services;

import models.*;
import storage.FicheiroUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaConsulta {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public SistemaConsulta() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public void cadastrarPaciente(Scanner scanner) {
        System.out.println("\n=== Cadastro de Paciente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Histórico Médico: ");
        String historico = scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, telefone, historico);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void cadastrarMedico(Scanner scanner) {
        System.out.println("\n=== Cadastro de Médico ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();

        Medico medico = new Medico(nome, cpf, telefone, especialidade, crm);
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    public void agendarConsulta(Scanner scanner) {
        if (pacientes.isEmpty() || medicos.isEmpty()) {
            System.out.println("É necessário ter pelo menos um paciente e um médico cadastrado!");
            return;
        }

        System.out.println("\n=== Agendar Consulta ===");
        System.out.println("Pacientes:");
        listarPacientes();
        System.out.print("Escolha o número do paciente: ");
        int pacienteIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Médicos:");
        listarMedicos();
        System.out.print("Escolha o número do médico: ");
        int medicoIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data e Hora (dd/MM/yyyy HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Consulta consulta = new Consulta(
            pacientes.get(pacienteIndex - 1),
            medicos.get(medicoIndex - 1),
            dataHora,
            descricao
        );
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    public void listarPacientes() {
        System.out.println("\n=== Lista de Pacientes ===");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + ". " + pacientes.get(i));
            }
        }
    }

    public void listarMedicos() {
        System.out.println("\n=== Lista de Médicos ===");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println((i + 1) + ". " + medicos.get(i));
            }
        }
    }

    public void listarConsultas() {
        System.out.println("\n=== Lista de Consultas ===");
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println(consulta);
            }
        }
    }

    public void salvarDados() {
        FicheiroUtils.salvarDados(pacientes, medicos, consultas);
        System.out.println("Dados salvos com sucesso!");
    }

    public void carregarDados() {
        Object[] dados = FicheiroUtils.carregarDados();
        if (dados != null) {
            pacientes = (List<Paciente>) dados[0];
            medicos = (List<Medico>) dados[1];
            consultas = (List<Consulta>) dados[2];
            System.out.println("Dados carregados com sucesso!");
        } else {
            System.out.println("Nenhum dado encontrado para carregar.");
        }
    }
}