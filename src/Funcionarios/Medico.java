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

public class Medico extends Funcionario {
    /*
    Objeto que herda as características de *Funcionario*.
    É identificado pelo atributo *crm*, e possui métodos para manipular outros objetos, 
    como *Relatorio* e *Paciente*. Também é capaz de criar os objetos *Atestado*, *DeclaracaoAcompanhamento*,
    e *Receita*.
    */
    private String crm;
    private ArrayList<Consulta> atendimentos;
    
    // Método construtor:
    public Medico() {}
    public Medico(String nome, String cpf, double salario, ArrayList<Consulta> listaConsultas, ArrayList<Paciente> listaPacientes, String crm, ArrayList<Consulta> atendimentos) {
        super(nome, cpf, salario, listaConsultas, listaPacientes);
        this.crm = crm;
        this.atendimentos =  new ArrayList<Consulta>();
    }

    // Sets e Gets para os atributos:
    public String getCrm() {
        return crm;
    }

    public ArrayList<Consulta> getPacientesAtendidos() {
        return atendimentos;
    }
    public void setPacientesAtendidos(ArrayList<Consulta> atendidos) {
        this.atendimentos = atendidos;
    }
    
    public void cadastrarDadosPaciente(Consulta consulta, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean doencaCardio, ArrayList<String> cirurgias, ArrayList<String> alergias) {
        // Cadastra os dados de saúde de um objeto *Paciente*
        consulta.getPaciente().setFumar(fumar);
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(doencaCardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        this.atendimentos.add(consulta);
    }
    
    // Atualiza os dados de saúde de um objeto *Paciente*:
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
    Por conta do polimorfismo de sobreposição aplicado aos sets dos atributos 'cirurgias' e 'alergias' do Paciente, 
    há também um polimorfismo nos métodos para a atualização desses dados por parte do Médico.
    */
    public void atualizaPacienteCirurgias(Paciente paciente, ArrayList<String> cirurgias) {
        // Define uma lista de cirurgias para o paciente
        paciente.setCirurgias(cirurgias);
    }
    public void atualizaPacienteCirurgias(Paciente paciente, String cirurgia) {
        // Adiciona uma nova cirurgia
        paciente.getCirurgias().add(cirurgia);
    }
    public void atualizaPacienteAlergia(Paciente paciente, ArrayList<String> alergias) { 
        // Define as alergias do paciente
        paciente.setAlergias(alergias);
    }
    public void atualizaPacienteAlergia(Paciente paciente, String alergia) { 
        // Define as alergias do paciente
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
    
    // Métodos do prontuário:
    public void cadastrarProntuario(Consulta consulta, String sintomas, String diagnostico, String tratamento) {
        // Cadastra o prontuário do paciente
        Prontuario prontuario = new Prontuario(sintomas, diagnostico, tratamento);
        consulta.getPaciente().setProntuario(prontuario);
    }
    public void atualizarProntuario(Paciente paciente, char campo, String novoDado) {
        // Altera algum dado do prontuário do paciente
        switch(campo) {
            case 'S' -> paciente.getProntuario().setSintomas(novoDado);
            case 'D' -> paciente.getProntuario().setDiagnostico(novoDado);
            case 'T' -> paciente.getProntuario().setTratamento(novoDado);
            default -> System.out.println("Campo inválido!");
        }
    }
    public void removerProntuario(Paciente paciente) {
        // Remove o prontuário de um paciente
        paciente.getProntuario().setSintomas(null);
        paciente.getProntuario().setDiagnostico(null);
        paciente.getProntuario().setTratamento(null);
    }
    
    // Métodos dos relatórios:
    public void gerarImprimirAtestado(Medico medico, Paciente paciente, Prontuario prontuario, int diasAfastamento, String dataInicio) {
        // Gera e imprime um objeto *Atestado*
        Atestado atestado = new Atestado(medico, paciente, prontuario, diasAfastamento, dataInicio);
        atestado.imprimeAtestado();
    }
    public void gerarDeclaracao(Medico medico, Paciente paciente, Prontuario prontuario, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        // Gera um objeto *DeclaracaoAcompanhamento*
        DeclaracaoAcompanhamento declaracao = new DeclaracaoAcompanhamento(medico, paciente, prontuario, dataAcompanhamento, parentescoAcompanhante, nomeAcompanhante);
        declaracao.imprimeDeclaracao();
    }
    public void gerarReceita(Medico medico, Paciente paciente, String remedio, float dosagem, String modoUso, int vezesDia) {
        // Gera um objeto *Receita*
        Receita receita = new Receita(medico, paciente, remedio, dosagem, modoUso, vezesDia);
        receita.imprimeReceita();
    }
    public int clientesAtendidos(List<Consulta> listaConsultas, int mes, int ano) {
        // Lista para armazenar CPFs únicos
        // Contador do numero de pacientes iniciando em 0
        List<String> pacientesUnicos = new ArrayList<>();
        int numPacientes = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Consulta consulta : listaConsultas) {
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
