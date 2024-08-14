package Funcionarios;
import Dados.Consulta;
import Dados.Paciente;
import java.util.ArrayList;

public class Funcionario {
    private String nome, cpf;
    private double salario;
    public ArrayList<Consulta> listaConsultas;
    public ArrayList<Paciente> listaPacientes;

    // Sets e Gets para os atributos da superclasse *Funcionario*:
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }
    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    // Métodos Construtores:
    public Funcionario() {}
    public Funcionario(String nome, String cpf, double salario, ArrayList<Consulta> listaConsultas, ArrayList<Paciente> listaPacientes) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.listaConsultas = listaConsultas;
        this.listaPacientes = listaPacientes;
    }   
}
