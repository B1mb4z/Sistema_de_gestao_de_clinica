package storage;

import models.*;
import java.io.*;
import java.util.List;

public class FicheiroUtils {
    private static final String ARQUIVO_DADOS = "dados_clinica.dat";

    public static void salvarDados(List<Paciente> pacientes, List<Medico> medicos, List<Consulta> consultas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            Object[] dados = new Object[]{pacientes, medicos, consultas};
            oos.writeObject(dados);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static Object[] carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_DADOS))) {
            return (Object[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de dados não encontrado. Será criado um novo ao salvar.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}