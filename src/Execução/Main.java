package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Medico dra_Pamela = new Medico("Pamela", "12893");
        Medico dra_Poli = new Medico("Poli", "29921");

        ArrayList<Paciente> listaPacientes = new ArrayList();
        
        Paciente p_AnaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");
        Paciente p_Carol = new Paciente("Caroline", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");

        ArrayList<String> alergias = new ArrayList();
        alergias.add("Alergia1");
        alergias.add("Alergia2");
        ArrayList<String> cirurgias = new ArrayList();
        
        dra_Pamela.cadastrarDadosPaciente(p_AnaPaula, true, false, true, false, false, cirurgias, alergias);
        
        Secretaria sec = new Secretaria("Silvia");
        
        sec.cadastrarPaciente(p_AnaPaula, "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true, listaPacientes); //indice 0
        sec.cadastrarPaciente(p_Carol, "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true, listaPacientes);//indice 1
        
        System.out.println(listaPacientes.get(0).isBeber());
        System.out.println(listaPacientes.get(1).isBeber());
        
        dra_Poli.atualizaPacienteBebe(p_AnaPaula, false);
        dra_Poli.atualizaPacienteBebe(p_Carol, true);
        
        System.out.println(listaPacientes.get(0).isBeber());
        System.out.println(listaPacientes.get(1).isBeber());
        
        //Comentário da Poli: FUNCIONOU!!! ALTERA DENTRO DA LISTA TBM!!!
        
    }
}