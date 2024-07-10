/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionarios;
import Dados.Paciente;
import Dados.Relatorio;
/**
 *
 * @author home
 */
public class Medico {
    private String nome;
    private String crm;
    
    private Paciente paciente;
    private Relatorio relatorioMedico;
    
    public Medico() {}
    
    public void cadastrarPaciente(Paciente paciente, boolean colesterol, boolean fumar, boolean beber, boolean cardio) {
        paciente.setAlergias("");
        paciente.setColesterol(colesterol);
        paciente.setBeber(beber);
        paciente.setFumar(fumar);
        paciente.setDoencaCardio(cardio);
        paciente.setCirurgias("");
    }
    
    public void atualizaPacienteAlergia(Paciente paciente, String alergias) { // MUDAR ALERGIAS PRA LISTA!!
        paciente.setAlergias("");
    }
    
    public void atualizaPacienteColesterol(Paciente paciente, boolean colesterol) {
        paciente.setColesterol(colesterol);
    }
    
    public void atualizaPacienteBebe(Paciente paciente, boolean beber) {
        paciente.setBeber(beber);
    }
    
    public void atualizaPacienteFuma(Paciente paciente, boolean fumar) {
        paciente.setFumar(fumar);
    }
    
    public void atualizaPacienteDoencaCardio(Paciente paciente, boolean cardio) {
        paciente.setDoencaCardio(cardio);
    }
    
    public void atualizaPacienteCirurgias(Paciente paciente, String cirurgias) { // MUDAR CIRURGIAS PARA LISTA!!!
        paciente.setCirurgias("");
    }  
}
