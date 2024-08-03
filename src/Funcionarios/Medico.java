package Funcionarios;
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

public class Medico {
    /**
     * Objeto identificado pelos atributos nome e crm, mas possui métodos para manipular outros objetos, como gerar um
     * novo objeto Relatório e modificar características de um objeto Paciente.
     */
    //DADOS PESSOAIS
    private String nome;
    private String crm;
    private ArrayList<Consulta> Atendimentos;
   
    //MÉTODOS CONSTRUTORES:
    public Medico() {}
    public Medico(String nome, String crm) { //CARACTERISTICAS DO MÉDICO
        this.nome = nome;
        this.crm = crm;
        this.Atendimentos =  new ArrayList<Consulta>();
    }
    
    //SETS E GETS PARA AS CARACTERISTICAS:
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public ArrayList<Consulta> getPacientesAtendidos() {
        return Atendimentos;
    }
    public void setPacientesAtendidos(ArrayList<Consulta> atendidos) {
        this.Atendimentos = atendidos;
    }
    
    public void cadastrarDadosPaciente(Consulta consulta, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, ArrayList<String> cirurgias, ArrayList<String> alergias) {
        //CADASTRA OS DADOS DE SAÚDE DE UM PACIENTE
        consulta.getPaciente().setFumar(fumar);
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(doencaCardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        this.Atendimentos.add(consulta);
    }
    
    //ATUALIZA OS DADOS DA SAÚDE DE UM PACIENTE 'paciente':
    public void atualizaPacienteFuma(Paciente paciente, boolean fumar) {
        paciente.setFumar(fumar);
    }
    public void atualizaPacienteBebe(Paciente paciente, boolean beber) {
        paciente.setBeber(beber);
    }
    public void atualizaPacienteColesterol(Paciente paciente, boolean colesterol) {
        paciente.setColesterol(colesterol);
    }
    public void atualizaPacienteDiabete(Paciente paciente, boolean diabete) {
        paciente.setDiabete(diabete);
    }
    public void atualizaPacienteDoencaCardio(Paciente paciente, boolean doencaCardio) {
        paciente.setDoencaCardio(doencaCardio);
    }
    /*
    Por conta do polimorfismo de sobreposição aplicado aos sets dos atributos 'cirurgias' e 'alergias' do Paciente, há
    também um polimorfismo nos métodos para a atualização desses dados por parte do Médico.
    */
    public void atualizaPacienteCirurgias(Paciente paciente, ArrayList<String> cirurgias) {
        //define uma lista de cirurgias para o paciente
        paciente.setCirurgias(cirurgias);
    }
    public void atualizaPacienteCirurgias(Paciente paciente, String cirurgia) {
        //adiciona uma nova cirurgia
        paciente.getCirurgias().add(cirurgia);
    }
    public void atualizaPacienteAlergia(Paciente paciente, ArrayList<String> alergias) { 
        //define as alergias do paciente
        paciente.setAlergias(alergias);
    }
    public void atualizaPacienteAlergia(Paciente paciente, String alergia) { 
        //define as alergias do paciente
        paciente.getAlergias().add(alergia);
    }
    
    public void atualizarPaciente(Paciente paciente, char campo, String novoDado) {
        switch(campo){
            case 'F':
                boolean fumar = "SIM".equals(novoDado.toUpperCase());                                
                this.atualizaPacienteFuma(paciente, fumar);
                System.out.printf("Dado alterado!");
                break;
            case 'B':
                boolean beber = "SIM".equals(novoDado.toUpperCase());                                
                this.atualizaPacienteBebe(paciente, beber);
                System.out.println("Dado alterado!");
                break;
            case 'C':
                boolean colesterol = "SIM".equals(novoDado.toUpperCase());
                this.atualizaPacienteColesterol(paciente, colesterol);
                System.out.println("Dado alterado!");
                break;
            case 'D':
                boolean diabete = "SIM".equals(novoDado.toUpperCase());
                this.atualizaPacienteDiabete(paciente, diabete);
                System.out.printf("Dado alterado!");
                break;
            case 'H': // heart
                boolean doencaCardio = "SIM".equals(novoDado.toUpperCase());
                this.atualizaPacienteDoencaCardio(paciente, doencaCardio);
                System.out.printf("Dado alterado!");
                break;
            case 'S': // surgery
                this.atualizaPacienteCirurgias(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            case 'A':
                this.atualizaPacienteAlergia(paciente, novoDado);
                System.out.printf("Dado alterado!");
                break;
            default:
                System.out.println("Campo inválido!");
        }
    }
    
    public void cadastrarProntuario(Consulta consulta, String sintomas, String diagnostico, String tratamento) {
        /*
        Cadastra o prontuário do paciente.
        */
        Prontuario prontuario = new Prontuario(sintomas, diagnostico, tratamento);
        consulta.getPaciente().setProntuario(prontuario);
    }
    
    public void atualizaProntuario(Paciente paciente, String atualizacao, char mudanca) {
        /*
        Altera algum dado do prontuário do paciente
        */
        switch(mudanca) {
            case 'S' -> paciente.getProntuario().setSintomas(atualizacao);
            case 'D' -> paciente.getProntuario().setDiagnostico(atualizacao);
            case 'T' -> paciente.getProntuario().setTratamento(atualizacao);
            default -> {
            }
        }
    }
    
    // METODOS DOS RELATORIOS:
    public void criarReceita(Medico medico, Paciente paciente, String remedio, float dosagem, String modoUso, int vezesDia) {
        Receita receita = new Receita(medico, paciente, remedio, dosagem, modoUso, vezesDia);
        receita.imprimeReceita();
    }

    public void criarEImprimirAtestado(Medico medico, Paciente paciente, Prontuario prontuario, int diasAfastamento, String dataInicio) {
        Atestado atestado = new Atestado(medico, paciente, prontuario, diasAfastamento, dataInicio);
        atestado.imprimeAtestado();
    }

    public void gerarDeclaracao(Medico medico, Paciente paciente, Prontuario prontuario, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        DeclaracaoAcompanhamento declaracao = new DeclaracaoAcompanhamento(medico, paciente, prontuario, dataAcompanhamento, parentescoAcompanhante, nomeAcompanhante);
        declaracao.imprimeDeclaracao();
    }
    
    public int clientesAtendidos(List<Consulta> listaConsultas, int mes, int ano) {
        List<String> pacientesUnicos = new ArrayList<>(); // Lista para armazenar CPFs unicos
        int numPacientes = 0; // Contador do numero de pacientes iniciando em 0
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Consulta consulta : listaConsultas) {
            LocalDate dataConsulta = LocalDate.parse(consulta.getData(), formatter); // Converte a String da data para LocalDate

            if (dataConsulta.getMonthValue() == mes && dataConsulta.getYear() == ano) {  // Verifica se o mês e o ano da consulta são iguais aos fornecidos
                String cpf = consulta.getPaciente().getCpf();

                if (pacientesUnicos.contains(cpf) == false) {  // Verifica se o CPF ja esta na lista de pacientes unicos
                    pacientesUnicos.add(cpf);  // Se nao estiver, adiciona o CPF a lista de pacientes unicos e incrementa o contador
                    numPacientes++;
                }
            }
        }
        return numPacientes; // Retorna o numero de pacientes unicos atendidos
    }
}
