package Funcionarios;

import Dados.Consulta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Cria-se uma tabela do pojo CadastroMedico no banco de dados com o nome CadastroMedico
public class CadastroMedico {
    /*
    Forma POJO com os dados do médico. Este POJO serve para facilitar a inserção dos atributos do médico no banco de dados.
    */
    @Id @GeneratedValue(strategy=GenerationType.AUTO) /* identificação através de chaves primárias das classes Paciente 
    inseridas no Banco de Dados  */
    private Integer id; // chave primária da classe no Banco de Dados
    
    private String crm /*(Conselho Regional de Medicina), identificação do médico*/ ;
    private String nome, cpf;
    private double salario;
    
    @OneToMany(cascade = CascadeType.ALL) // Mapeamento de relacionamento "um para muitos" com o atributo lista Consulta
    private List<Consulta> atendimentos = new ArrayList<>();
    
    // Métodos sets e gets.
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
