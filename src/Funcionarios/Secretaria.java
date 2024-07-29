package Funcionarios;
import Dados.Paciente;
import Dados.Consulta;
import Geradores.GerenciadorMensagens;
import java.util.ArrayList;

public class Secretaria {
    /**
     * Objeto identificado pelo atributo nome com métodos que manipulam outros objetos, como 
     */
    private String nome;
    
    //CONSTRUTOR -> DEFINE A CARACTERÍSTICA.
    public Secretaria(String nome) {
        this.nome = nome;
    }
    
    public void cadastrarConsulta(ArrayList<Consulta> listaConsultas, String data, String horario, Medico medico, Paciente paciente, char tipo) {
        //ADICIONA UMA NOVA CONSULTA A LISTA DE CONSULTAS
        Consulta consulta = new Consulta(data, horario, medico, paciente, tipo);
        listaConsultas.add(consulta);
    }
    
    public void cadastrarPaciente(Paciente paciente, String endereco, String telefone, String email, boolean convenio, ArrayList<Paciente> listaPacientes) {
        //ADICIONA O PACIENTE NA LISTA DE PACIENTES
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setConvenio(convenio);
        listaPacientes.add(paciente);
    }
    
    //MODIFICA OS DADOS DE UM PACIENTE 'paciente':
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

    public void removerPaciente(Paciente paciente, ArrayList<Paciente> listaPacientes) {
        //RETIRA O PACIENTE DA LISTA DE PACIENTES
        listaPacientes.remove(paciente);
    }   
    
    public void gerenciarMensagens(ArrayList<Consulta> listaConsultas) {
        GerenciadorMensagens enviar = new GerenciadorMensagens();
        enviar.enviarMensagem(listaConsultas);
    }
}