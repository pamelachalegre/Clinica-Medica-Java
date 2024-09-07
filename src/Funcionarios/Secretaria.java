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
    
    public void cadastrarConsulta(String data, String horario, CadastroMedico medico, Paciente paciente, char tipo) {
        // Cria uma nova consulta e adiciona na lista de consultas
        Consulta consulta = new Consulta(data, horario, medico, paciente, tipo);
        listaConsultas.add(consulta);
    }
    
    public void atualizarConsultaDataHora(Consulta consulta, String data, String hora) {
        /*
        Atualiza a data e o horário de uma consulta. 
        Mudanças de médico ou paciente levam ao cancelamento da consulta e marcação de uma nova.
        */
        consulta.setData(data);
        consulta.setHorario(hora);
    }
    
    public void removerConsulta(String identificador) {
        /*
        Remove uma consulta da lista de consultas a partir do identificador
        */
        Busca busca = new Busca();
        int indice = busca.acharConsulta(listaConsultas, identificador);
        
        listaConsultas.remove(indice);
        System.out.println("CONSULTA CANCELADA");
    }
  
    public void cadastrarPaciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio) {
        //CRIA UM PACIENTE E O ADICIONA NA LISTA DE PACIENTES
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio);
        listaPacientes.add(paciente);
    }
    
    public void atualizarPaciente(Paciente paciente, String nome, char sexo, int idade, String endereco, String telefone, String email, boolean conve) {
        /*
        Atualiza os dados atuaizáveis de um paciente -> sempre atualiza todos os campos, MESMO QUE o valor inserido não tenha sido alterado.
        Os campos não precisam ser todos atualizados obrigatóriamente, podendo manter o mesmo valor de antes da atualização.
        */
        paciente.setNome(nome);
        paciente.setSexo(sexo);
        paciente.setIdade(idade);
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setConvenio(conve);
    }

    public void removerPaciente(String identificador) {
        /*
        RETIRA O PACIENTE DE IDENTIFICADOR DA LISTA DE PACIENTES
        */
        Busca busca = new Busca();
        String cpf = identificador;
        int i = busca.acharCPF(cpf, listaPacientes);
        if(i != -1) {
            listaPacientes.remove(i);
            System.out.println("PACIENTE REMOVIDO!");
        }
    }
    
    public void gerenciarMensagens() {
        /*
        Usa o gerenciador de mensagens para gerenciar as consultas do dia seguinte.
        */
        GerenciadorMensagens enviar = new GerenciadorMensagens();
        enviar.gerenciarMensagens(listaConsultas);
    }
}
