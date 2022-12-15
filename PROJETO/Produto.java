
// Classe dos Produtos

public class Produto{ //classe pai
    // Atributos
    private String fornecedor;
    private String codigoBarras;
    private String nome;
    private Data vencimento;
    private int quantidade;

    
    // Construtores

    public Produto(String fornecedor, String codigo, String nome, int quantidade, int day, int month, int year){
        this.vencimento = new Data(day,month,year); //composição de classe
        this.fornecedor = fornecedor;
        this.codigoBarras = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }
    // Setters and getters

    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }

    public void setCodigoBarras(String codigo){
        this.codigoBarras = codigo;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public void setVencimento(Data validade){
        this.vencimento = validade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getFornecedor(){
        return this.fornecedor;
    }

    public String getCodigoBarras(){
        return this.codigoBarras;
    }

    public String getNome(){
        return this.nome;
    }

    public Data getVencimento(){
        return this.vencimento;
    }

    public int getQuantidade(){
        return this.quantidade;
    }


    // Métodos

   public String toString(){
        String str = "Nome: " + this.getNome();
        str += "\nCódigo de Barras: " + this.getCodigoBarras();
        str += "\nFornecedor: " + this.getFornecedor();
        str += "\nVencimento: " + vencimento.toStringShort(); //composição de classe
        str += "\nQuantidade: " + this.getQuantidade();
        return str;
    }
    //equals para verificar se o produto é igual ao produto passado como parametro
    public boolean equals(Produto produto){
        if(this.codigoBarras.equals(produto.getCodigoBarras())){
            return true;
        }else{
            return false;
        }
    }

    //verifica se o codigo de barras do produto é igual ao codigo de barras passado como parametro
    public boolean isProduto(String codigo){
        if(this.codigoBarras.equals(codigo)){
            return true;
        }else{
            return false;
        }
    }

 
  
    }
    

