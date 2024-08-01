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
        /*
        Inicialização de um armazenamento anterior de médicos, pacientes e consultas que podem ser alterados durante a execução.
        */
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        Medico med1 = new Medico("MEREDITH GREY", "28930");
        Medico med2 = new Medico("GEORGE O'MALLEY", "10293");
        Medico med3 = new Medico("IZZY STEVENS", "392912");
        Medico med4 = new Medico("CHRISTINA YANG", "39268");
        Medico med5 = new Medico("ALEX KAREV", "33980");
        Medico med6 = new Medico("DEREK SHEPERD", "193940");
        Medico med7 = new Medico("MARK SLOAN", "192803");
        listaMedicos.add(med1);
        listaMedicos.add(med2);
        listaMedicos.add(med3);
        listaMedicos.add(med4);
        listaMedicos.add(med5);
        listaMedicos.add(med6);
        listaMedicos.add(med7);
        
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        Paciente pac1 = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true);
        listaPacientes.add(pac1);
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        Consulta con1 = new Consulta("14/09/2023", "15:00", listaMedicos.get(0), listaPacientes.get(0), 'N');
        listaConsultas.add(con1);
        
        Busca buscar = new Busca();
        
        Scanner input = new Scanner(System.in);
        System.out.printf("INSIRA O TIPO DE USUÁRIO: ");
        String usuario = input.next();
        if("SECRETARIA".equals(usuario.toUpperCase())) {
            System.out.printf("------------MODO SECRETÁRIA-------------\nINSIRA SEU NOME: ");
            Secretaria sec = new Secretaria(input.next());
            System.out.println("SELECIONE UMA AÇÃO:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Remover consulta;\n(6) Gerenciar consultas do dia seguinte;\n(7) Sair;");
            int acao = input.nextInt();
            while(acao != 7) {
                switch(acao) {
                    case 1: /*Cadastro de um novo paciente*/
                        System.out.println("Insira os dados do paciente:\nNome:");
                        String nome = input.next();
                        System.out.println("CPF:");
                        String cpf = input.next();
                        System.out.println("RG:");
                        String rg = input.next();
                        System.out.println("Sexo:");
                        char sexo = input.next().charAt(0);
                        System.out.println("Idade:");
                        int idade = input.nextInt();
                        System.out.println("Data De Nascimento:");
                        String dataNascimento = input.next();
                        System.out.println("Endereço:");
                        String endereco = input.next();
                        System.out.println("Telefone:");
                        String telefone = input.next();
                        System.out.println("E-mail:");
                        String email = input.next();
                        System.out.println("Convênio:");
                        boolean convenio = input.nextBoolean();
                        sec.cadastrarPaciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio, listaPacientes);
                        break;
                    case 2:
                        System.out.println("Insira o CPF do paciente a ser alterado: ");
                        int i = buscar.acharCPF(input.next(), listaPacientes);
                        System.out.println("Insira o campo a ser alterado: ");
                        String atributo = input.next();
                        System.out.println("Insira o novo dado:");
                        if(atributo.equals("NOME")) {
                            nome = input.next();
                            sec.atualizarPacienteNome(listaPacientes.get(i), nome);
                        } else {
                            if(atributo.equals("ENDEREÇO")) {
                                
                            }
                            
                        }
                        break;
                    case 3: /*Exclusão de um paciente. Utiliza-se o CPF como identificador único.*/
                        System.out.println("Insira o CPF do paciente a ser removido:");
                        String identificador = input.next();
                        sec.removerPaciente(identificador, listaPacientes);
                        break;
                    case 4: /*Cadastrar uma nova consulta -> Marcar uma nova consulta*/
                        System.out.println("Insira os dados da consulta:\nData:");
                        String data = input.next();
                        System.out.println("Horário:");
                        String hora = input.next();
                        System.out.println("CRM do médico:");
                        String crm = input.next();
                        System.out.println("CPF do paciente:");
                        cpf = input.next();
                        System.out.println("Tipo da consulta:");
                        char tipo = input.next().charAt(0);
                        int iMed = buscar.acharCRM(crm, listaMedicos); /*Acha os índices dos objetos desejados*/
                        int iPac = buscar.acharCPF(cpf, listaPacientes);
                        if((iMed != -1)&&(iPac != -1)) { //SE médico E paciente existirem
                            sec.cadastrarConsulta(listaConsultas, data, hora, listaMedicos.get(iMed), listaPacientes.get(iPac), tipo);
                        }
                        break;
                    case 5:
                        System.out.println("Insira a data, horário e o CRM do médico da consulta (sem espaços):");
                        String id = input.next();
                        int iCon = buscar.acharConsulta(listaConsultas, id);
                        sec.removerConsulta(listaConsultas, iCon);
                        break;
                    case 6: /*Lidar com as consultas do dia seguinte -> chamar o gerenciador de mensagens*/
                        sec.gerenciarMensagens(listaConsultas);
                        break;
                    default:
                        System.out.println("Método inválido.");
                        break;
                }
                System.out.println("SELECIONE UMA AÇÃO:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Remover consulta;\n(6) Gerenciar consultas do dia seguinte;\n(7) Sair;");
                acao = input.nextInt();
            }
        } else {
            if ("MEDICO".equals(usuario.toUpperCase())) {
                System.out.println("----------MODO MÉDICO-----------");
                System.out.println("INSIRA SEU CRM:");
                //Achando o objeto medico correto
                String crm = input.next();
                
                //achar o medico certo na lista de médicos ????
                
                System.out.println("Selecione a ação:\n(1) Iniciar consulta - coletar dados do paciente;\n(2) Iniciar consulta - atualizar dados do paciente;");
                
                
                
                
            } else {
                System.out.println("usuário inválido");
            }
        }
        /*Medico dra_Pamela = new Medico("Pamela", "12893");
        Medico dra_Poli = new Medico("Poli", "29921");
        Paciente p_AnaPaula = new Paciente("Ana Paula", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005");
        
        
        Secretaria sec = new Secretaria("Silvia");
       
        ArrayList<String> alergias = new ArrayList<String>();
        ArrayList<String> cirurgias = new ArrayList<String>();
        alergias.add("Alergia1");
        alergias.add("Alergia2");
        
        sec.cadastrarPaciente("Caroline", "111.222.333-44", "11.222.333-4", "F", 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "", true, listaPacientes);//indice 1

        sec.cadastrarConsulta(listaConsultas, "14/09/2023", "15h00", listaMedicos.get(0), listaPacientes.get(0), 'N');
        
        med1.cadastrarDadosPaciente(listaConsultas.get(0), true, false, true, false, false, cirurgias, alergias);
        med1.cadastrarProntuario(listaConsultas.get(0), "sintomas", "diagnostico", "tratamento");
        
        System.out.println(listaPacientes.get(0).getProntuario().getSintomas());
        med1.atualizaProntuario(listaPacientes.get(0), "SINTOMAS", 'S');
        System.out.println(listaPacientes.get(0).getProntuario().getSintomas());
        
        System.out.println(med1.getPacientesAtendidos().get(0));*/  
        
    }
}