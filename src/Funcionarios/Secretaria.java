package Funcionarios;
import Dados.Paciente;
import Dados.Consulta;
import java.util.ArrayList;

public class Secretaria {
    private String nome;
    private ArrayList<Paciente> pacientes;
    /* ver se dá pra tirar as listas de pacientes e consultas daqui, 
    já que elas são criadas somente na main */
    private ArrayList<Consulta> consultas;
    
    public Secretaria() {  
    }
    
    public void cadastrarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
    
    public void cadastrarPaciente(Paciente paciente, ArrayList<Paciente> listaPacientes) {
        listaPacientes.add(paciente);
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
