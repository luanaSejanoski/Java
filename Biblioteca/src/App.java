
public class App {
    public static void main(String[] args) throws Exception {
        
      Livro l1 = new Livro("Java Basico", "João Silva", 2020, 200);
      
      Livro l2 = new Livro("POO na prática", "Maria Souza", 2022, 150);

      l1.emprestarLivro();
      l1.lerPaginas(100);
      l1.mostrarStatus();
      l1.lerPaginas(100);
      l1.mostrarStatus();
      l1.devolverLivro();
      l1.mostrarStatus();

      System.out.println("----------------------------------------------------------------");

      l2.setQuantidadePaginas(-8);
      l2.emprestarLivro();
      l2.mostrarStatus();
      l2.lerPaginas(45);
      l2.calcularProgressoLivro();
      l2.mostrarStatus();
      l2.devolverLivro();
      l2.emprestarLivro();
      l2.mostrarStatus();

    }

}


