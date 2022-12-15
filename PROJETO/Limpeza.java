//herança
public class Limpeza extends Produto{ //classe filha chama a classe pai
    private boolean limpeza; //atributo da classe filha
    
    //construtor
    public Limpeza(String fornecedor, String codigo, String nome, int day, int month, int year, int quantidade, boolean limpeza){
        super(fornecedor, codigo, nome, quantidade, day, month, year); //chama o construtor da classe pai
        this.limpeza = limpeza; //atributo da classe filha
    }
    
//setters e getters


    public void setLimpeza(boolean limpeza){
        this.limpeza = limpeza; 
    }
    
    public boolean getLimpeza(){
        return this.limpeza; 
    }

    
    public void setVencimento(int day, int month, int year){
        new Data(day,month,year); //chama o construtor da classe Data
    }

    public Data getValidade(){
        return this.getVencimento();
    }

        //metodos
    public boolean validaCodigoBarras(){
        if(this.getCodigoBarras().length() == 10){ //valida se tiver 10 digitos
            return true;
        }else{
            return false;
        }
    }

    //metodo toString
    public String toString(){
        String str = super.toString(); //chama o toString da classe pai
        str += "\nLimpeza: " + this.getLimpeza();
        return str;
    }

    
}


