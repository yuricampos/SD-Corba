import AgendaApp.*;
import java.util.Scanner;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class AgendaClient {

    static Agenda agendaImpl;

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is 
            // part of the Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Hello";
            agendaImpl = AgendaHelper.narrow(ncRef.resolve_str(name));

            // System.out.println("Obtained a handle on server object: " + agendaImpl);
            int loop = 1;
            Scanner entrada = new Scanner(System.in);
            while (loop == 1) {
                int opcao;
                menu();
                opcao = entrada.nextInt();
                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        consultar();
                        break;

                    case 3:
                        apagar();
                        break;

                    case 4:
                        loop = 0;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            }

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    public static void menu() {
        System.out.println("********************************");
        System.out.println("**Entre com a opcao desejada**");
        System.out.println("1 - Cadastrar / Atualizar Contato");
        System.out.println("2 - Consultar Contato");
        System.out.println("3 - Apagar Contato");
        System.out.println("4 - Finalizar Cliente");
        System.out.println("********************************");
    }

    public static void cadastrar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nome do contato: ");
        String nomeCadastro = entrada.nextLine();
        System.out.println("Telefone do contato: ");
        String telefoneContato = entrada.nextLine();
        if (agendaImpl.salvar(nomeCadastro, telefoneContato) == 1) {
            System.out.println("***Cadastrado com sucesso!!***");
        } else {
            System.out.println("***Cadastro já existe na base de dados!***");
            System.out.println("Deseja atualizar contato? ");
            System.out.println("1 - Sim ");
            System.out.println("2 - Não ");
            int atualizar = entrada.nextInt();
            if (atualizar == 1) {
                if (agendaImpl.atualizar(nomeCadastro, telefoneContato) == 1) {
                    System.out.println("Atualizado com sucesso!");
                } else {
                    System.out.println("***Erro ao atualizar***");
                }

            } else {
                System.out.println("***Contato não foi atualizado!***");
            }

        }

    }

    public static void consultar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nome do contato: ");
        String nomeConsulta;
        nomeConsulta = entrada.nextLine();
        String c1;
        c1 = agendaImpl.consultar(nomeConsulta);
        if (!c1.equals("nao")) {
            System.out.println("Dados do contato");
            System.out.println("Nome: " + nomeConsulta);
            System.out.println("Telefone: " + c1);
        } else {
            System.out.println("Contato não foi encontrado");
        }

    }

    public static void apagar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nome do contato: ");
        String nomeApagar;
        nomeApagar = entrada.nextLine();
        if (agendaImpl.apagar(nomeApagar) == 1) {
            System.out.println("Contato apagado com sucesso!");
        } else {
            System.out.println("Contato nao existe!");
        }

    }

}
