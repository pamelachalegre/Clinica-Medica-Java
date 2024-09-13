package Funcionarios;

// Importações necessárias
import Dados.Paciente;
import Dados.Consulta;
import Geradores.GerenciadorMensagens;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class Secretaria extends Funcionario {
    /*
     * A classe Secretaria é uma extensão da classe Funcionario. 
     * Ela utiliza o EntityManager para interagir com o banco de dados e
     * apresenta métodos para cadastrar, atualizar e remover
     * consultas e pacientes. Além disso, gerencia mensagens enviadas aos 
     * pacientes que possuem consulta agendada para o dia seguinte.
    */
    
    // Métodos construtores
    public Secretaria(EntityManager em) {
        super(em);
    }
    
    public Secretaria(String nome, String cpf, double salario, EntityManager em) {
        super(nome, cpf, salario, em);
    }
    
    public void cadastrarConsulta(String data, String horario, String crmMedico, String cpfPaciente, char tipo) {
        /*
        Cria uma nova consulta e leva ao banco de dados
        */
        em.getTransaction().begin();
        // Busca o paciente no banco de dados através do CPF
        Query queryPac = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE \'" + cpfPaciente + "\'"));
        List<Paciente> pacientes = queryPac.getResultList();
        // Busca o médico no banco de dados através do CRM
        Query queryMed = em.createQuery(("select m FROM CadastroMedico m WHERE m.crm LIKE \'" + crmMedico + "\'"));
        List<CadastroMedico> medicos = queryMed.getResultList();
        
        // Cria uma nova consulta associando ao médico e paciente encontrados
        Consulta consulta = new Consulta(data, horario, medicos.get(0), pacientes.get(0), tipo);
        
        em.persist(consulta); // Salva no banco de dados
        
        em.getTransaction().commit();
    }
    
    public void atualizarConsultaDataHora(Consulta consulta, String data, String hora) {
        /*
        Atualiza a data e o horário de uma consulta existente. 
        Mudanças de médico ou paciente levam ao cancelamento da consulta e marcação de uma nova.
        */
        consulta.setData(data);
        consulta.setHorario(hora);
        consulta.setIdentificador((data + hora + consulta.getMedico().getCrm()));
    }
    
    public void removerConsulta(String identificador) {
        /*
        Remove uma consulta do banco de dados com base em seu identificador único
        */
        em.getTransaction().begin(); 
        // Busca a consulta pelo identificador
        Query query = em.createQuery("select c FROM Consulta c WHERE c.identificador LIKE \'" + identificador + "\'");
        List<Consulta> consultas = query.getResultList(); // pega a lista resultante -> o identificador é único
               
        em.remove(consultas.get(0)); // Remove a consulta do banco
        
        em.getTransaction().commit();
    }
  
    public void cadastrarPaciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio) {
        /*
        Cadastra um novo paciente no banco de dados
        */
        
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio); // Cria um objeto paciente
        
        em.getTransaction().begin();
        em.persist(paciente); // Envia o novo paciente para o banco de dados
        em.getTransaction().commit();
    }
    
    public void atualizarPaciente(Paciente paciente, String nome, char sexo, int idade, String endereco, String telefone, String email, boolean convenio) {
        /*
        Atualiza os dados de um paciente existente. Este método modifica todos os atributos, 
        mesmo que alguns valores não tenham sido alterados.
        */
        paciente.setNome(nome);
        paciente.setSexo(sexo);
        paciente.setIdade(idade);
        paciente.setEndereco(endereco);
        paciente.setTelefone(telefone);
        paciente.setEmail(email);
        paciente.setConvenio(convenio);
    }

    public void removerPaciente(String cpf) {
        /*
        Remove um paciente do banco de dados com base em seu CPF
        */
        em.getTransaction().begin();
        // Busca o paciente no banco de dados pelo CPF
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE \'" + cpf + "\'"));
        List<Paciente> pacientes = query.getResultList();
        
        em.remove(pacientes.get(0)); // Remove o paciente do banco de dados
        
        em.getTransaction().commit();
    }
    
    public void gerenciarMensagens() {
        /*
        Este método utiliza o GerenciadorMensagens para gerenciar mensagens e notificar
        pacientes sobre as consultas agendadas para o dia seguinte
        */
        
        em.getTransaction().begin();
        // Busca todas as consultas da tabela de consultas para análise do gerenciador
        Query query = em.createQuery("select c FROM Consulta c");
        List<Consulta> listaConsultas = query.getResultList();
        em.getTransaction().commit();
        
        if (listaConsultas.isEmpty()) { // Verifica se há consultas para gerenciar
            System.out.println("\nNão há consultas!\n");
        } else {
            // Instancia o gerenciador de mensagens e envia as notificações
            GerenciadorMensagens enviar = new GerenciadorMensagens();
            enviar.gerenciarMensagens((ArrayList<Consulta>) listaConsultas);
        }
    }
}
