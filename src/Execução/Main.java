/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
/**
 *
 * @author guijo
 */
public class Main {
    public static void main(String[] args) {
        Medico dr_rebola = new Medico();
        Paciente rebel = new Paciente("NOME", "CPF", "RG", 'S', 20, "NASC", "END", "TEL", "EMAIL", true);
        
        dr_rebola.cadastrarPaciente(rebel, true, false, true, false);
        
        Secretaria sec = new Secretaria();
        
        sec.cadastrarPaciente(rebel);
    }
}
