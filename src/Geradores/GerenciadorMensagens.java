package Geradores;
import java.util.ArrayList;
import Dados.Consulta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GerenciadorMensagens {
    private ArrayList<Consulta> consultasAmanha = new ArrayList<>();
    /**
     * Envia uma mensagem para o paciente, avisando-o da consulta no dia seguinte.
     * Define se a pessoa tem ou não email/telefone, enviando as mensagens em correspondência a esses dados.
     */
    
    //MÉTODO CONSTRUTOR DEFAULT
    public GerenciadorMensagens() {
        
    }
    
    private void enviarMensagem() {
        /* Envia mensagem aos pacientes com consulta marcada para o dia seguinte,
        analisa se poderá enviar a mensagem por e-mail ou por telefone.
        O envio é registrado no terminal.
        */
        for(int i = 0; i < consultasAmanha.size(); i++) { //Para cada consulta da lista
            Consulta consul = consultasAmanha.get(i); 
            String mail = consul.getPaciente().getEmail(); //Pega as informações de contato do paciente da consulta
            String tel = consul.getPaciente().getTelefone(); //Telefone e E-mail
            if (mail != "") { //Se o paciente tem e-mail -> envia uma mensagem no e-mail.
                System.out.println("---------MENSAGEM: EMAIL-------\n-> " + mail);
                System.out.println("Paciente " + consul.getPaciente().getNome() + " sua consulta é amanhã, " + consul.getData() 
                    + ", às " + consul.getHorario() + "\nAguardamos você!\n");
            } if (tel != "") { //Se o paciente tem telefone -> envia uma mensagem no telefone.
                System.out.println("---------MENSAGEM: TELEFONE-------\n" + tel);
                System.out.println("Paciente " + consul.getPaciente().getNome() + " sua consulta é amanhã, " + consul.getData() 
                    + ", às " + consul.getHorario() + "\nAguardamos você!\n");
            }
        }
    }
    
    public void gerenciarMensagens(ArrayList<Consulta> listaConsultas) {
        /*
        Define para quais pacientes a mensagem será enviada, que são aqueles que tem 
        consulta marcada para o dia seguinte do dia atual.
        */
        LocalDate hoje = LocalDate.now(); // Obtém a data de hoje
        LocalDate amanha = hoje.plusDays(1); // Obtém a data de amanhã
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato de data que será usado para analisar as datas das consultas 

        for (Consulta consulta : listaConsultas) {
            LocalDate dataConsulta = LocalDate.parse(consulta.getData(), formatter); // Converte a data da consulta de String para LocalDate usando o formato definido
            if (dataConsulta.equals(amanha)) { // Verifica se a data da consulta é igual a amanhã
                consultasAmanha.add(consulta); // Se for, adiciona a consulta à lista de consultas que ocorrerão amanhã
            }
        }
        enviarMensagem(); //Chama o método que envia as mensagens
    }
    
}