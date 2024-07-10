/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionarios;
import Dados.Paciente;
import Dados.Consulta;
/**
 *
 * @author home
 */
public class Secretaria {
    private String nome;
    //LISTA DE PACIENTES
    private Paciente paciente;
    private Consulta consulta;
    
    public Secretaria() {  
    }
    
    public void cadastrarConsulta(Paciente paciente) {
        this.consulta.setPaciente(paciente);
    }
    
    public void cadastrarPaciente(Paciente paciente) {
        this.paciente = paciente; //LISTA DE PACIENTES + PACIENTE
    }
    
    public void atualizaPacienteNome(Paciente paciente, String nome) {
        paciente.setNome(nome);
    }
    
    public void atualizaPacienteSexo(Paciente paciente, char sexo) {
        paciente.setSexo(sexo);
    }
    
    public void atualizaPacienteIdade(Paciente paciente, int idade) {
        paciente.setIdade(idade);
    }
    
    public void atualizaPacienteEndereco(Paciente paciente, String endereco) {
        paciente.setEndereco(endereco);
    }
    
    public void atualizaPacienteTelefone(Paciente paciente, String telefone) {
        paciente.setTelefone(telefone);
    }
    
    public void atualizaPacienteEmail(Paciente paciente, String email) {
        paciente.setEmail(email);
    }
    
    public void atualizaPacienteConvenio(Paciente paciente, boolean conve) {
        paciente.setConvenio(conve);
    }
    
    public void removerPaciente(Paciente paciente) {
     //LISTA DE PACIENTES - PACIENTE   
    }
    
}
