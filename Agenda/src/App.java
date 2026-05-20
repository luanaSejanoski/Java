/* Biblioteca para leitura de dados do teclado e arquivos */
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
 
 
class App{
    public static void main(String[] args) throws Exception {
 
        /* Scanner para ler dados digitados pelo usuário */
        Scanner scanner = new Scanner(System.in);
 
        /* Lista que armazenará os contatos em memória */
        ArrayList<Contato> lista = new ArrayList<>();
 
        /* Representa o arquivo contatos.txt */
        File arquivo = new File("Agenda/contatos.txt");
 
        /* Verifica se o arquivo existe */
        if (arquivo.exists()) {
 
            /* Scanner usado para ler o arquivo */
            Scanner leitor = new Scanner(arquivo);
 
            /* Enquanto houver linhas no arquivo */
            while (leitor.hasNextLine()) {
 
                /* Lê uma linha completa */
                String linha = leitor.nextLine();
 
                /* Divide a linha usando ";" */
                String[] partes = linha.split(";");
 
                /* Guarda cada parte em variáveis */
                String nome = partes[0];
                String telefone = partes[1];
                String email = partes[2];
 
                /* Cria um objeto Contato e adiciona ao ArrayList */
                lista.add(new Contato(nome, telefone, email));
            }
 
            /* Fecha o leitor do arquivo */
            leitor.close();
        }
 
 
        /* Meunu principal */
        int opcao = 0;
 
        while (opcao != 3) {
 
            System.out.println("\n==== AGENDA ====\n");
            System.out.println("[1] Adicionar");
            System.out.println("[2] Listar");
            System.out.println("[3] Sair");
 
            System.out.print("\nEscolha uma opcao: ");
 
            /* Lê a opção digitada */
            opcao = scanner.nextInt();
 
            /* Limpa o ENTER do teclado */
            scanner.nextLine();
 
            /* Adicionar contato */
            if (opcao == 1) {
 
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
 
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();
 
                /* Adiciona um novo contato na lista */
                lista.add(new Contato(nome, telefone, email));
 
                System.out.println("Contato adicionado!");
            }
 
            /* Listar contatos */
            if (opcao == 2) {

                lista.sort(Comparator.comparing(Contato :: getNome));
 
                 /* Mostra os dados do contato */
                System.out.printf("\n%-5s | %-24s | %-15s | %-30s\n", "Nº", "Nome", "Telefone", "Email");

                int contador = 1;
                /* Percorre toda a lista */
                for (Contato c : lista) {
                    System.out.printf("%-5s | %-24s | %-15s | %-30s\n",
                        contador,
                        c.getNome(),
                        c.getTelefone(),
                        c.getEmail());
                
                    contador++;
                }
          
            }
        }
 
        /* Salvar os dados no arquivo 'contatos.txt' */
 
        /* Cria/escreve no arquivo contatos.txt */
        FileWriter writer = new FileWriter("Agenda/contatos.txt");
 
        /* Percorre todos os contatos da lista */
        for (Contato c : lista) {
            /* Salva no formato 'nome;telefone'*/
            writer.write(c.getNome() + ";" + c.getTelefone()+ ";" + c.getEmail() + "\n");
        }
 
        /* Fecha o arquivo */
        writer.close();
 
        System.out.println("Dados salvos!");
 
        /* Fecha o scanner do teclado */
        scanner.close();
    }
}
