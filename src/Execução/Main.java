package Execução;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import Dados.Consulta;
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
        Consulta con2 = new Consulta("02/08/2024", "15:00", listaMedicos.get(1), listaPacientes.get(0), 'N');
        listaConsultas.add(con1);
        listaConsultas.add(con2);
        
        Busca buscar = new Busca();
        
        Scanner input = new Scanner(System.in);
        System.out.printf("INSIRA O TIPO DE USUÁRIO: ");
        String usuario = input.nextLine();
        if("SECRETARIA".equals(usuario.toUpperCase())) {
            System.out.printf("-------------MODO SECRETÁRIA-------------\nINSIRA SEU NOME: ");
            Secretaria sec = new Secretaria(input.nextLine());
            System.out.println(sec.getNome());
            System.out.println("SELECIONE UMA AÇÃO:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Atualizar consulta;\n(6) Remover consulta;\n(7) Gerenciar consultas do dia seguinte;\n(8) Sair;");
            int acao = input.nextInt();
            while(acao != 8) {
                switch(acao) {
                    case 1: /*Cadastro de um novo paciente*/
                        input.nextLine();
                        System.out.printf("Insira os dados do paciente:\nNome: ");
                        String nome = input.nextLine();
                        System.out.println("CPF (xxx.xxx.xxx-xx):");
                        String cpf = input.next();
                        System.out.println("RG (xx.xxx.xxx-x):");
                        String rg = input.next();
                        System.out.println("Sexo:");
                        char sexo = input.next().charAt(0);
                        System.out.println("Idade:");
                        int idade = input.nextInt();
                        System.out.println("Data De Nascimento:");
                        String dataNascimento = input.next();
                        System.out.println("Endereço:");
                        input.nextLine();
                        String endereco = input.nextLine();
                        System.out.println("Telefone:");
                        String telefone = input.next();
                        System.out.println("E-mail:");
                        String email = input.next();
                        System.out.println("Convênio:");
                        boolean convenio = input.nextBoolean();
                        sec.cadastrarPaciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio, listaPacientes);
                        break;
                    case 2:
                        System.out.println("Insira o CPF (xxx.xxx.xxx-xx) do paciente a ser alterado: ");
                        int i = buscar.acharCPF(input.next(), listaPacientes); //indice do paciente a ser alterado na lista
                        if(i != -1) {
                            System.out.println("Campo de alteração: 'N' - nome; 'S' - sexo; 'I' - idade; 'E' - endereço; 'T' - telefone; 'M' - email; 'C' - convênio.\nDigite uma das opções mostradas:");
                            char atributo = input.next().charAt(0);
                            System.out.printf("Insira o novo dado: ");
                            input.nextLine(); // pega os espaços sobressalentes dos Scanners anteriores.
                            String novoDado = input.nextLine();
                            sec.atualizarPaciente(listaPacientes.get(i), atributo, novoDado);
                        }
                        break;
                    case 3: /*Exclusão de um paciente. Utiliza-se o CPF como identificador único.*/
                        System.out.println("Insira o CPF (xxx.xxx.xxx-xx) do paciente a ser removido:");
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
                        System.out.println("CPF do paciente (xxx.xxx.xxx-xx):");
                        cpf = input.next();
                        System.out.println("Tipo da consulta:");
                        char tipo = input.next().charAt(0);
                        int iMed = buscar.acharCRM(crm, listaMedicos); /*Acha os índices dos objetos desejados*/
                        int iPac = buscar.acharCPF(cpf, listaPacientes);
                        if((iMed != -1)&&(iPac != -1)) { //SE médico E paciente existirem
                            sec.cadastrarConsulta(listaConsultas, data, hora, listaMedicos.get(iMed), listaPacientes.get(iPac), tipo);
                        }
                        break;
                    case 5: //as unicas atualizações possíveis são data e horário, caso troque-se o médico ou paciente, cria-se uma nova consulta.
                        System.out.println("Insira a data, o horário e o CRM do médico da consulta (sem espaços):");
                        String id = input.next();
                        int iCon = buscar.acharConsulta(listaConsultas, id);
                        if(iCon != -1) {
                            System.out.println("Insira nova data:");
                            data = input.next();
                            System.out.println("Insira novo horário:");
                            hora = input.next();
                            sec.atualizarConsultaDataHora(listaConsultas.get(iCon), data, hora);
                            System.out.println("Consulta remarcada!");
                        }
                        break;
                    case 6:
                        System.out.println("Insira a data, horário e o CRM do médico da consulta (sem espaços):");
                        id = input.next();
                        iCon = buscar.acharConsulta(listaConsultas, id);
                        if(iCon != -1) {
                            sec.removerConsulta(listaConsultas, iCon);
                        }
                        break;
                    case 7: /*Lidar com as consultas do dia seguinte -> chamar o gerenciador de mensagens*/
                        sec.gerenciarMensagens(listaConsultas);
                        break;
                    default:
                        System.out.println("Método inválido.");
                        break;
                }
                System.out.println("SELECIONE UMA AÇÃO:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Atualizar consulta;\n(6) Remover consulta;\n(7) Gerenciar consultas do dia seguinte;\n(8) Sair;");
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
                
    }
}