package utfpr.classcontrol.util;

import utfpr.classcontrol.model.Person;

import java.util.List;
import java.util.Scanner;

public class Hud {
    private static Scanner scan = new Scanner(System.in);

    public static int mainMenu() {
        System.out.println("Insira a opção que deseja executar:\n" +
                "1 - Cadastrar\n" +
                "2 - Listar\n" +
                "3 - Atualizar\n" +
                "4 - Remover\n" +
                "5 - Sair");

        return scan.nextInt();
    }

    public static Person create() {
        Person p = new Person();
        System.out.println("Nome: ");
        p.setName(scan.next());
        System.out.println("CPF: ");
        p.setCpf(scan.next());
        System.out.println("Idade: ");
        p.setAge(scan.nextInt());
        System.out.println("Contato: ");
        p.setContact(scan.next());
        System.out.println("Cidade: ");
        p.setCity(scan.next());
        System.out.println("Logradouro: ");
        p.setStreet(scan.next());
        System.out.println("Número: ");
        p.setNumber(scan.nextInt());
        showJobs();
        p.setJob(scan.nextInt());
        return p;
    }

    private static void showJobs() {
        System.out.println("Selecione uma das profissões: \n" +
                "1 - Médico\n" +
                "2 - Professor\n" +
                "3 - Desenvolvedor");
    }

    public static void listPersons(List<Person> ps) {
        // Imprime uma tabela formatada
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n", "NOME", "IDADE", "CPF", "CIDADE", "RUA", "NÚMERO", "CONTATO", "PROFISSÃO");
        for (Person p : ps) {
            System.out.printf(p.toString());
        }
    }

    public static String getCpf(String opt) {
        System.out.println("Insira o cpf da pessoa que deseja " + opt + ":");
        return scan.next();
    }

    public static Person update(Person p) {
        var opt = 0;

        // Atualiza os dados do objeto até que o usuário finalize a atualização
        do {
            System.out.println("Selecione a opção que deseseja alterar:\n"
                    + "1 - Nome - Atual: " + p.getName() + "\n"
                    + "2 - Cpf - Atual: " + p.getCpf() + "\n"
                    + "3 - Idade - Atual: " + p.getAge() + "\n"
                    + "4 - Contato - Atual: " + p.getContact() + "\n"
                    + "5 - Cidade - Atual: " + p.getCity() + "\n"
                    + "6 - Rua - Atual: " + p.getStreet() + "\n"
                    + "7 - Numero - Atual: " + p.getNumber() + "\n"
                    + "8 - Profissao - Atual: " + p.getJob() + "\n"
                    + "9 - Finalizar atualização");

            opt = scan.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Insira o novo nome: ");
                    p.setName(scan.next());
                    break;
                case 2:
                    System.out.println("Insira o novo CPF: ");
                    p.setCpf(scan.next());
                    break;
                case 3:
                    System.out.println("Insira a nova idade: ");
                    p.setAge(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Insira o novo contato: ");
                    p.setContact(scan.next());
                    break;
                case 5:
                    System.out.println("Insira a nova cidade: ");
                    p.setCity(scan.next());
                    break;
                case 6:
                    System.out.println("Insira a nova rua: ");
                    p.setStreet(scan.next());
                    break;
                case 7:
                    System.out.println("Insira o novo número: ");
                    p.setNumber(scan.nextInt());
                    break;
                case 8:
                    showJobs();
                    p.setJob(scan.nextInt());
                    break;
            }
        } while (opt != 9);

        return p;
    }
}
