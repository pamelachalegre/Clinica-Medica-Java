package Geradores;
import Dados.Paciente;
import Dados.Prontuario;
import Funcionarios.Medico;

public class DeclaracaoAcompanhamento {
    /**
     * É um objeto de declaração de acompanhamento para a pessoa que acompanhou um paciente a uma consulta.
     * Gera e imprime a declaração no terminal.
     */
    //Atributos
    protected Medico medico;
    protected Paciente paciente;
    protected Prontuario prontuario;
    protected String dataAcompanhamento;
    protected String parentescoAcompanhante;
    protected String nomeAcompanhante;

    //Método Construtor : recebe todos os atributos
    public DeclaracaoAcompanhamento(Medico medico, Paciente paciente, Prontuario prontuario, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        this.medico = medico;
        this.paciente = paciente;
        this.prontuario = prontuario;
        this.dataAcompanhamento = dataAcompanhamento;
        this.parentescoAcompanhante = parentescoAcompanhante;
        this.nomeAcompanhante = nomeAcompanhante;
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

    public String getDataAcompanhamento() {
        return dataAcompanhamento;
    }

    public void setDataAcompanhamento(String dataAcompanhamento) {
        this.dataAcompanhamento = dataAcompanhamento;
    }

    public String getParentescoAcompanhante() {
        return parentescoAcompanhante;
    }

    public void setParentescoAcompanhante(String parentescoAcompanhante) {
        this.parentescoAcompanhante = parentescoAcompanhante;
    }

    public String getNomeAcompanhante() {
        return nomeAcompanhante;
    }

    public void setNomeAcompanhante(String nomeAcompanhante) {
        this.nomeAcompanhante = nomeAcompanhante;
    }
    
    public void imprimeDeclaracao() {
        /*
        Imprime o modelo da declaração de acompanhamento no terminal com as informações dos atributos
        */
        System.out.println("------DECLARAÇÃO MÉDICA DE ACOMPANHANTE------");
        System.out.println("Atesto para os devidos fins, que " + paciente.getNome() + ", paciente sob meus cuidados, foi atendido(a) no dia " + dataAcompanhamento + ", apresentando quadro de " + prontuario.getDiagnostico() + ", tendo sido acompanhado(a) pelo seu(sua) " + parentescoAcompanhante + ", Sr(a). " + nomeAcompanhante + ".");
        System.out.println(medico.getNome() + " - CRM: " + medico.getCrm());
    }

}
