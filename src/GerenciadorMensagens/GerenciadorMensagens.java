package GerenciadorMensagens;
import java.util.ArrayList;
import Dados.Consulta;

public class GerenciadorMensagens {
    private ArrayList<Consulta> listaConsultasAmanha;
    private Consulta consulta;
    
    public void enviarMensagem() {
        System.out.println("---------MENSAGEM-------");
        System.out.println("Paciente " + consulta.getPaciente().getNome() + "sua consulta é dia " + consulta.getData() 
            + "às " + consulta.getHorario() + "\nAuardamos você!");
    }
    
}