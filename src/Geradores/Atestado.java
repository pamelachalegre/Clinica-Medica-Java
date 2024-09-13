package Geradores;
import Dados.Paciente;
import Dados.Prontuario;
import Funcionarios.Medico;

public class Atestado {
    /**
     * É um objeto com as informações regulares de um atestado que o gera e imprime no terminal.
     * 
    */
    //Atributos
    protected Medico medico;
    protected Paciente paciente;
    protected Prontuario prontuario;
    protected int diasAfastamento; // quantidade de dias de afastamento
    protected String dataInicio;
    
    // Método constrtutor : recebe todos os atributos da classe
    public Atestado(Medico medico, Paciente paciente, Prontuario prontuario, int diasAfastamento, String dataInicio) {
        this.medico = medico;
        this.paciente = paciente;
        this.prontuario = prontuario;
        this.diasAfastamento = diasAfastamento;
        this.dataInicio = dataInicio; // DIA/MES/ANO
    }
    
    // Sets e gets
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public int getDiasAfastamento() {
        return diasAfastamento;
    }

    public void setDiasAfastamento(int diasAfastamento) {
        this.diasAfastamento = diasAfastamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public void imprimeAtestado() {
        /*
        Imprime o modelo de atestado no terminal com as informações necessárias retiradas dos atributos
        */
        System.out.println("\n------ATESTADO MÉDICO------");
        System.out.println("Atesto para os devidos fins, que " + paciente.getNome() + " deve se afastar do trabalho por " + diasAfastamento + " dias a partir de " + dataInicio + " pelo motivo de doença: " + prontuario.getDiagnostico() + ".");
        System.out.println(medico.getNome() + " - CRM: " + medico.getCrm());
    }
}
