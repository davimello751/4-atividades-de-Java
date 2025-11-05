import java.util.Scanner;

public class TesteAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n1 - Adicionar contatinho");
            System.out.println("2 - Buscar contatinho por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o "\n"

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    agenda.addContatinho(new Contatinho(nome, email, telefone, categoria));
                    System.out.println("Contatinho adicionado!");
                    break;

                case 2:
                    System.out.print("Digite o nome do contatinho que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();

                    // Salva a lista antes de buscar
                    agenda.salvarLista("agenda.txt");

                    Contatinho resultado = agenda.buscarContatinhoPorNome(nomeBusca, "agenda.txt");
                    if (resultado != null) {
                        System.out.println("Contatinho encontrado:");
                        System.out.println("Nome: " + resultado.getNome());
                        System.out.println("Email: " + resultado.getEmail());
                        System.out.println("Telefone: " + resultado.getTelefone());
                        System.out.println("Categoria: " + resultado.getCategoria());
                    } else {
                        System.out.println("Contatinho não encontrado!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}