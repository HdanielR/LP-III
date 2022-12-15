import java.util.Calendar;

//herança
public class Alimento extends Produto{ //classe filho
    private boolean alimento; //atributo

//construtor
    public Alimento(String fornecedor, String codigo, String nome, int day, int month, int year, int quantidade, boolean alimento){
        super(fornecedor, codigo, nome, quantidade, day, month, year); //chama o construtor da classe pai
        this.alimento = alimento; //atributo da classe filho
    } 


//setters e getters
    public void setVencimento(int day, int month, int year){
        new Data(day,month,year); //chama o construtor da classe Data
    }

    public void setAlimento(boolean alimento){
        this.alimento = alimento;
    }
    
    public boolean getAlimento(){
        return this.alimento;
    }


    public Data getValidade(){
        return this.getVencimento();
    }


//metodos

 public boolean validaCodigoBarras(){
    if(this.getCodigoBarras().length() == 9){ //valida se tiver 9 digitos
        return true;
    }else{
        return false;
    }
}
   //metodo para verificar se o produto é de alimento
public static boolean verificaAlimento(Produto p){
    if(p instanceof Alimento){
        return true;
    }else{
        return false;
    }
}


//metodo toString
    public String toString(){
        String str = super.toString(); //chama o toString da classe pai
        str += "\nAlimento: " + this.getAlimento();
        return str;
    }
    //metodo para verificar se o alimento está vencido
    public Data getVencimentoAlimento(){
        if(this.getAlimento() == true){
            return this.getVencimento();
        }else{
            return null;
        }

    }
}
