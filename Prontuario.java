/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

/**
 *
 * @author home
 */
public class Prontuario {
    /**
     * Um POJO, com atributos e sets e gets. Específico a cada paciente, possui dados sobre o estado de saúde de um 
     * paciente. Esses dados são atualizados pelo médico sempre que necessário.
     */
    private String sintomas;
    private String diagnostico;
    private String tratamento;

    //MÉTODO CONSTRUTOR
    public Prontuario(String sintomas, String diagnostico, String tratamento) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }
    
    public String getSintomas() {
        return sintomas;
    }
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }
    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
}
