/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Execução;
import Dados.Paciente;
import Dados.Consulta;
import Funcionarios.Medico;
import java.util.ArrayList;
/**
 *
 * @author home
 */
public class Busca {
    public int acharCPF(String cpf, ArrayList<Paciente> listaPacientes) {
        int i = 0;
        while((i < listaPacientes.size())&&(!cpf.equals(listaPacientes.get(i).getCpf()))){
            i++;
        }
        if(i < listaPacientes.size()) {
            return i;
        } else {
            System.out.println("Paciente não encontrado!");
            return -1;
        }
    }
    
    public int acharCRM(String crm, ArrayList<Medico> listaMedicos) {
        int i = 0;
        while((i < listaMedicos.size())&&(!crm.equals(listaMedicos.get(i).getCrm()))){
            i++;
        }
        if(i < listaMedicos.size()) {
            return i; //retorna a posição do médico correto na lista.
        } else {
            System.out.println("Médico não encontrado!");
            return -1;
        }
    }
    
    public int acharConsulta() {
        return 0;
    }
}
