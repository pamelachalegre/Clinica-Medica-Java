package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Medico dra_Pamela = new Medico();
        Medico dra_Poli = new Medico();
        Medico dr_Guilherme = new Medico();
        
        Paciente p_AnaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true);

        Paciente anaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true);

        ArrayList<Paciente> listaPacientes = new ArrayList();
        
        ArrayList<String> cirurgias = new ArrayList();        
        cirurgias.add("Cirurgia1");
        cirurgias.add("Cirurgia2");
        
        ArrayList<String> alergias = new ArrayList();
        alergias.add("Alergia1");
        alergias.add("Alergia2");
        
        dra_Pamela.cadastrarPaciente(p_AnaPaula, true, false, true, false, false, cirurgias, alergias);
        
        Secretaria sec = new Secretaria();
        
        sec.cadastrarPaciente(p_AnaPaula, listaPacientes);
        
        // mostrar as cirurgias do paciente
        
    }
}
