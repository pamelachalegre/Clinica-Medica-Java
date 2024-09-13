package Execução;

// Importações necessárias
import Dados.Consulta;
import Dados.Paciente;
import Funcionarios.CadastroMedico;
import Interfaces.MenuPrincipal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
        
        // Cria e gerencia as instâncias
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
        
        // Gerencia as entidades e realiza operações de persistência (inserir, atualizar, deletar e buscar) no banco de dados
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin(); // Inicia uma transação no contexto do EntityManager
        
        // Busca pelo registro de ID 1 -> no caso um médico, pois ele é o primeiro a ser enviado ao banco nas persistências
        CadastroMedico achou = em.find(CadastroMedico.class, 1);
        
        if(achou == null) {
            /*
            * Se o ID 1 não foi encontrado, então o banco de dados (tabelas) está vazio, ou seja, é o primeiro uso
            * Portanto, objetos são criados para preencher o banco inicialmente com 7 Médicos, 7 Pacientes e 7 Consultas
            */
        
            // Criação de pacientes iniciais
            Paciente pac1 = new Paciente("ANA PAULA", "111.222.333-44", "11.222.333-4", 'F', 18, "03/09/2005", "Avenida Maringá, 123", "44 99999-9999", "usuario@exemplo.com", true);
            Paciente pac2 = new Paciente("CARLOS SILVA", "222.333.444-55", "22.333.444-5", 'M', 25, "15/02/1999", "Rua das Flores, 456", "44 88888-8888", "carlos@exemplo.com", true);
            Paciente pac3 = new Paciente("MARIA SOUZA", "333.444.555-66", "33.444.555-6", 'F', 30, "07/11/1993", "Avenida Central, 789", "44 77777-7777", "maria@exemplo.com", true);
            Paciente pac4 = new Paciente("JOÃO OLIVEIRA", "444.555.666-77", "44.555.666-7", 'M', 40, "23/05/1983", "Rua Nova, 101", "44 66666-6666", "joao@exemplo.com", true);
            Paciente pac5 = new Paciente("FERNANDA LIMA", "555.666.777-88", "55.666.777-8", 'F', 35, "12/08/1988", "Avenida Paulista, 202", "44 55555-5555", "fernanda@exemplo.com", true);
            Paciente pac6 = new Paciente("PAULO MENDES", "666.777.888-99", "66.777.888-9", 'M', 28, "30/01/1996", "Rua Principal, 303", "44 44444-4444", "paulo@exemplo.com", true);
            Paciente pac7 = new Paciente("JULIANA COSTA", "777.888.999-00", "77.888.999-0", 'F', 22, "19/06/2001", "Avenida Secundária, 404", "44 33333-3333", "juliana@exemplo.com", true);
            // Criação de médicos iniciais
            CadastroMedico med1 = new CadastroMedico("MEREDITH GREY", "111.111.111-11", 11.111, "28930");
            CadastroMedico med2 = new CadastroMedico("GEORGE O'MALLEY", "222.222.222-22", 22.222, "10293");
            CadastroMedico med3 = new CadastroMedico("IZZY STEVENS", "333.333.333-33", 33.333, "392912");
            CadastroMedico med4 = new CadastroMedico("CHRISTINA YANG", "444.444.444-44", 44.444, "39268");
            CadastroMedico med5 = new CadastroMedico("ALEX KAREV", "555.555.555-55", 55.555, "33980");
            CadastroMedico med6 = new CadastroMedico("DEREK SHEPERD", "666.666.666-66", 66.666, "193940");
            CadastroMedico med7 = new CadastroMedico("MARK SLOAN", "777.777.777-77", 77.777, "192803");
            // Criação de consultas iniciais
            Consulta con1 = new Consulta("14/09/2023", "15:00", med1, pac1, 'N');
            Consulta con2 = new Consulta("02/08/2024", "15:00", med2, pac1, 'N');
            Consulta con3 = new Consulta("05/10/2023", "10:00", med3, pac2, 'N');
            Consulta con4 = new Consulta("16/11/2023", "11:00", med4, pac3, 'N');
            Consulta con5 = new Consulta("28/12/2023", "14:00", med5, pac4, 'R');
            Consulta con6 = new Consulta("07/01/2024", "09:00", med6, pac5, 'R');
            Consulta con7 = new Consulta("18/02/2024", "13:00", med7, pac6, 'R');

            // Marca um grupo de médicos para o banco de dados
            em.persist(med1);
            em.persist(med2);
            em.persist(med3);
            em.persist(med4);
            em.persist(med5);
            em.persist(med6);
            em.persist(med7);
            // Marca um grupo de pacientes para o banco de dados
            em.persist(pac1);
            em.persist(pac2);
            em.persist(pac3);
            em.persist(pac4);
            em.persist(pac5);
            em.persist(pac6);
            em.persist(pac7);
            // Marca um grupo de consultas para o banco de dados -> tabela "CONSULTA"
            em.persist(con1);
            em.persist(con2);
            em.persist(con3);
            em.persist(con4);
            em.persist(con5);
            em.persist(con6);
            em.persist(con7);

            em.getTransaction().commit(); // Confirma a transação no banco de dados
            
            MenuPrincipal menu = new MenuPrincipal(em); // Interface do Menu Principal
            menu.setVisible(true);
            
        } else { // O banco já possui dados, portanto, segue-se com possíveis alterações
            em.getTransaction().commit(); // Encerra o begin aberto para a busca
            MenuPrincipal menu = new MenuPrincipal(em);
            menu.setVisible(true);
        }
        
    }
}
