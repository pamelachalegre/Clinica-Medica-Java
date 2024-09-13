package Geradores;
import Dados.Paciente;
import Funcionarios.Medico;

public class Receita{
    /**
     * É um objeto receita com as informações para tratamento de um paciente. Gera e imprime no terminal.
     */
    
    //Atributos
    protected Medico medico;
    protected Paciente paciente;
    protected String remedio;
    protected float dosagem;
    protected String modoUso; 
    protected int vezesDia;

    //Método construtor -> recebe todos os atributos
    public Receita(Medico medico, Paciente paciente, String remedio, float dosagem, String modoUso, int vezesDia) {
        this.medico = medico;
        this.paciente = paciente;
        this.remedio = remedio;
        this.dosagem = dosagem;
        this.modoUso = modoUso;
        this.vezesDia = vezesDia;
    }

    // Sets e gets
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

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public float getDosagem() {
        return dosagem;
    }

    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    public String getModoUso() {
        return modoUso;
    }

    public void setModoUso(String modoUso) {
        this.modoUso = modoUso;
    }

    public int getVezesDia() {
        return vezesDia;
    }

    public void setVezesDia(int vezesDia) {
        this.vezesDia = vezesDia;
    }
    
    public void imprimeReceita() {
        /*
        Imprime o modelo da receita no terminal com as informações dos atributos.
        */
        System.out.println("------RECEITA MÉDICA------");
        System.out.println("Nome do paciente: " + paciente.getNome());
        System.out.println("Utilize o remédio " + remedio + " com a dose " + dosagem + " via " + modoUso + ' ' + vezesDia + " vezes ao dia.");
        System.out.println(medico.getNome() + " - CRM: " + medico.getCrm());        
    }
}