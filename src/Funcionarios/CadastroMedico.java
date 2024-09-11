/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.persistence.Table;

/**
 *
 * @author home
 */
@Entity
@Table(name="MEDICO")
public class CadastroMedico {
    /*
    Forma POJO com os dados do médico.
    */
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String crm, nome, cpf;
    private double salario;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Consulta> atendimentos;
    

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
    
    public CadastroMedico(String nome, String cpf, double salario, String crm) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.crm = crm;
        this.atendimentos = new ArrayList<>();
    }
}
