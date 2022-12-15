package Questão3;

//crie uma classe livro com metodos titulo, autor, numero de paginas, ano de Publicação

public class Livro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int numPaginas, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    
    public boolean isOlder(){
        if(anoPublicacao < 1980){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", numeroPaginas=" + numPaginas + ", anoPublicacao=" + anoPublicacao + '}';
    }
}

