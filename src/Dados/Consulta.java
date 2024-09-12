package Dados;

// Importações necessárias
import Funcionarios.CadastroMedico;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity // Criação de uma tabela de Consulta no banco de dados com o mesmo nome da classe
public class Consulta {
    /**
     * É um POJO com dados de uma consulta a ser realizada 
     * Este objeto é manipulado pelo objeto Secretária
     * Uma consulta pode ser criada, cancelada ou ter suas data e hora atualizadas
    */
    
    // Identificação por chaves primárias das classes Consulta inseridas no Banco de Dados
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    //Atributos
    private String identificador; // Registro de uma consulta, facilita na busca e identificação
    private String dataConsulta;
    private String horario;
    private char tipoConsulta; // 'R' = retorno; 'N' = normal
    
    @ManyToOne(cascade = CascadeType.REFRESH) // Mapeamento de relacionamento "muitos para um" com CadastroMedico
    private CadastroMedico medico;
    
    @OneToOne(cascade = CascadeType.ALL) // Mapeamento de relacionamento "um para um" com Paciente
    private Paciente paciente;
    

    //Métodos construtores
    public Consulta(){}
    
    public Consulta(String data, String horario, CadastroMedico medico, Paciente paciente, char tipoConsulta){
        this.identificador = data + horario + medico.getCrm();
        this.dataConsulta = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
    }
    
    //Sets e Gets dos atributos
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public String getData() {
        return dataConsulta;
    }
    public void setData(String data) {
        this.dataConsulta = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public CadastroMedico getMedico() {
        return medico;
    }
    public void setMedico(CadastroMedico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public char getTipoConsulta() {
        return tipoConsulta;
    }
    public void setTipoConsulta(char tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
}