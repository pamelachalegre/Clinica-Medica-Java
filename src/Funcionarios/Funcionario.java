package Funcionarios;
import Dados.Consulta;
import Dados.Paciente;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public abstract class Funcionario {
    private String nome, cpf;
    private double salario;

    protected EntityManager em;

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
    
    // Métodos Construtores:
    public Funcionario(EntityManager em) {
        super();
        this.em = em;
    }
    public Funcionario(String nome, String cpf, double salario, EntityManager em) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.em = em;
    }
}
