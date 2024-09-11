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
    private String crm;
    private List<Consulta> atendimentos = new ArrayList();
    
    // Método construtor:
    
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
        Cadastra o dados de saúde do paciente atendido na consulta de identificador "identificador".
        */
        em.getTransaction().begin();
        Query query = em.createQuery(("select c FROM Consulta c WHERE c.identificador LIKE\'" + identificador + "\'"));
        List<Consulta> consultas = query.getResultList();
        Consulta consulta = consultas.get(0);
        
        consulta.getPaciente().setFumar(fumar); // cadastra os dados do paciente da consulta.
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(doencaCardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        
        em.getTransaction().commit();
        this.atendimentos.add(consulta); // adiciona a consulta à lista de atendimentos
    }
    
    // Atualiza os dados de saúde de um objeto *Paciente*:
    public void atualizarPaciente(Paciente paciente, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, String novaAlergia, String novaCirurgia) {
        /*
        Atualiza as informações de saúde de um paciente.
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
        //TROCAR PRO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        //TROCAR PRO BANCO DE DADOS
        paciente.setProntuario(prontuario);
    }
    public void atualizarProntuario(Paciente paciente, String novoSintoma, String novoDiagnostico, String novoTratamento) {
        /*
        Ataualiza os dados do prontuario do paciente.
        Todos os dados saõ sempre atualizados, mesmo que apenas um deles mude.
        */
        paciente.getProntuario().setSintomas(novoSintoma);
        paciente.getProntuario().setDiagnostico(novoDiagnostico);
        paciente.getProntuario().setTratamento(novoTratamento);
    }
    public void removerProntuario(String cpf) {
        /*
        Remove o prontuário de um paciente -> seta todos os seus atributos como nulos.
        */
        //TROCAR PARA O BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        
        paciente.getProntuario().setSintomas(null);
        paciente.getProntuario().setDiagnostico(null);
        paciente.getProntuario().setTratamento(null);
    }
    
    // MÉTODOS DOS RELATÓRIOS:
    public void gerarImprimirAtestado(Medico medico, String cpf, int diasAfastamento, String dataInicio) {
        // Gera e imprime um objeto *Atestado*
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        
        Atestado atestado = new Atestado(medico, paciente, paciente.getProntuario(), diasAfastamento, dataInicio);
        atestado.imprimeAtestado();
    }
    public void gerarDeclaracao(Medico medico, String cpf, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        // Gera um objeto *DeclaracaoAcompanhamento*
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        
        DeclaracaoAcompanhamento declaracao = new DeclaracaoAcompanhamento(medico, paciente, paciente.getProntuario(), dataAcompanhamento, parentescoAcompanhante, nomeAcompanhante);
        declaracao.imprimeDeclaracao();
    }
    public void gerarReceita(Medico medico, String cpf, String remedio, float dosagem, String modoUso, int vezesDia) {
        // Gera um objeto *Receita*
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        
        Receita receita = new Receita(medico, paciente, remedio, dosagem, modoUso, vezesDia);
        receita.imprimeReceita();
    }
    public int clientesAtendidos(int mes, int ano) {
        // Lista para armazenar CPFs únicos
        // Contador do numero de pacientes iniciando em 0
        List<String> pacientesUnicos = new ArrayList<>();
        int numPacientes = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
        // Retorna o numero de pacientes unicos atendidos
        return numPacientes;
    }
}
