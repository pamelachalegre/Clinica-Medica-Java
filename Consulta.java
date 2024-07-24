
package Dados;
import Funcionarios.Medico;

public class Consulta {
    /*
    É um POJO com dados de uma consulta a ser realizada. Este objeto é manipulado pelo objeto Secretária no main, que
    pode definir consultas, colocá-las em uma lista de consultas ou removê-las.
    */
    private String data;
    private String horario;
    private Medico medico;
    private Paciente paciente;
    private char tipoConsulta;

    //MÉTODO CONSTRUTOR
    public Consulta(){}
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

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

    public char getTipoConsulta() {
        return tipoConsulta;
    }
    public void setTipoConsulta(char tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
}
