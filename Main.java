package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import Dados.Consulta;
import GerenciadorMensagens.GerenciadorMensagens;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Paciente> listaPacientes = new ArrayList();
        ArrayList<Consulta> listaConsultas = new ArrayList();
        ArrayList<Consulta> inicia = new ArrayList<Consulta>();
        
        Medico med1 = new Medico("MEREDITH GREY", "28930", inicia);
        Medico med2 = new Medico("GEORGE O'MALLEY", "10293", inicia);
        Medico med3 = new Medico("IZZY STEVENS", "392912", inicia);
        Medico med4 = new Medico("CHRISTINA YANG", "39268", inicia);
        Medico med5 = new Medico("ALEX KAREV", "33980", inicia);
        Medico med6 = new Medico("DEREK SHEPERD", "193940", inicia);
        Medico med7 = new Medico("MARK SLOAN", "192803", inicia);
        
        Medico[] listaMedicos = {med1, med2, med3, med4, med5, med6, med7}; // uma lista com todos os médicos da clínica
        /*
        Scanner input = new Scanner(System.in);
        System.out.printf("INSIRA O TIPO DE USUÁRIO: ");
        String usuario = input.next();
        if("SECRETARIA".equals(usuario) | "secretaria".equals(usuario)) {
            System.out.printf("--------MODO SECRETÁRIA---------\nINSIRA SEU NOME: ");
            Secretaria sec = new Secretaria(input.next());
            System.out.println("(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Remover consulta;\n(6) Gerenciar consultas do dia seguinte;\n(7) Sair;");
            int acao = input.nextInt();
            while(acao != 7) {
                switch(acao) {
                    case 1:
                        System.out.println("Insira os dados do paciente (nome, CPF, RG, sexo, idade, dataNascimento, endereco, telefone, email e convenio) separados por <ENTER>");
                        String nome = input.nextLine();
                        String cpf = input.nextLine();
                        String rg = input.nextLine();
                        String sexo = input.nextLine();
                        int idade = input.nextInt();
                        String dataNascimento = input.nextLine();
                        String endereco = input.nextLine();
                        String telefone = input.nextLine();
                        String email = input.nextLine();
                        boolean convenio = input.nextBoolean();
                        sec.cadastrarPaciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio, listaPacientes);
                        break;
                    case 3:
                        System.out.println("Insira o CPF do paciente a ser removido:");
                        String identificador = input.nextLine();
                        sec.removerPaciente(identificador, listaPacientes);
                        break;
                    default:
                        System.out.println("Método inválido.");
                        break;
                }
            }
        } else {
            if ("MEDICO".equals(usuario) | "medico".equals(usuario)) {
                System.out.println("----------MODO MÉDICO-----------");
                System.out.println("INSIRA SEU CRM:");
                //Achando o objeto medico correto
                String crm = input.nextLine();
                Medico med;
                //achar o medico certo na lista de médicos ????
                
                System.out.println("Selecione a ação:\n(1) Iniciar consulta - coletar dados do paciente;\n(2) Iniciar consulta - atualizar dados do paciente;");
                int operacao = input.nextInt();
                
                
                
            } else {
                System.out.println("usuário inválido");
            }
        } */
        /*Medico dra_Pamela = new Medico("Pamela", "12893");
        Medico dra_Poli = new Medico("Poli", "29921");
        Paciente p_AnaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");
        */
        
        Secretaria sec = new Secretaria("Silvia");
       
        ArrayList<String> alergias = new ArrayList<String>();
        ArrayList<String> cirurgias = new ArrayList<String>();
        alergias.add("Alergia1");
        alergias.add("Alergia2");
        
        sec.cadastrarPaciente("Ana Paula", "111.222.333-44", "11.222.333-4", "F", 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true, listaPacientes); //indice 0
        sec.cadastrarPaciente("Caroline", "111.222.333-44", "11.222.333-4", "F", 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "", true, listaPacientes);//indice 1

        sec.cadastrarConsulta(listaConsultas, "14/09/2023", "15h00", listaMedicos[0], listaPacientes.get(0), 'N');
        
        med1.cadastrarDadosPaciente(listaConsultas.get(0), true, false, true, false, false, cirurgias, alergias);
        med1.cadastrarProntuario(listaConsultas.get(0), "sintomas", "diagnostico", "tratamento");
        
        System.out.println(listaPacientes.get(0).getProntuario().getSintomas());
        med1.atualizaProntuario(listaPacientes.get(0), "SINTOMAS", 'S');
        System.out.println(listaPacientes.get(0).getProntuario().getSintomas());

    
        
    }
}