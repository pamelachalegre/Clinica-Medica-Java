package GerenciadorMensagens;
import java.util.ArrayList;
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
    
}