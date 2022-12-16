public class Governador extends Politico{

    private String estado;

    public Governador(String nome, long id, Data nascimento, String s, int n, String e) {
        super(nome, id, nascimento, s, n);
        estado = e;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   //faça um toString para governador com nome, id, nascimento, siglas, numeroPartido e estado
    @Override
    public String toString() {
        return "Governador\n" + super.toString() + "Estado: " + estado + "\n";
    }
 

}
    

