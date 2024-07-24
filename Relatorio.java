package Dados;

public class Relatorio {
    // é um POJO or is it?
    private String receita;

    public Relatorio(String receita, String atestado, String acompanhamento, int clientesMes) {
        this.receita = receita;
        this.atestado = atestado;
        this.acompanhamento = acompanhamento;
        this.clientesMes = clientesMes;
    }
    private String atestado;
    private String acompanhamento;
    private int clientesMes;

    public String getReceita() {
        return receita;
    }
    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getAtestado() {
        return atestado;
    }
    public void setAtestado(String atestado) {
        this.atestado = atestado;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }
    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public int getClientesMes() {
        return clientesMes;
    }
    public void setClientesMes(int clientesMes) {
        this.clientesMes = clientesMes;
    }   
}
