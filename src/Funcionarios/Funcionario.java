package Funcionarios;

// Importações necessárias
import javax.persistence.EntityManager;

public abstract class Funcionario {
    /*
     * É uma superclasse que faz herança com Médico e Secretária
    */
    
    // Atributos
    private String nome, cpf;
    private double salario;
    protected EntityManager em;

    // Sets e Gets dos atributos
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
    
    // Métodos Construtores
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
