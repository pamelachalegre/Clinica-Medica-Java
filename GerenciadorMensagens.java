/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorMensagens;
import java.util.ArrayList;
import Dados.Consulta;
/**
 *
 * @author home
 */
public class GerenciadorMensagens {
    private ArrayList<Consulta> listaConsultasAmanha;
    private Consulta consulta;
    
    public void enviarMensagem() {
        System.out.println("---------MENSAGEM-------");
        System.out.println("Paciente " + consulta.getPaciente().getNome() + "sua consulta é dia " + consulta.getData() 
            + "às " + consulta.getHorario() + "\nAuardamos você!");
    }
    
}
