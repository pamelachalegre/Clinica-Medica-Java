package Funcionarios;
import Dados.Paciente;
import Dados.Relatorio;
import java.util.ArrayList;

public class Medico {
    /**
     * Objeto identificado pelos atributos nome e crm, mas possui métodos para manipular outros objetos, como gerar um
     * novo objeto Relatório e modificar características de um objeto Paciente.
     */
    //DADOS PESSOAIS
    private String nome;
    private String crm;
    
    private Relatorio novoRelatorio;
    private ArrayList<Relatorio> relatoriosMes; //LISTA DE RELATÓRIOS MENSAIS.
    
    //MÉTODOS CONSTRUTORES:
    public Medico() {}
    public Medico(String nome, String crm) { //CARACTERISTICAS DO MÉDICO
        this.nome = nome;
        this.crm = crm;
    }
    
    //SETS E GETS PARA AS CARACTERISTICAS:
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

    public void fazerRelatorio(String receita, String atestado, String acompanhamento, int clientes) {
        novoRelatorio = new Relatorio(receita, atestado, acompanhamento, clientes);
    }
    
    public void cadastrarDadosPaciente(Paciente paciente, boolean fumar, boolean beber, boolean colesterol, boolean diabete, boolean cardio, ArrayList<String> cirurgias, ArrayList<String> alergias) {
        //CADASTRA OS DADOS DE SAÚDE DE UM PACIENTE
        paciente.setFumar(fumar);
        paciente.setBeber(beber);
        paciente.setColesterol(colesterol);
        paciente.setDiabete(diabete);
        paciente.setDoencaCardio(cardio);
        paciente.setCirurgias(cirurgias);
        paciente.setAlergias(alergias);
    }
    
    //ATUALIZA OS DADOS DA SAÚDE DE UM PACIENTE 'paciente':
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
    /*
    Por conta do polimorfismo de sobreposição aplicado aos sets dos atributos 'cirurgias' e 'alergias' do Paciente, há
    também um polimorfismo nos métodos para a atualização desses dados por parte do Médico.
    */
    public void atualizaPacienteCirurgias(Paciente paciente, ArrayList<String> cirurgias) {
        //define uma lista de cirurgias para o paciente
        paciente.setCirurgias(cirurgias);
    }
    public void atualizaPacienteCirurgias(Paciente paciente, String cirurgia) {
        //adiciona uma nova cirurgia
        paciente.setCirurgias(cirurgia);
    }
    public void atualizaPacienteAlergia(Paciente paciente, ArrayList<String> alergias) { 
        //define as alergias do paciente
        paciente.setAlergias(alergias);
    }
    public void atualizaPacienteAlergia(Paciente paciente, String alergia) { 
        //define as alergias do paciente
        paciente.setAlergias(alergia);
    }
}
