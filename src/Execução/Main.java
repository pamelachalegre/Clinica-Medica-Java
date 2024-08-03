package Execução;
import Auxiliar.Busca;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import Dados.Consulta;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
        Inicialização de um armazenamento anterior de médicos, pacientes e consultas que podem ser alterados durante a execução.
        * Inicialização de uma secretária -> única e de único acesso possível.
        * Iniciaização do elemento para buscas nas listas.
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
        // criar mais alguns pacientes
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        Consulta con1 = new Consulta("14/09/2023", "15:00", listaMedicos.get(0), listaPacientes.get(0), 'N');
        Consulta con2 = new Consulta("02/08/2024", "15:00", listaMedicos.get(1), listaPacientes.get(0), 'N');
        listaConsultas.add(con1);
        listaConsultas.add(con2);
        // criar mais algumas consultas
        
        Secretaria secretaria = new Secretaria("MARIA GABRIELA"); //única
        
        Busca buscar = new Busca();
        
        Scanner input = new Scanner(System.in);
        System.out.printf("INSIRA O TIPO DE USUÁRIO: ");
        String usuario = input.nextLine().toUpperCase();
        if("SECRETARIA".equals(usuario)) {
            System.out.printf("-------------MODO SECRETÁRIA-------------\nInsira seu nome: ");
            if(input.nextLine().toUpperCase().equals(secretaria.getNome())) {
                System.out.println("O que deseja fazer:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Atualizar consulta;\n(6) Remover consulta;\n(7) Gerenciar consultas do dia seguinte;\n(8) Sair;");
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
                            boolean convenio = ("SIM".equals(input.next().toUpperCase())); // se a pessoa responder sim, conveio é true
                            secretaria.cadastrarPaciente(nome, cpf, rg, sexo, idade, dataNascimento, endereco, telefone, email, convenio, listaPacientes);
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
                                secretaria.atualizarPaciente(listaPacientes.get(i), atributo, novoDado);
                            }
                            break;
                        case 3: /*Exclusão de um paciente. Utiliza-se o CPF como identificador único.*/
                            System.out.println("Insira o CPF (xxx.xxx.xxx-xx) do paciente a ser removido:");
                            String identificador = input.next();
                            secretaria.removerPaciente(identificador, listaPacientes);
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
                                secretaria.cadastrarConsulta(listaConsultas, data, hora, listaMedicos.get(iMed), listaPacientes.get(iPac), tipo);
                            }
                            break;
                        case 5: //as unicas atualizações possíveis são data e horário, caso troque-se o médico ou paciente, cria-se uma nova consulta.
                            System.out.println("Insira a data, o horário e o CRM do médico da consulta (sem espaços):");
                            String id = input.next();
                            int iCon = buscar.acharConsulta(listaConsultas, id);
                            if(iCon != -1) {
                                System.out.println("Insira nova data:");
                                data = input.next();
                                System.out.println(data);
                                System.out.println("Insira novo horário:");
                                hora = input.next();
                                System.out.println(hora);
                                secretaria.atualizarConsultaDataHora(listaConsultas.get(iCon), data, hora);
                            }
                            break;
                        case 6:
                            System.out.println("Insira a data, horário e o CRM do médico da consulta (sem espaços):");
                            id = input.next();
                            iCon = buscar.acharConsulta(listaConsultas, id);
                            if(iCon != -1) {
                                secretaria.removerConsulta(listaConsultas, iCon);
                            }
                            break;
                        case 7: /*Lidar com as consultas do dia seguinte -> chamar o gerenciador de mensagens*/
                            secretaria.gerenciarMensagens(listaConsultas);
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA!");
                            break;
                    }
                    System.out.println("SELECIONE UMA AÇÃO:\n(1) Cadastrar paciente\n(2) Atualizar dados de um paciente;\n(3) Remover paciente;\n(4) Cadastrar nova consulta;\n(5) Atualizar consulta;\n(6) Remover consulta;\n(7) Gerenciar consultas do dia seguinte;\n(8) Sair;");
                    acao = input.nextInt();
                }
            } else {
                System.out.println("USUÁRIO INVÁLIDO!");
            }
        } 
        else {// se o usuário digitado não for SECRETARIA.
            if ("MEDICO".equals(usuario)) {
                System.out.println("----------MODO MÉDICO-----------\nInsira seu CRM: ");
                //Achando o objeto medico correto
                String crm = input.next();
                int iMed = buscar.acharCRM(crm, listaMedicos);
                if (iMed != -1) { // o médico existe
                    Medico medAtual = listaMedicos.get(iMed);
                    System.out.println("Selecione a ação:\n(1) Cadastrar dados do paciente;\n(2) Atualizar dados do paciente;\n(3) Cadastrar prontuário;\n(4) Atualizar prontuário;\n(5) Remover prontuário;\n(6) Gerar relatório;\n(7) Sair;");
                    int acao = input.nextInt();
                    while(acao != 7) {
                        switch(acao) {
                            case 1: /*Iniciar consulta - cadastrar dados do paciente*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx): ");
                                int iPac = buscar.acharCPF(input.next(), listaPacientes); // acha o íncide do paciente na lista de pacientes
                                if(iPac != -1) {
                                    Paciente pacAtual = listaPacientes.get(iPac);
                                    int iCon = buscar.acharConsulta(listaConsultas, pacAtual); //pacAtual é um Paciente, e não uma String de id
                                    System.out.printf("Insira os dados do paciente:\nFuma? ");
                                    boolean fumar = "SIM".equals(input.next().toUpperCase()); //trocar para uma expressão, pois a pessoa não vai inserir true ou false, mas sim ou não.
                                    System.out.println("Bebe álcool? ");
                                    boolean beber = "SIM".equals(input.next().toUpperCase());                                
                                    System.out.println("Possui colesterol alto? ");
                                    boolean colesterol = "SIM".equals(input.next().toUpperCase());
                                    System.out.println("Possui diabetes? ");
                                    boolean diabete = "SIM".equals(input.next().toUpperCase());
                                    System.out.println("Possui doença cardiovascular? ");
                                    boolean doencaCardio = "SIM".equals(input.next().toUpperCase());
                                    System.out.println("Possui alguma cirurgia? Se sim, quantas? ");
                                    int numCirurgias = input.nextInt();
                                    ArrayList<String> cirurgias;
                                    for (int i = 0; i == numCirurgias; i++) {
                                        System.out.println("Cirurgia número" + i + ":");
                                        String cirurgia = input.nextLine();
                                        pacAtual.setCirurgias(cirurgia);
                                    }
                                    System.out.println("Possui alguma alergia? Se sim, quantas? ");
                                    int numAlergias = input.nextInt();
                                    ArrayList<String> alergias;
                                    for (int i = 0; i == numAlergias; i++) {
                                        System.out.println("Alergia número" + i + ":");
                                        String alergia = input.nextLine();
                                        pacAtual.setAlergias(alergia);
                                    }
                                    medAtual.cadastrarDadosPaciente(listaConsultas.get(iCon), fumar, beber, colesterol, diabete, doencaCardio, cirurgias, alergias);
                                }
                                break;
                            case 2: /*Iniciar consulta - atualizar dados do paciente*/
                                System.out.println("Insira o CPF (xxx.xxx.xxx-xx) do paciente a ser alterado: ");
                                int i = buscar.acharCPF(input.next(), listaPacientes); //indice do paciente a ser alterado na lista
                                if(i != -1) {
                                    System.out.println("Campo de alteração: 'F' - fumar; 'B' - beber; 'C' - colesterol alto; 'D' - diabetes; 'H' - doença cardio; 'S' - cirurgias; 'A' - alergias.\nDigite uma das opções mostradas:");
                                    char atributo = input.next().charAt(0);
                                    System.out.printf("Insira o novo dado: ");
                                    input.nextLine(); // pega os espaços sobressalentes dos Scanners anteriores.
                                    String novoDado = input.nextLine();
                                    Paciente pacAtual = listaPacientes.get(i);
                                    medAtual.atualizarPaciente(pacAtual, atributo, novoDado);
                                }
                                break;
                            case 3: /*Cadastrar prontuário*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                iPac = buscar.acharCPF(input.next(), listaPacientes);
                                break;
                            case 4: /*Atualizar prontuário*/
                                break;
                            case 5: /*Remover prontuário*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                iPac = buscar.acharCPF(input.next(), listaPacientes);
                                
                                break;
                            case 6: /*Gerar relatório*/
                                System.out.println("Qual relatório será gerado? (OPÇÕES - 'A': Atestado, 'D': Declaração de Acompanhamento, 'R': Receita, 'N': Número de clientes atendidos):");
                                char relatorio = input.next().charAt(0);
                                //switch pra escolher qual tipo e qual tipo chamar -> pegar as informações específicas dentro do switch.
                                break;
                            default:
                                System.out.println("OPÇÃO INVÁLIDA!");
                        } //enquanto não digitar 7 -> saida, o while continua
                        System.out.println("Selecione a ação:\n(1) Cadastrar dados do paciente;\n(2) Atualizar dados do paciente;\n(3) Cadastrar prontuário;\n(4) Atualizar prontuário;\n(5) Remover prontuário;\n(6) Gerar relatório;\n(7) Sair;");
                        acao = input.nextInt();
                    }
                }
                
            }
        }
    }
}
