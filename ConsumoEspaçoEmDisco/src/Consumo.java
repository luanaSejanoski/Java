/* Biblioteca para leitura de dados do teclado e arquivos */
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Consumo{
    public static void main(String[] args) throws Exception {
 
        /* Lista que armazenará os usuarios em memória */
        ArrayList<RegistroUsuario> lista = new ArrayList<>();
 
        /* Representa o arquivo consumo.txt */
        File arquivo = new File("ConsumoEspaçoEmDisco/consumo.txt");
 
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
                String usuario = partes[0];
                String espacoDisco = partes[1];
 
                /* Cria um objeto RegistroUsuario e adiciona ao ArrayList */
                lista.add(new RegistroUsuario(usuario, Double.parseDouble(espacoDisco)));
            }
 
            /* Fecha o leitor do arquivo */
            leitor.close();
   
        }
            double total = 0;
            for(RegistroUsuario r : lista){
                total += r.getEspacoDisco();
                
            }
               
                lista.sort(Comparator.comparing(RegistroUsuario :: getUsuario));
                 /* Mostra os dados do Registro do usuario */
                System.out.printf("\n%-5s  %-24s  %-19s  %-10s\n", "Nr.", "Usuario", "Espaço utilizado", "% de uso");
                System.out.println("-------------------------------------------------------------------");
                
                int contador = 1;
                /* Percorre toda a lista */
                for (RegistroUsuario r : lista) {

                    double porcentagem = (r.getEspacoDisco() / total) *100;

                    System.out.printf("%-5s | %-24s | %-16.2f MB | %-10.2f\n",
                        contador,
                        r.getUsuario(),
                        r.getEspacoDisco(),
                        porcentagem);
                
                    contador++;
                }

                double media = total / lista.size();

                System.out.println("-------------------------------------------------------------------");

                System.out.printf("Espaço total ocupado: %.2f MB\n", total);
                System.out.printf("Espaço médio ocupado: %.2f MB", media);

    }
}

