package Dados;

// Importações necessárias
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Criação de uma tabela de Consulta no banco de dados com o mesmo nome da classe
public class Prontuario {
    /*
     * É um POJO. Representa a análise pós consulta do estado de saúde de um paciente
     * Esses dados são atualizados pelo médico sempre que necessário.
     */
    
    // Identificação por chaves primárias das classes Consulta inseridas no Banco de Dados
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    // Atributos
    private String sintomas;
    private String diagnostico;
    private String tratamento;

    // Métodos Construtores
    public Prontuario() {}
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
