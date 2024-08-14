package Funcionarios;
import Auxilia.Busca;
import Dados.Paciente;
import Dados.Consulta;
import Geradores.GerenciadorMensagens;
import java.util.ArrayList;

public class Secretaria extends Funcionario {
    /*
    Objeto que herda as características de *Funcionario*.
    Possui métodos para manipular outros objetos, como *Relatorio* e *Paciente*. 
    Também é capaz de criar os objetos *Atestado*, *DeclaracaoAcompanhamento*,
    e *Receita*.
    */
    
    // Métodos construtores:
    public Secretaria() {}
    public Secretaria(String nome, String cpf, double salario, ArrayList<Consulta> listaConsultas, ArrayList<Paciente> listaPacientes) {
        super(nome, cpf, salario, listaConsultas, listaPacientes);
    }
    
    public void cadastrarConsulta(String data, String horario, Medico medico, Paciente paciente, char tipo) {
        // Cria uma nova consulta e adiciona na lista de consultas
        Consulta consulta = new Consulta(data, horario, medico, paciente, tipo);
        listaConsultas.add(consulta);
    }
    
    public void atualizarConsultaDataHora(Consulta consulta, String data, String hora) {
        consulta.setData(data);
        consulta.setHorario(hora);
    }
    
    public void removerConsulta(int indice) {
        listaConsultas.remove(indice);
        System.out.println("CONSULTA CANCELADA");
    }
  
    /*
    public void atualizarConsultaMedico(Consulta consulta, Medico medico) {
        consulta.setMedico(medico);
    }
    public void atualizarConsultaPaciente(Consulta consulta, Paciente paciente) {
        consulta.setPaciente(paciente);
    }
    */
    
    public void cadastrarPaciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio) {
        //CRIA UM PACIENTE E O ADICIONA NA LISTA DE PACIENTES
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio);
        listaPacientes.add(paciente);
    }
    
    public void atualizarPaciente(Paciente paciente, char campo, String novoDado) {
        switch(campo){
            case 'N':
                this.atualizarPacienteNome(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            case 'S':
                this.atualizarPacienteSexo(paciente, novoDado.charAt(0));
                System.out.println("Dado alterado!");
                break;
            case 'I':
                int novaIdade = Integer.parseInt(novoDado);
                this.atualizarPacienteIdade(paciente, novaIdade);
                System.out.printf("Dado alterado!");
                break;
            case 'E':
                this.atualizarPacienteEndereco(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            case 'T':
                this.atualizarPacienteTelefone(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            case 'M':
                this.atualizarPacienteEmail(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            case 'C':
                boolean novoConvenio = "CONVENIO".equals(novoDado.toUpperCase());
                // se o *novoDado* for convenio, retorna true
                this.atualizarPacienteConvenio(paciente, novoConvenio);
                System.out.printf("Dado alterado!");
                break;
            default:
                System.out.println("Campo inválido!");
        }
    }
    
    //MODIFICA OS DADOS DE UM PACIENTE 'paciente':
    private void atualizarPacienteNome(Paciente paciente, String nome) {
        paciente.setNome(nome);
    }
    private void atualizarPacienteSexo(Paciente paciente, char sexo) {
        paciente.setSexo(sexo);
    }
    private void atualizarPacienteIdade(Paciente paciente, int idade) {
        paciente.setIdade(idade);
    }
    private void atualizarPacienteEndereco(Paciente paciente, String endereco) {
        paciente.setEndereco(endereco);
    }
    private void atualizarPacienteTelefone(Paciente paciente, String telefone) {
        paciente.setTelefone(telefone);
    }
    public void atualizarPacienteEmail(Paciente paciente, String email) {
        paciente.setEmail(email);
    }
    public void atualizarPacienteConvenio(Paciente paciente, boolean conve) {
        paciente.setConvenio(conve);
    }

    public void removerPaciente(String identificador) {
        //RETIRA O PACIENTE DE IDENTIFICADOR DA LISTA DE PACIENTES
        Busca busca = new Busca();
        String cpf = identificador;
        int i = busca.acharCPF(cpf, listaPacientes);
        if(i != -1) {
            listaPacientes.remove(i);
            System.out.println("PACIENTE REMOVIDO!");
        }
    }
    
    public void gerenciarMensagens() {
        GerenciadorMensagens enviar = new GerenciadorMensagens();
        enviar.gerenciarMensagens(listaConsultas);
    }
}
