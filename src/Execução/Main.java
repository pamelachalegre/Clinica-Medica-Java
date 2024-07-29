package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import Dados.Consulta;
import Geradores.GerenciadorMensagens;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Medico dra_Pamela = new Medico("Pamela", "12893");
        Medico dra_Poli = new Medico("Poli", "29921");
        Paciente p_AnaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");
        Paciente p_Carol = new Paciente("Caroline", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");
        Secretaria sec = new Secretaria("Silvia");
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        ArrayList<String> alergias = new ArrayList<String>();
        ArrayList<String> cirurgias = new ArrayList<String>();
        
        alergias.add("Alergia1");
        alergias.add("Alergia2");
        
        dra_Pamela.cadastrarDadosPaciente(p_AnaPaula, true, false, true, false, false, cirurgias, alergias);
        
        sec.cadastrarPaciente(p_AnaPaula, "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true, listaPacientes); //indice 0
        sec.cadastrarPaciente(p_Carol, "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true, listaPacientes);//indice 1
        
        sec.cadastrarConsulta(listaConsultas, "14/09/2023", "15h00", dra_Poli, p_Carol, 'N');
        
        System.out.println(listaConsultas.get(0).getData());
        
        sec.gerenciarMensagens(listaConsultas);
        
        dra_Pamela.criarReceita(dra_Pamela, p_Carol, "paracetamol", (float) 1.5, "oral", 5);
    }
}