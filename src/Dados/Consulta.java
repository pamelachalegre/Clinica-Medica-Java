package Dados;
import Funcionarios.CadastroMedico;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity // Cria-se uma tabela do pojo Consulta no banco de dados com o nome Consulta
public class Consulta {
    /*
    É um POJO com dados de uma consulta a ser realizada. Este objeto é manipulado pelo objeto Secretária, que
    pode definir consultas, colocá-las em uma lista de consultas, inseri-las no banco de dados ou removê-las.
    */
    @Id @GeneratedValue(strategy=GenerationType.AUTO)/* identificação por de chaves primárias das classes Consulta 
    inseridas no Banco de Dados
    
*/
    // Atributos
    private Integer id;
    
    private String identificador; // Registro de uma consulta, facilita na busca e identificação
    private String dataConsulta;
    private String horario;
    private char tipoConsulta; // R = retorno; N = normal
    
    @OneToOne(cascade = CascadeType.ALL)// Mapeamento de relacionamento "um para um" com o atributo medico

    private CadastroMedico medico;
    
    @OneToOne(cascade = CascadeType.ALL)// Mapeamento de relacionamento "um para um" com o atributo paciente
    private Paciente paciente;
    

    //MÉTODO CONSTRUTOR
    public Consulta(){}
    
    public Consulta(String data, String horario, CadastroMedico medico, Paciente paciente, char tipoConsulta){
        this.identificador = data + horario + medico.getCrm();
        this.dataConsulta = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
}
    // Funções sets e gets do POJO
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