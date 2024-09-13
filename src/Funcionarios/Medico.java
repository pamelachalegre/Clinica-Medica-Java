package Funcionarios;

// Importações necessárias
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
    /* A classe Medico é uma extensão da classe Funcionario.
    * O médico é responsável por atender consultas, cadastrar e atualizar dados de saúde
    * dos pacientes, gerenciar prontuários e emitir relatórios como atestados, declarações
    * de acompanhamento e receitas. 
    * Cada médico possui um CRM (registro profissional) e uma lista de atendimentos realizados.
    */
    private String crm;
    private List<Consulta> atendimentos = new ArrayList();
    
    // Método construtor
    public Medico(String nome, String crm, String cpf, double salario, List<Consulta> atendimentos, EntityManager em) {
        super(nome, cpf, salario, em);
        this.crm = crm;
        this.atendimentos = atendimentos;
    }

    // Sets e Gets dos atributos
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
        Cadastra os dados de saúde do paciente atendido na consulta identificada por "identificador"
        */
        em.getTransaction().begin();
        // Busca a consulta no banco de dados através do identificaor
        Query query = em.createQuery(("select c FROM Consulta c WHERE c.identificador LIKE\'" + identificador + "\'"));
        List<Consulta> consultas = query.getResultList();
        Consulta consulta = consultas.get(0);
        
        // Cadastra os dados de saúde do paciente associado à consulta
        consulta.getPaciente().setFumar(fumar); 
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(doencaCardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        
        em.getTransaction().commit();
        this.atendimentos.add(consulta); // Adiciona a consulta a lista de atendimentos do medico
    }
    
    public void atualizarPaciente(Paciente paciente, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, String novaAlergia, String novaCirurgia) {
        /*
        Atualiza as informações de saúde de um paciente
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
        Cadastra o pronturário de um paciente -> busca o paciente a partir do CPF
        */
        Prontuario prontuario = new Prontuario(sintomas, diagnostico, tratamento);
        // Busca o paciente no banco de dados pelo CPF
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0);
        paciente.setProntuario(prontuario); 
    }
    public void atualizarProntuario(Paciente paciente, String novoSintoma, String novoDiagnostico, String novoTratamento) {
        /*
        Ataualiza os dados do prontuario do paciente.
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
        em.getTransaction().begin();
        //BUSCA O PACIENTE CORRETO NO BANCO DE DADOS
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        List<Paciente> pacientes = query.getResultList();
        Paciente paciente = pacientes.get(0); // 0 pois CPF é único -> apenas um paciente será retornado
        
        em.remove(paciente.getProntuario()); // Busca o paciente no banco de dados pelo CPF
        paciente.setProntuario(null); // Desassocia o prontuário do paciente
        em.getTransaction().commit();
    }
    
    // Métodos dos relatórios: 
    public void gerarImprimirAtestado(Medico medico, String cpf, int diasAfastamento, String dataInicio) {
        /*
        Gera um atestado médico para o paciente, com base no CPF
        */
        em.getTransaction().begin();
        // Busca o paciente do atestado no banco de dados pelo CPF
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit();

        Paciente paciente = pacientes.get(0);
        
        Atestado atestado = new Atestado(medico, paciente, paciente.getProntuario(), diasAfastamento, dataInicio);
        atestado.imprimeAtestado();
    }
    public void gerarDeclaracao(Medico medico, String cpf, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        /*
        Gera uma declaração de acompanhamento para o paciente
        */
        em.getTransaction().begin();
        // Busca o paciente da declaração no banco dedados pelo CPF
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit();
        Paciente paciente = pacientes.get(0);
        
        DeclaracaoAcompanhamento declaracao = new DeclaracaoAcompanhamento(medico, paciente, paciente.getProntuario(), dataAcompanhamento, parentescoAcompanhante, nomeAcompanhante);
        declaracao.imprimeDeclaracao();
    }
    public void gerarReceita(Medico medico, String cpf, String remedio, float dosagem, String modoUso, int vezesDia) {
        /*
        Gera uma receita médica para o paciente
        */
        em.getTransaction().begin();
        // Busca o paciente da receita no banco de dados pelo CPF
        Query query = em.createQuery(("select p FROM Paciente p WHERE p.cpf LIKE\'" + cpf + "\'"));
        List<Paciente> pacientes = query.getResultList();
        em.getTransaction().commit();
        Paciente paciente = pacientes.get(0);
        
        Receita receita = new Receita(medico, paciente, remedio, dosagem, modoUso, vezesDia);
        receita.imprimeReceita();
    }
    public void clientesAtendidos(int mes, int ano) {
        // Lista e conta o número de clientes atendidos pelo médico em um mês e ano específicos
        List<String> pacientesUnicos = new ArrayList<>();
        int numPacientes = 0; // Contador do numero de pacientes iniciando em 0
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
                    numPacientes++; // Incrementa o número de pacientes atendidos
                }
            }
        }
        System.out.println("\n\nNÚMERO DE CLIENTES ATENDIDOS EM " + mes + "/" + ano + ": " + numPacientes);
    }
}
