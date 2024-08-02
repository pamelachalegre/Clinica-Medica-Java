package Funcionarios;
import Dados.Paciente;
import Dados.Consulta;
import Execução.Busca;
import Geradores.GerenciadorMensagens;
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
    
    public void atualizarConsultaDataHora(Consulta consulta, String data, String hora) {
        consulta.setData(data);
        consulta.setHorario(hora);
    }
    
    public void removerConsulta(ArrayList<Consulta> listaConsultas, int indice) {
        listaConsultas.remove(indice);
        System.out.println("CONSULTA CANCELADA");
    }
    
    
    /*public void atualizarConsultaMedico(Consulta consulta, Medico medico) {
        consulta.setMedico(medico);
    }
    
    public void atualizarConsultaPaciente(Consulta consulta, Paciente paciente) {
        consulta.setPaciente(paciente);
    }
    */
    public void cadastrarPaciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio, ArrayList<Paciente> listaPacientes) {
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
            case 'I':
                int novaIdade = Integer.parseInt(novoDado); //
                this.atualizarPacienteIdade(paciente, novaIdade);
                System.out.printf("Dado alterado!");
                break;
            case 'E':
                this.atualizarPacienteEndereco(paciente, novoDado);
            case 'T':
                this.atualizarPacienteTelefone(paciente, novoDado);
                System.out.printf("Dado alterado!");
            case 'M':
                this.atualizarPacienteEmail(paciente, novoDado);
                System.out.printf("Dado alterado!");
            case 'C':
                boolean novoConvenio = "CONVENIO".equals(novoDado.toUpperCase()); //se for novoDado for convenio, retorna true
                this.atualizarPacienteConvenio(paciente, novoConvenio);
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

    public void removerPaciente(String identificador, ArrayList<Paciente> listaPacientes) {
        //RETIRA O PACIENTE DE IDENTIFICADOR DA LISTA DE PACIENTES
        Busca busca = new Busca();
        int i = busca.acharCPF(identificador, listaPacientes);
        if(i != -1) {
            listaPacientes.remove(i);
            System.out.println("PACIENTE REMOVIDO!");
        }
    }
    
    public void gerenciarMensagens(ArrayList<Consulta> listaConsultas) {
        GerenciadorMensagens enviar = new GerenciadorMensagens();
        enviar.gerenciarMensagens(listaConsultas);
    }
}