package Funcionarios;
import Dados.Paciente;
import Dados.Prontuario;
import Dados.Consulta;
import java.util.ArrayList;

public class Medico {
    /**
     * Objeto identificado pelos atributos nome e crm, mas possui métodos para manipular outros objetos, como gerar um
     * novo objeto Relatório e modificar características de um objeto Paciente.
     */
    //DADOS PESSOAIS
    private String nome;
    private String crm;
    private ArrayList<Consulta> pacientesAtendidos;
    
    
    //MÉTODOS CONSTRUTORES:
    public Medico() {}
    public Medico(String nome, String crm, ArrayList<Consulta> atendimentos) { //CARACTERISTICAS DO MÉDICO
        this.nome = nome;
        this.crm = crm;
        this.pacientesAtendidos = atendimentos;
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
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(ArrayList<Consulta> pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    
    public void cadastrarDadosPaciente(Consulta consulta, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean cardio, ArrayList<String> cirurgias, ArrayList<String> alergias) {
        //CADASTRA OS DADOS DE SAÚDE DE UM PACIENTE
        consulta.getPaciente().setFumar(fumar);
        consulta.getPaciente().setBeber(beber);
        consulta.getPaciente().setColesterol(colesterol);
        consulta.getPaciente().setDiabete(diabete);
        consulta.getPaciente().setDoencaCardio(cardio);
        consulta.getPaciente().setCirurgias(cirurgias);
        consulta.getPaciente().setAlergias(alergias);
        this.pacientesAtendidos.add(consulta);
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
    public void atualizaPacienteDoencaCardio(Paciente paciente, boolean cardio) {
        paciente.setDoencaCardio(cardio);
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
    
} 