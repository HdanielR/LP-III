
public class Prefeito extends Politico {
    private String cidade;

    private boolean verifica() {
        if (cidade == null) {
            return false;
        }
        return true;
    }

    public Prefeito (String nome, long id, Data nascimento, String s, int n, String c) {
        super(nome, id, nascimento, s, n);
        cidade = c;
        if (!verifica()) {
            System.out.println("Erro, dados invalidos!!");
            System.exit(-1);
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
            return "Cidade\n" + super.toString() + "Cidade: " + cidade + "\n";
    }

  
}