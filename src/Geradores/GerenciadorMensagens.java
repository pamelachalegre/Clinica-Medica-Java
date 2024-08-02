package Geradores;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Dados.Consulta;

public class GerenciadorMensagens {
    private ArrayList<Consulta> listaConsultasAmanha;
    private Consulta consulta;
    
    public void enviarMensagem(ArrayList<Consulta> listaConsultasAmanha) {
        for(int i = 0; i < listaConsultasAmanha.size(); i++) {
            Consulta consulta = listaConsultasAmanha.get(i);
            String mail = consulta.getPaciente().getEmail();
            String tel = consulta.getPaciente().getTelefone();
            if (mail != "") {
                System.out.println("---------MENSAGEM: EMAIL-------\n-> " + mail);
                System.out.println("Paciente " + consulta.getPaciente().getNome() + " sua consulta é amanhã, " + consulta.getData() 
                    + ", às " + consulta.getHorario() + "\nAguardamos você!");
            } if (tel != "") {
                System.out.println("---------MENSAGEM: TELEFONE-------\n" + tel);
                System.out.println("Paciente " + consulta.getPaciente().getNome() + " sua consulta é amanhã, " + consulta.getData() 
                    + ", às " + consulta.getHorario() + "\nAguardamos você!");
            }
        }
    }
    public void gerenciarMensagens(ArrayList<Consulta> listaConsultas) {
        LocalDate hoje = LocalDate.now(); // Obtém a data de hoje
        LocalDate amanha = hoje.plusDays(1); // Obtém a data de amanhã
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato de data que será usado para analisar as datas das consultas
        ArrayList<Consulta> listaConsultasAmanha = new ArrayList<>(); 

        for (Consulta consulta : listaConsultas) {
            LocalDate dataConsulta = LocalDate.parse(consulta.getData(), formatter); // Converte a data da consulta de String para LocalDate usando o formato definido
            if (dataConsulta.equals(amanha)) { // Verifica se a data da consulta é igual a amanhã
                listaConsultasAmanha.add(consulta); // Se for, adiciona a consulta à lista de consultas que ocorrerão amanhã
            }
        }
        enviarMensagem(listaConsultasAmanha);  
    }
}