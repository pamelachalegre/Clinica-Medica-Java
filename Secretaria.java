package Funcionarios;
import Dados.Paciente;
import Dados.Consulta;
import GerenciadorMensagens.GerenciadorMensagens;
import java.util.ArrayList;

public class Secretaria {
    /**
     * Objeto identificado pelo atributo nome com métodos que manipulam outros objetos, como 
     */
    private String nome;

    public String getNome() {
        return nome;
    }
    
    //CONSTRUTOR -> DEFINE A CARACTERÍSTICA.
    public Secretaria(String nome) {
        this.nome = nome;
    }
    
    public void cadastrarConsulta(ArrayList<Consulta> listaConsultas, String data, String horario, Medico medico, Paciente paciente, char tipo) {
        //ADICIONA UMA NOVA CONSULTA A LISTA DE CONSULTAS
        Consulta consulta = new Consulta(data, horario, medico, paciente, tipo);
        listaConsultas.add(consulta);
    }
    
    public void cadastrarPaciente(String nome, String cpf, String rg, String sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio, ArrayList<Paciente> listaPacientes) {
        //CRIA UM PACIENTE E O ADICIONA NA LISTA DE PACIENTES
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio);
        listaPacientes.add(paciente);
    }
    
    //MODIFICA OS DADOS DE UM PACIENTE 'paciente':
    public void atualizarPacienteNome(Paciente paciente, String nome) {
        paciente.setNome(nome);
    }
    public void atualizarPacienteSexo(Paciente paciente, String sexo) {
        paciente.setSexo(sexo);
    }
    public void atualizarPacienteIdade(Paciente paciente, int idade) {
        paciente.setIdade(idade);
    }
    public void atualizarPacienteEndereco(Paciente paciente, String endereco) {
        paciente.setEndereco(endereco);
    }
    public void atualizarPacienteTelefone(Paciente paciente, String telefone) {
        paciente.setTelefone(telefone);
    }
    public void atualizarPacienteEmail(Paciente paciente, String email) {
        paciente.setEmail(email);
    }
    public void atualizarPacienteConvenio(Paciente paciente, boolean conve) {
        paciente.setConvenio(conve);
    }

    public void removerPaciente(String identificador, ArrayList<Paciente> listaPacientes) {
        //RETIRA O PACIENTE DE IDENTIFICADOR DA LISTA DE PACIENTES
        int i = 0;
        while((listaPacientes.get(i).getCpf().equals(identificador))&&(i < listaPacientes.size())){
            i++;
        }
        if(i < listaPacientes.size()) {
            listaPacientes.remove(i);
            System.out.println("Paciente removido!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }   
    
    public void gerenciarMensagens(ArrayList<Consulta> listaConsultas) {
        GerenciadorMensagens enviar = new GerenciadorMensagens();
        enviar.enviarMensagem(listaConsultas);
    }
}