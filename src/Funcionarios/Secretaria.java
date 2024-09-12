package Funcionarios;
import Auxilia.Busca;
import Dados.Paciente;
import Dados.Consulta;
import Geradores.GerenciadorMensagens;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class Secretaria extends Funcionario {
    /*
    Objeto que herda as características de *Funcionario*.
    Possui métodos para manipular outros objetos, como *Relatorio* e *Paciente*. 
    Também é capaz de criar os objetos *Atestado*, *DeclaracaoAcompanhamento*,
    e *Receita*.
    */
    
    // Métodos construtores:
    public Secretaria(EntityManager em) {
        super(em);
    }
    // O atributo *em* se refere ao banco de dados
    public Secretaria(String nome, String cpf, double salario, EntityManager em) {
        super(nome, cpf, salario, em);
    }
    
    public void cadastrarConsulta(String data, String horario, String crmMedico, String cpfPaciente, char tipo) {
        /*
        Cria uma nova consulta e leva ao banco de dados
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        //BUSCA O PACIENTE CORRETO NO BANCO DE DADOS
        Query queryPac = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE \'" + cpfPaciente + "\'"));/* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = queryPac.getResultList();
        //BUSCA O MEDICO CORRETO NO BANCO DE DADOS
        Query queryMed = em.createQuery(("select m FROM CadastroMedico m WHERE m.crm LIKE \'" + crmMedico + "\'"));/* Busca um POJO Medico no banco de dados através 
        do atributo *crm* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<CadastroMedico> medicos = queryMed.getResultList();
        
        //CRIA UMA NOVA CONSULTA
        Consulta consulta = new Consulta(data, horario, medicos.get(0), pacientes.get(0), tipo);
        
        em.persist(consulta); //MANDA PARA O BANCO DE DADOS
        
        em.getTransaction().commit(); // Salva as alterações no banco de dados
    }
    
    public void atualizarConsultaDataHora(Consulta consulta, String data, String hora) {
        /*
        Atualiza a data e o horário de uma consulta. 
        Mudanças de médico ou paciente levam ao cancelamento da consulta e marcação de uma nova.
        */
        consulta.setData(data);
        consulta.setHorario(hora);
        consulta.setIdentificador((data + hora + consulta.getMedico().getCrm()));
    }
    
    public void removerConsulta(String identificador) {
        /*
        Remove uma consulta de identificador do banco de dados.
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações

        //BUSCA A CONSULTA CORRETA NO BANCO DE DADOS
        Query query = em.createQuery("select c FROM Consulta c WHERE c.identificador LIKE \'" + identificador + "\'");/* Busca um POJO Consulta no banco de dados através 
        do atributo *identificador* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Consulta> consultas = query.getResultList(); //pega a lista resultante -> o identificador é único
               
        em.remove(consultas.get(0)); //REMOVE A CONSULTA DO BANCO
        
        em.getTransaction().commit(); // Salva as alterações no banco de dados
    }
  
    public void cadastrarPaciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio) {
        /*
        Cadastra um novo paciente no banco de dados -> cria um novo objeto paciente.
        */
        //CRIA UM OBJETO PACIENTE
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio);
        
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        em.persist(paciente); // ENVIA O NOVO PACIENTE PARA O BANCO DE DADOS.
        em.getTransaction().commit();// Salva as alterações no banco de dados
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

    public void removerPaciente(String cpf) {
        /*
        RETIRA O PACIENTE DE cpf DO BANCO DE DADOS
        */
        em.getTransaction().begin();// Inicializa o banco de dados para atualização de informações
        //BUSCA O PACIENTE NO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE \'" + cpf + "\'"));/* Busca um POJO Paciente no banco de dados através 
        do atributo *identificador* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = query.getResultList();
        
        em.remove(pacientes.get(0)); // REMOVE O PACIENTE DO BANCO DE DADOS
        
        em.getTransaction().commit(); // Salva as alterações no banco de dados
    }
    
    public void gerenciarMensagens() {
        /*
        Usa o gerenciador de mensagens para gerenciar as consultas do dia seguinte.
        */
        
        //RECUPERA TODAS AS CONSULTAS DA TABELA DE CONSULTAS 
        Query query = em.createQuery("select c FROM Consulta c");
        List<Consulta> listaConsultas = query.getResultList();
        
        if (listaConsultas.isEmpty()) {
            System.err.println("Erro");
        } else {
            GerenciadorMensagens enviar = new GerenciadorMensagens();
            enviar.gerenciarMensagens((ArrayList<Consulta>) listaConsultas); // Manda mensagem para os paciente que tem consulta marcada no dia seguinte, em relação ao dia atual.
        }
    }
}
