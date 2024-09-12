package Funcionarios;
import Dados.Consulta;
import Dados.Paciente;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public abstract class Funcionario {
    /* O POJO Funcionario é uma classe mãe das classes Secretária Médica, que contem
    os atributos de identificação compartilhados entre as duas classes como nome, cpf e salario*/
    private String nome, cpf;
    private double salario;

    protected EntityManager em; /*
    Atributo que referencia o banco de dados, o qual sofrerá inserções, alterações e remoções de POJOs
    pelas classes Secretária e Médico.
    */

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
