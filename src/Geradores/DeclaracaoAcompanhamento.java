package Geradores;
import Dados.Paciente;
import Dados.Prontuario;
import Funcionarios.Medico;

public class DeclaracaoAcompanhamento {
    /* POJO gerado pela classe Medico, que pode ser requisitado pelo usuário e representa
    um objeto de Declaração de Acompanhamento de um parente ou cuidador em uma consulta médica. Apresentando
    seus respectivos atributos:
    */
    // Atributos
    protected Medico medico;
    protected Paciente paciente;
    protected Prontuario prontuario;
    protected String dataAcompanhamento;
    protected String parentescoAcompanhante;
    protected String nomeAcompanhante;

    // METODO CONSTRUTOR
    public DeclaracaoAcompanhamento(Medico medico, Paciente paciente, Prontuario prontuario, String dataAcompanhamento, String parentescoAcompanhante, String nomeAcompanhante) {
        this.medico = medico;
        this.paciente = paciente;
        this.prontuario = prontuario;
        this.dataAcompanhamento = dataAcompanhamento;
        this.parentescoAcompanhante = parentescoAcompanhante;
        this.nomeAcompanhante = nomeAcompanhante;
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
    // IMPRIME NA TELA A DECLARACAO MEDICA DE ACOMPANHANTE
    System.out.println("------DECLARAÇÃO MÉDICA DE ACOMPANHANTE------");
    System.out.println("Atesto para os devidos fins, que " + paciente.getNome() + ", paciente sob meus cuidados, foi atendido(a) no dia " + dataAcompanhamento + ", apresentando quadro de " + prontuario.getDiagnostico() + ", tendo sido acompanhado(a) pelo seu(sua) " + parentescoAcompanhante + ", Sr(a). " + nomeAcompanhante + ".");
    System.out.println(medico.getNome() + " - CRM: " + medico.getCrm());
}

}
