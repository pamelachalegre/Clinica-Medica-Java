package Funcionarios;
import Auxilia.Busca;
import Dados.Paciente;
import Dados.Prontuario;
import Dados.Consulta;
import Geradores.Atestado;
import Geradores.DeclaracaoAcompanhamento;
import Geradores.Receita;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Medico extends Funcionario {
    /*
    Objeto que herda as características de *Funcionario*.
    É identificado pelo atributo *crm*, e possui métodos para manipular outros objetos, 
    como *Relatorio* e *Paciente*. Também é capaz de criar os objetos *Atestado*, *DeclaracaoAcompanhamento*,
    e *Receita*.
    */
    private String crm; // identificação do médico
    private List<Consulta> atendimentos = new ArrayList();
    
    // Método construtor:
    // Atributo *em* se refere ao banco de dados
    public Medico(String nome, String crm, String cpf, double salario, List<Consulta> atendimentos, EntityManager em) {
        super(nome, cpf, salario, em);
        this.crm = crm;
        this.atendimentos = atendimentos;
    }

    // Sets e Gets para os atributos:
    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public String getCrm() {
        return crm;
    }

    public List<Consulta> getPacientesAtendidos() {
        return atendimentos;
    }
    public void setPacientesAtendidos(ArrayList<Consulta> atendidos) {
        this.atendimentos = atendidos;
    }
    
    public void cadastrarDadosPaciente(String identificador, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, String cirurgias, String alergias) {
        /*
        Cadastra o dados de saúde do paciente atendido dentro da classe Consulta, sendo o objeto consulta encontrado através do atributo *identificador*.
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        Query query = em.createQuery(("select c FROM Consulta c WHERE c.identificador LIKE\'" + identificador + "\'")); /* Busca um POJO Consulta no banco de dados através 
        do atributo *identificador* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Consulta> consultas = query.getResultList(); // Guarda o resultado do query
        Consulta consulta = consultas.get(0);
        
        // Cadastra os dados do paciente presentes na consulta.
        consulta.getPaciente().setFumar(fumar); 
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(doencaCardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        
        em.getTransaction().commit(); // Salva as alterações no banco de dados
        this.atendimentos.add(consulta); // adiciona a consulta à lista de atendimentos
    }
    
    
    public void atualizarPaciente(Paciente paciente, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, String novaAlergia, String novaCirurgia) {
        /*
        Atualiza as informações de saúde de um  paciente.
        */
        paciente.setAlergias(novaAlergia);
        paciente.setCirurgias(novaCirurgia);
        paciente.setFumar(fumar);
        paciente.setBeber(beber);
        paciente.setDoencaCardio(doencaCardio);
        paciente.setColesterol(colesterol);
        paciente.setDiabete(diabete);
    }
    
    // Métodos do prontuário:
    public void cadastrarProntuario(String cpf, String sintomas, String diagnostico, String tratamento) {
        /*
        Cadastra o pronturário de um paciente -> busca o paciente a partir do CPF.
        */
        Prontuario prontuario = new Prontuario(sintomas, diagnostico, tratamento);
        
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'")); /* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        
        paciente.setProntuario(prontuario); // Cria um prontuário do paciente
    }
    public void atualizarProntuario(Paciente paciente, String novoSintoma, String novoDiagnostico, String novoTratamento) {
        /*
        Atualiza os dados do prontuario do paciente.
        Todos os dados são sempre atualizados, mesmo que apenas um deles mude.
        */
        paciente.getProntuario().setSintomas(novoSintoma);
        paciente.getProntuario().setDiagnostico(novoDiagnostico);
        paciente.getProntuario().setTratamento(novoTratamento);
    }
    public void removerProntuario(String cpf) {
        /*
        Remove o prontuário de um paciente -> seta como nulo e remove do banco de dados.
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        //BUSCA O PACIENTE CORRETO NO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'")); /* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0); // 0 POIS O CPF É ÚNICO -> APENAS UM PACIENTE VAI SER RETORNADO
        
        em.remove(paciente.getProntuario()); //REMOVE O OBJETO PRONTUÁRIO DO BANCO DE DADOS
        paciente.setProntuario(null); // REMOVE O PRONTUÁRIO DO PACIENTE
        em.getTransaction().commit(); // Salva as alterações no banco de dados.
    }
    
    // MÉTODOS DOS RELATÓRIOS:
    public void gerarImprimirAtestado(Medico medico, String cpf, int diasAfastamento, String dataInicio) {
        /*
        Gera um objeto Atestado para emitir um atestado para o paciente
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        // BUSCA O PACIENTE DO ATESTADO NO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));/* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit(); // Salva as alterações no banco de dados

        Paciente paciente = pacientes.get(0);
        
        Atestado atestado = new Atestado(medico, paciente, paciente.getProntuario(), diasAfastamento, dataInicio);
        atestado.imprimeAtestado(); // Imprime o Atestado gerado
    }
    public void gerarDeclaracao(Medico medico, String cpf, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        /*
        Gera um objeto DeclaracaoAcompanhamento para emitir uma declaração de acompanhamento
        */
        em.getTransaction().begin(); // Inicializa o banco de dados para atualização de informações
        // BUSCA O PACIENTE DA DECLARAÇÃO NO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));/* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit(); // Salva as alterações no banco de dados
        Paciente paciente = pacientes.get(0);
        
        DeclaracaoAcompanhamento declaracao = new DeclaracaoAcompanhamento(medico, paciente, paciente.getProntuario(), dataAcompanhamento, parentescoAcompanhante, nomeAcompanhante);
        declaracao.imprimeDeclaracao(); // Imprime a Declaracao gerada
    }
    public void gerarReceita(Medico medico, String cpf, String remedio, float dosagem, String modoUso, int vezesDia) {
        /*
        Cria-se um objeto Receita para emitir uma receita.
        */
        // BUSCA O PACIENTE DA RECEITA NO BANCO DE DADOS
        em.getTransaction().begin();// Inicializa o banco de dados para atualização de informações
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));/* Busca um POJO Paciente no banco de dados através 
        do atributo *cpf* e retorna um lista de quantas POJOs encontrou com o mesmo valor deste atributo */
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit(); // Salva as alterações no banco de dados
        Paciente paciente = pacientes.get(0);
        
        Receita receita = new Receita(medico, paciente, remedio, dosagem, modoUso, vezesDia);
        receita.imprimeReceita(); // Imprime a Receita gerada
    }
    public void clientesAtendidos(int mes, int ano) {
        // Lista para armazenar CPFs únicos
        // Contador do numero de pacientes iniciando em 0
        List<String> pacientesUnicos = new ArrayList<>();
        int numPacientes = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Data de do dia atual

        for (Consulta consulta : atendimentos) {
            // Converte a String da data para LocalDate
            LocalDate dataConsulta = LocalDate.parse(consulta.getData(), formatter);

            if (dataConsulta.getMonthValue() == mes && dataConsulta.getYear() == ano) {
                // Verifica se o mês e o ano da consulta são iguais aos fornecidos
                String cpf = consulta.getPaciente().getCpf();

                if (pacientesUnicos.contains(cpf) == false) {
                    // Verifica se o CPF ja esta na lista de pacientes unicos
                    // Se nao estiver, adiciona o CPF a lista de pacientes unicos e incrementa o contador
                    pacientesUnicos.add(cpf);
                    numPacientes++;
                }
            }
        }
        System.out.println("\n\nNÚMERO DE CLIENTES ATENDIDOS EM " + mes + "/" + ano + ": " + numPacientes); // Imprime a quantidade de clientes atendidos em um mês.
    }
}
