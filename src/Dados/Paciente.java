package Dados;

// Importações necessárias
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity // Criação de uma tabela de Consulta no banco de dados com o mesmo nome da classe
public class Paciente {
    /*
     * É um POJO com os dados pessoais e de saúde de um paciente
     * Este objeto é manipulado pelo objeto Médico
     * Um paciente pode ser cadastrado, removido ou alterado
    */

    // Identificação por chaves primárias das classes Consulta inseridas no Banco de Dados
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    // Dados pessoais do paciente
    private String nome;
    private String cpf;
    private String rg;
    private char sexo; // 'F' = Feminino | 'M' = Masculino
    private int idade;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private boolean convenio; // true = convenio | false = particular
    
    @OneToOne(cascade = CascadeType.ALL)// Mapeamento de relacionamento "um para um" com o atributo prontuario.
    private Prontuario prontuario;
    
    // Dados de saúde do paciente
    private boolean fumar; // true = fumante | false = não é fumante
    private boolean beber; // true = bebe | false = não bebe
    private boolean colesterol; // true = possui colesterol alto | false = não possui colesterol alto 
    private boolean diabete; // true = possui diabetes | false = não possui diabetes
    private boolean doencaCardio; // true = possui doença cardíaca | false = não possui doença cardíaca
    private String cirurgias;
    private String alergias; 

    // Métodos Construtores
    public Paciente() {}
  
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
    
    // Sets e Gets dos atributos
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
        this.cirurgias = cirurgia;
    }
    
    public String getAlergias() {
        return alergias;
    }
    public void setAlergias(String alergia) {
        this.alergias = alergia;
    }
}
