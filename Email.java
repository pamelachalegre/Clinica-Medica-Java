/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorMensagens;
/**
 *
 * @author home
 */
public class Email extends GerenciadorMensagens{
    private String enderecoEmail;
    
    @Override
    public void enviarMensagem() {
        System.out.println("-----------------------\nMensagem para :" + enderecoEmail
        + "\n Sua consulta será dia" + data + "às " + hora + "horas\n"
        + "Por favor, chegue com 15 minutos de antecedência. Aguardamos você!");
    }
}
