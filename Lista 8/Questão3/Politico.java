
 public class Politico extends Pessoa{
     private String siglas;
    private int numeroPartido;
    

    public Politico(String nome, long id, Data nascimento, String s, int n){
        super(nome, id, nascimento);
        siglas = s;
        numeroPartido = n;
        if(!verifica()){
            System.out.println("Erro, dados invalidos!!");
            System.exit(-1);
        }
    }

    public String getSiglas(){
        return siglas;
    }

    public int getNumeroPartido(){
        return numeroPartido;
    }

    public void setSiglas(String s){
        siglas = s;
    }

    public void setNumeroPartido(int n){
        numeroPartido = n;
    }

    private boolean verifica(){
        if(siglas == null){
            return false;
        }
        return true;
    }

    public String qualPartido(){
        return siglas;
    }

    @Override
    public String toString(){
        return "Politico\n" + super.toString() + "Siglas: " + siglas + "\nNumero do partido: " + numeroPartido + "\n";
    }
}

