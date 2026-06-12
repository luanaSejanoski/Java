 public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadePaginas;
    private int paginasLidas = 0;
    private boolean emprestado = false;

    public Livro(String titulo, String autor, int anoPublicacao, int quantidadePaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo.trim() == ""){
            System.out.println("Titulo não pode ser vazio!");
            return;
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor.trim() == ""){
            System.out.println("Nome do autor não pode ser vazio!");
            return;
        }
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if(anoPublicacao <= 0){
            System.out.println("Ano de publicação não pode ser negativo!");
            return;
        }
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        if(quantidadePaginas < 0){
            System.out.println("Quantidade de páginas não pode ser negativa!");
            return;
        }
        this.quantidadePaginas = quantidadePaginas;
    }

    public void emprestarLivro(){
        if(this.emprestado){
            System.out.println("Esse livro já está emprestado!");
            return;
        }
        this.emprestado = true;
    }
  
    public void devolverLivro(){
        if(!this.emprestado){
            System.out.println("Esse livro já está disponível na biblioteca!");
            return;
        }
        paginasLidas = 0;
        this.emprestado = false;
    }

    public void lerPaginas(int quant){
        if(quant <= 0){
            System.out.println("A quantidade de páginas deve ser maior que zero!");
            return;
        }
    
        if(this.paginasLidas + quant > this.quantidadePaginas){
            System.out.println("Você não pode ler mais páginas do que o livro possui!");
            return;
        }
    
        this.paginasLidas += quant;
    }

    public void calcularProgressoLivro(){
        if(quantidadePaginas < 0){
            System.out.println("Quantidade de páginas não pode ser negativa!");
            return;
        }
        double percentual = (double)paginasLidas / quantidadePaginas * 100;
        System.out.println("O percentual de leitura do livro " + titulo + " é de " + percentual + "%");
    }

    public void mostrarStatus(){
        if(!emprestado){
            System.out.println("O livro " + this.titulo + " já está disponível!\n");
            return;
        }
          System.out.println("O livro " +  this.titulo + " está emprestado e já teve " + this.paginasLidas + " páginas lidas de " + quantidadePaginas);
    }

    }
