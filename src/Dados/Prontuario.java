package Dados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prontuario {
    /**
     * Um POJO, com atributos e sets e gets. Específico a cada paciente, possui dados sobre o estado de saúde de um 
     * paciente. Esses dados são atualizados pelo médico sempre que necessário.
     */
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String sintomas;
    private String diagnostico;
    private String tratamento;

    public Prontuario() {    }

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