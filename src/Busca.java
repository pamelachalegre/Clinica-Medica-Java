/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auxiliar;
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
            System.out.println("PACIENTE NÃO ENCONTRADO!");
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
            System.out.println("MÉDICO NÃO ENCONTRADO!");
            return -1;
        }
    }
    
    public int acharConsulta(ArrayList<Consulta> listaConsultas, String id) {
        int i = 0;
        while((i < listaConsultas.size())&&(!id.equals(listaConsultas.get(i).getId()))){
            i++;
        }
        if(i < listaConsultas.size()) {
            return i; //retorna a posição do médico correto na lista.
        } else {
            System.out.println("CONSULTA NÃO ENCONTRADA!");
            return -1;
        }
    }
    
    public int acharConsulta(ArrayList<Consulta> listaConsultas, Paciente paciente) {
        int i = 0;
        while((i < listaConsultas.size())&&(paciente != listaConsultas.get(i).getPaciente())){
            i++;
        }
        if(i < listaConsultas.size()) {
            return i; //retorna a posição do médico correto na lista.
        } else {
            System.out.println("CONSULTA NÃO ENCONTRADA!");
            return -1;
        }
    }
    
}
