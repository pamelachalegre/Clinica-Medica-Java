package Funcionarios;
import Dados.Paciente;
import Dados.Relatorio;
import java.util.ArrayList;

public class Medico {
    private String nome;
    private String crm;
    
    private Paciente paciente;
    private Relatorio relatorioMedico;
    
    // método construtor
    public Medico() {}

    public Medico(String nome, String crm, Paciente paciente, Relatorio relatorioMedico) {
        this.nome = nome;
        this.crm = crm;
        this.paciente = paciente;
        this.relatorioMedico = relatorioMedico;
    }

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

    public Relatorio getRelatorioMedico() {
        return relatorioMedico;
    }
    public void setRelatorioMedico(Relatorio relatorioMedico) {
        this.relatorioMedico = relatorioMedico;
    }
    
    public void cadastrarPaciente(Paciente paciente, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean cardio, ArrayList<String> cirurgias, ArrayList<String> alergias) {
        paciente.setFumar(fumar);
        paciente.setBeber(beber);
        paciente.setColesterol(colesterol);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardio(cardio);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
    }
    
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
    
    public void atualizaPacienteCirurgias(Paciente paciente, ArrayList<String> cirurgias) {
        paciente.setCirurgias(cirurgias);
    }
        
    public void atualizaPacienteAlergia(Paciente paciente, ArrayList<String> alergias) { 
        paciente.setAlergias(alergias);
    }   
}
