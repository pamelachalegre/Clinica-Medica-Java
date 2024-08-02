package Geradores;
import Dados.Paciente;
import Dados.Prontuario;
import Funcionarios.Medico;

public class Atestado {
    protected Medico medico;
    protected Paciente paciente;
    protected Prontuario prontuario;
    protected int diasAfastamento; // quantidade de dias de afastamento
    protected String dataInicio;
    
    // METODO CONSTRUTOR
    public Atestado(Medico medico, Paciente paciente, Prontuario prontuario, int diasAfastamento, String dataInicio) {
        this.medico = medico;
        this.paciente = paciente;
        this.prontuario = prontuario;
        this.diasAfastamento = diasAfastamento;
        this.dataInicio = dataInicio; // DIA/MES/ANO
    }
    
    // SETS E GETS
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
    // IMPRIME NA TELA O ATESTADO MEDICO
    System.out.println("------ATESTADO MÉDICO------");
    System.out.println("Atesto para os devidos fins, que " + paciente.getNome() + " deve se afastar do trabalho por " + diasAfastamento + " dias a partir de " + dataInicio + " pelo motivo de doença: " + prontuario.getDiagnostico() + ".");
    System.out.println(medico.getNome() + " - CRM: " + medico.getCrm());
    }
}
