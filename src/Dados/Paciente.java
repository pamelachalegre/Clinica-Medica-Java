package Dados;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Paciente {
    /**
     * Definido como um POJO, possui diversos atributos que são modificados por meio de sets e gets, outras ações sobre
     * esses objetos podem ser efetuadas por outros tipos de objeto com métodos que acessam os sets e gets deste.
     * A utilização de listas para os atriutos de Alergias e Cirurgias se deve a quantidade varávele e mutável desses.
     * Por esse motivo, utilizamos o Arraylist, que permite uma alocação de memória dinâmica, mas de menor ocupação da memória.
    */
    //DADOS CADASTRAIS:
    //@Id @GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;

    private String nome;
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String cpf;
    private String rg;
    private char sexo;
    private int idade;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private boolean convenio; // true = convenio | false = particular
    
    @OneToOne(cascade = CascadeType.ALL)
    private Prontuario prontuario;
    
    //DADOS DE SAÚDE:
    private boolean fumar;
    private boolean beber;
    private boolean colesterol;
    private boolean diabete;
    private boolean doencaCardio;
    private String cirurgias;
    private String alergias; 

    public Paciente() {    }

    //MÉTODO CONSTRUTOR:
    public Paciente(String nome, String cpf, String rg, char sexo, int idade, String dataNascimento, String endereco, String telefone, String email, boolean convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getConvenio() {
        return convenio;
    }
    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public boolean isFumar() {
        return fumar;
    }
    public void setFumar(boolean fumar) {
        this.fumar = fumar;
    }

    public boolean isBeber() {
        return beber;
    }
    public void setBeber(boolean beber) {
        this.beber = beber;
    }

    public boolean isColesterol() {
        return colesterol;
    }
    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }
    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardio() {
        return doencaCardio;
    }
    public void setDoencaCardio(boolean doencaCardio) {
        this.doencaCardio = doencaCardio;
    }
    
    public String getCirurgias() {
        return cirurgias;
    }
    
    public void setCirurgias(String cirurgia) {
        this.cirurgias = cirurgia; //SETA AS NOVAS CIRURGIAS.
    }
    
    public String getAlergias() {
        return alergias;
    }
    
    public void setAlergias(String alergia) {
        this.alergias = alergia; //SETA AS NOVAS ALERGIAS.
    }
}