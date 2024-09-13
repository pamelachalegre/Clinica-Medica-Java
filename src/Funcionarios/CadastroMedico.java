package Funcionarios;

// Importações necessárias
import Dados.Consulta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Criação de uma tabela de Consulta no banco de dados com o mesmo nome da classe
public class CadastroMedico {
    /*
    * É um POJO que armazena os dados pessoais de um médico
    * Possui os atributos de cadastro de um objeto Medico para que eles possam ser enviados ao banco de dados
    */
    
    // Identificação por chaves primárias das classes Consulta inseridas no Banco de Dados
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    // Atributos
    private String nome, cpf, crm;
    private double salario;
    
    @OneToMany(cascade = CascadeType.ALL) // Mapeamento de relacionamento "um para muitos" com Consulta
    private List<Consulta> atendimentos = new ArrayList<>();
    
    // Sets e Gets dos atributos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getAtendimentos() {
        return atendimentos;
    }
    
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

    public void setAtendimentos(List<Consulta> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
    // Métodos Construtores
    public CadastroMedico() { }
    public CadastroMedico(String nome, String cpf, double salario, String crm) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.crm = crm;
    }
}
