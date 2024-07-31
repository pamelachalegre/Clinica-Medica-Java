package GerenciadorMensagens;
import java.util.ArrayList;
import java.util.Iterator;
import Dados.Consulta;
import java.util.Date;

public class GerenciadorMensagens {
    private ArrayList<Consulta> consultasAmanha;
    /**
     * Envia uma mensagem para o paciente, avisando-o da consulta no dia seguinte.
     * Define se a pessoa tem ou não email/telefone, enviando as mensagens em correspondência a esses dados.
     * @param listaConsultasAmanha 
     */
    
    public void enviarMensagem(ArrayList<Consulta> listaConsultasAmanha) {
        Date hoje = new Date();
        for(int i = 0; i < consultasAmanha.size(); i++) {
            Consulta consul = consultasAmanha.get(i);
            Date consulData;
            
            String mail = consul.getPaciente().getEmail();
            String tel = consul.getPaciente().getTelefone();
            if (mail != "") {
                System.out.println("---------MENSAGEM: EMAIL-------\n-> " + mail);
                System.out.println("Paciente " + consul.getPaciente().getNome() + " sua consulta é amanhã, " + consul.getData() 
                    + ", às " + consul.getHorario() + "\nAguardamos você!");
            } if (tel != "") {
                System.out.println("---------MENSAGEM: TELEFONE-------\n" + tel);
                System.out.println("Paciente " + consul.getPaciente().getNome() + " sua consulta é amanhã, " + consul.getData() 
                    + ", às " + consul.getHorario() + "\nAguardamos você!");
            }
        }
    }
    
}