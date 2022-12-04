package Contato;
public class Contato {
    private String nome;
    private String email;
    private String tel;

    public Contato (String nome, String email, String tel){
        this.nome = nome;
        this.email= email;
        this.tel = tel;
    }

    public String imprimeContato() {
        return "Nome: " + nome + "\nEmail: " + email + "\nTelefone: " + tel;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTel() {
        return tel;
    }
}
