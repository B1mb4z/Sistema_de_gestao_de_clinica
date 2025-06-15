import services.SistemaConsulta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaConsulta sistema = new SistemaConsulta();
        Scanner scanner = new Scanner(System.in);
        
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Sistema de Gestão de Clínicas ===");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Listar Médicos");
            System.out.println("6. Listar Consultas");
            System.out.println("7. Salvar Dados");
            System.out.println("8. Carregar Dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    sistema.cadastrarPaciente(scanner);
                    break;
                case 2:
                    sistema.cadastrarMedico(scanner);
                    break;
                case 3:
                    sistema.agendarConsulta(scanner);
                    break;
                case 4:
                    sistema.listarPacientes();
                    break;
                case 5:
                    sistema.listarMedicos();
                    break;
                case 6:
                    sistema.listarConsultas();
                    break;
                case 7:
                    sistema.salvarDados();
                    break;
                case 8:
                    sistema.carregarDados();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}