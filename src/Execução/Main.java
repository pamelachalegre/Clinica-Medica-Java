package Execução;
import Auxilia.Busca;
import Funcionarios.Medico;
import Funcionarios.Secretaria;
import Dados.Paciente;
import Dados.Consulta;
import Dados.Prontuario;
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
        Paciente pac1 = new Paciente("ANA PAULA", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true);
        Paciente pac2 = new Paciente("CARLOS SILVA", "222.333.444-55", "22.333.444-5", 'M', 25, "15/02/1999", "Rua das Flores, 456", "44 88888-8888", "carlos@exemplo.com", true);
        Paciente pac3 = new Paciente("MARIA SOUZA", "333.444.555-66", "33.444.555-6", 'F', 30, "07/11/1993", "Avenida Central, 789", "44 77777-7777", "maria@exemplo.com", true);
        Paciente pac4 = new Paciente("JOÃO OLIVEIRA", "444.555.666-77", "44.555.666-7", 'M', 40, "23/05/1983", "Rua Nova, 101", "44 66666-6666", "joao@exemplo.com", true);
        Paciente pac5 = new Paciente("FERNANDA LIMA", "555.666.777-88", "55.666.777-8", 'F', 35, "12/08/1988", "Avenida Paulista, 202", "44 55555-5555", "fernanda@exemplo.com", true);
        Paciente pac6 = new Paciente("PAULO MENDES", "666.777.888-99", "66.777.888-9", 'M', 28, "30/01/1996", "Rua Principal, 303", "44 44444-4444", "paulo@exemplo.com", true);
        Paciente pac7 = new Paciente("JULIANA COSTA", "777.888.999-00", "77.888.999-0", 'F', 22, "19/06/2001", "Avenida Secundária, 404", "44 33333-3333", "juliana@exemplo.com", true);
        listaPacientes.add(pac1);
        listaPacientes.add(pac2);
        listaPacientes.add(pac3);
        listaPacientes.add(pac4);
        listaPacientes.add(pac5);
        listaPacientes.add(pac6);
        listaPacientes.add(pac7);
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        Consulta con1 = new Consulta("14/09/2023", "15:00", listaMedicos.get(0), listaPacientes.get(0), 'N');
        Consulta con2 = new Consulta("02/08/2024", "15:00", listaMedicos.get(1), listaPacientes.get(0), 'N');
        Consulta con3 = new Consulta("05/10/2023", "10:00", listaMedicos.get(2), listaPacientes.get(1), 'N');
        Consulta con4 = new Consulta("16/11/2023", "11:00", listaMedicos.get(3), listaPacientes.get(2), 'N');
        Consulta con5 = new Consulta("28/12/2023", "14:00", listaMedicos.get(4), listaPacientes.get(3), 'R');
        Consulta con6 = new Consulta("07/01/2024", "09:00", listaMedicos.get(5), listaPacientes.get(4), 'R');
        Consulta con7 = new Consulta("18/02/2024", "13:00", listaMedicos.get(6), listaPacientes.get(5), 'R');
        listaConsultas.add(con1);
        listaConsultas.add(con2);
        listaConsultas.add(con3);
        listaConsultas.add(con4);
        listaConsultas.add(con5);
        listaConsultas.add(con6);
        listaConsultas.add(con7);
        
        Secretaria secretaria = new Secretaria("MARIA GABRIELA"); // unica
        
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
                                    int iCon = buscar.acharConsulta(listaConsultas, pacAtual);
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
                                    ArrayList<String> cirurgias = new ArrayList<>();
                                    for (int i = 0; i == numCirurgias; i++) {
                                        System.out.println("Cirurgia número" + i + ":");
                                        String cirurgia = input.nextLine();
                                        pacAtual.setCirurgias(cirurgia);
                                    }
                                    System.out.println("Possui alguma alergia? Se sim, quantas? ");
                                    int numAlergias = input.nextInt();
                                    ArrayList<String> alergias = new ArrayList<>();
                                    for (int i = 0; i == numAlergias; i++) {
                                        System.out.println("Alergia número" + i + ":");
                                        String alergia = input.nextLine();
                                        pacAtual.setAlergias(alergia);
                                    }
                                    medAtual.cadastrarDadosPaciente(listaConsultas.get(iCon), fumar, beber, colesterol, diabete, doencaCardio, cirurgias, alergias);
                                }
                                System.out.println("PACIENTE CADASTRADO COM SUCESSO!");
                                break;
                            case 2: /*Iniciar consulta - atualizar dados do paciente*/
                                System.out.println("Insira o CPF (xxx.xxx.xxx-xx) do paciente a ser alterado: ");
                                int i = buscar.acharCPF(input.next(), listaPacientes);
                                if(i != -1) {
                                    System.out.println("Campo de alteração: 'F' - fumar; 'B' - beber; 'C' - colesterol alto; 'D' - diabetes; 'H' - doença cardio; 'S' - cirurgias; 'A' - alergias.\nDigite uma das opções mostradas:");
                                    char atributo = input.next().charAt(0);
                                    System.out.printf("Insira o novo dado: ");
                                    input.nextLine(); // pega os espaços sobressalentes dos Scanners anteriores.
                                    String novoDado = input.nextLine();
                                    Paciente pacAtual = listaPacientes.get(i);
                                    medAtual.atualizarPaciente(pacAtual, atributo, novoDado);
                                }
                                System.out.println("DADOS DO PACIENTE ATUALIZADOS COM SUCESSO!");
                                break;
                            case 3: /*Cadastrar prontuário*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                iPac = buscar.acharCPF(input.next(), listaPacientes);
                                Paciente pacAtual = listaPacientes.get(iPac);
                                int iCon = buscar.acharConsulta(listaConsultas, pacAtual);
                                System.out.println("Quais são os sintomas? ");
                                input.nextLine(); //pega quebras de linha sobressalentes
                                String sintomas = input.nextLine();
                                System.out.println("Qual é o diagnóstico? ");
                                String diagnostico = input.nextLine();
                                System.out.println("Qual é o tratamento? ");
                                String tratamento = input.nextLine();
                                medAtual.cadastrarProntuario(listaConsultas.get(iCon), sintomas, diagnostico, tratamento);
                                System.out.println("PRONTUÁRIO CADASTRADO COM SUCESSO!");
                                break;
                            case 4: /*Atualizar prontuário*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                iPac = buscar.acharCPF(input.next(), listaPacientes);
                                pacAtual = listaPacientes.get(iPac);
                                iCon = buscar.acharConsulta(listaConsultas, pacAtual);
                                System.out.println("Campo de alteração: 'S' - sintomas; 'D' - diagnostico; 'T' - tratamento\nDigite uma das opções mostradas:");
                                char mudanca = input.next().charAt(0);
                                System.out.printf("Insira o novo dado: ");
                                input.nextLine(); // pega os espaços sobressalentes dos Scanners anteriores
                                String atualizacao = input.nextLine();
                                medAtual.atualizarProntuario(pacAtual, atualizacao, mudanca);
                                System.out.println("PRONTUÁRIO ATUALIZADO COM SUCESSO!");
                                break;
                            case 5: /*Remover prontuário*/
                                System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                iPac = buscar.acharCPF(input.next(), listaPacientes);
                                pacAtual = listaPacientes.get(iPac);
                                medAtual.removerProntuario(pacAtual);
                                System.out.println("PRONTUÁRIO REMOVIDO COM SUCESSO!");
                                break;
                            case 6: /*Gerar relatório*/
                                System.out.println("Qual relatório será gerado? (OPÇÕES - 'A': Atestado, 'D': Declaração de Acompanhamento, 'R': Receita, 'N': Número de clientes atendidos):");
                                char relatorio = input.next().charAt(0);
                                switch(relatorio){
                                    case 'A':
                                        System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                        iPac = buscar.acharCPF(input.next(), listaPacientes);
                                        pacAtual = listaPacientes.get(iPac);
                                        System.out.println("Quantos dias de afastamento?");
                                        int dias = input.nextInt();
                                        System.out.println("Qual a data de início?");
                                        String dataInicio = input.next();
                                        medAtual.criarEImprimirAtestado(medAtual, pacAtual, pacAtual.getProntuario(), dias, dataInicio);
                                        break;
                                    case 'D':
                                        System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                        iPac = buscar.acharCPF(input.next(), listaPacientes);
                                        pacAtual = listaPacientes.get(iPac);
                                        System.out.println("Insira a data:");
                                        String data = input.next();
                                        System.out.println("Insira o nome do acompanhante:");
                                        input.nextLine(); //pega quebras de linha sobressalentes
                                        String acompanhante = input.nextLine();
                                        System.out.println("Qual o parentesco do acompanhante?");
                                        String parentesco = input.next();                                      
                                        medAtual.gerarDeclaracao(medAtual, pacAtual, pacAtual.getProntuario(), data, parentesco, acompanhante);
                                        break;
                                    case 'R':
                                        System.out.println("Insira o CPF do paciente (xxx.xxx.xxx-xx):");
                                        iPac = buscar.acharCPF(input.next(), listaPacientes);
                                        pacAtual = listaPacientes.get(iPac);
                                        System.out.println("Qual o remédio?");
                                        input.nextLine(); //pega quebras de linha sobressalentes
                                        String remedio = input.nextLine();
                                        System.out.println("Qual a dosagem?");
                                        float dose = input.nextFloat();
                                        input.nextLine(); //pega quebras de linha sobressalentes
                                        String uso = input.nextLine();
                                        System.out.println("Quantas vezes ao dia?");
                                        int vezes = input.nextInt();
                                        medAtual.criarReceita(medAtual, pacAtual, remedio, dose, uso, vezes);
                                        break;
                                    case 'N':
                                        System.out.println("Insira o ano desejado (XXXX):");
                                        int ano = input.nextInt();
                                        System.out.println("Insira o mês (1 - 12):");
                                        int mes = input.nextInt();
                                        medAtual.clientesAtendidos(medAtual.getPacientesAtendidos(), mes, ano);
                                        break;
                                    default:
                                        System.out.println("CAMPO INVÁLIDO!");
                                        break;
                                }
                                break;
                            default:
                                System.out.println("OPÇÃO INVÁLIDA!");
                        } //enquanto não digitar 7 -> saida, o while continua
                        System.out.println("Selecione a ação:\n(1) Cadastrar dados do paciente;\n(2) Atualizar dados do paciente;\n(3) Cadastrar prontuário;\n(4) Atualizar prontuário;\n(5) Remover prontuário;\n(6) Gerar relatório;\n(7) Sair;");
                        acao = input.nextInt();
                    }
                }
            } else {
                System.out.println("USUÁRIO INVÁLIDO!");
            }
        }
    }
}
