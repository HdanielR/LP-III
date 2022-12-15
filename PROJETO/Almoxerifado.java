import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.*;

//Almoxerifado que é responsável por armazenar os produtos de limpeza
public class Almoxerifado implements Armazenar{
    private ArrayList<Limpeza> limpezas = new ArrayList<Limpeza>(); 

    //pegando a dataAtual do sistema
    ZoneId zid = ZoneId.of("America/Sao_Paulo"); //pegando o fuso horário do Brasil
    public final LocalDate dataAtual = LocalDate.now(zid); 
    
    //função adiciona um produto de limpeza no array se o código de barras for válido
    public void addLimpeza(Limpeza limpeza){
        if(limpeza.validaCodigoBarras()){
            limpezas.add(limpeza);
        }
    }
    //função que armazena um produto de limpeza no array
    public void armazenar(Produto produto){
        if(produto instanceof Limpeza){
            addLimpeza((Limpeza)produto);
        }
    }
     //função que remove um produto de limpeza do array
    public void desarmazenar(Produto produto){
        if(produto instanceof Limpeza){
            removeLimpeza(produto.getCodigoBarras());
        }
    }

    //função que retorna o produto de limpeza
    public Limpeza getLimpeza(String codigo){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                return limpeza;
            }
        }
        return null;
    }
    
    //função getQuantidade que retorna a quantidade de produtos de limpeza
    public int getQuantidade(String codigo){
        int quantidade = 0;
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){ 
                quantidade++;
            }
        }
        return quantidade;
    }
    
    //função getIndice que retorna o indice do produto de limpeza
    public int getIndice(String codigo){
        int indice = 0;
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                return indice;
            }
            indice++;
        }
        return -1;
    }


//função que retorna a data de vencimento do produto de limpeza
    public Data getVencimento(String codigo){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                return limpeza.getValidade();
            }
        }
        return null;
    }
    //função que retorna se o produto é de limpeza ou não
    public boolean isLimpeza(String codigo){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    //função que remove um produto de limpeza pelo código de barras
    public void removeLimpeza(String codigo){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                limpezas.remove(limpeza);
                break;
            }
        }
    }
    //função que adiciona a quantidade de produtos de limpeza
    public void addQuantidade(String codigo, int quantidade){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getCodigoBarras().equals(codigo)){
                limpeza.setQuantidade(limpeza.getQuantidade() + quantidade);
            }
        }
    }
    //função que printa os produtos de limpeza
    public void printLimpezas(){
        for(Limpeza limpeza : limpezas){
            System.out.println(limpeza);
        }
    }
    //remover produto de limpeza pelo nome
    public void removeLimpezaNome(String nome){
        for(Limpeza limpeza : limpezas){
            if(limpeza.getNome().equals(nome)){
                limpezas.remove(limpeza);
                break;
            }
        }
    }
    //função que printa o produto de limpeza com maior quantidade
    public void printMaiorQuantidade(){
        int maior = 0;
        for(Limpeza limpeza : limpezas){
            if(limpeza.getQuantidade() > maior){
                maior = limpeza.getQuantidade();
            }
        }
        for(Limpeza limpeza : limpezas){
            if(limpeza.getQuantidade() == maior){
                System.out.println(limpeza);
            }
        }
    }
    


public void printLimpezas(ArrayList<Limpeza> limpezas){
    for(Limpeza limpeza : limpezas){
        System.out.println(limpeza);
    }
}

//função get instance do calendar
public Calendar getInstance(){
    return Calendar.getInstance();
}

//função que remove os produtos de limpeza vencidos
public void removerLimpezasInvalidos(){
    ArrayList<Limpeza> limpezasInvalidas = new ArrayList<Limpeza>();
    for(Limpeza limpeza : limpezas){
        if(limpeza.getValidade().before(Calendar.getInstance())){
            limpezasInvalidas.add(limpeza);
        }
    }
    limpezas.removeAll(limpezasInvalidas);
}

//função que lista os produtos de limpeza vencidos e válidos
 public void listarLimpezaPorValidade(){
    ArrayList<Limpeza> limpezasValidas = new ArrayList<Limpeza>();//limpezas válidas
    ArrayList<Limpeza> limpezasInvalidas = new ArrayList<Limpeza>(); //limpezas vencidas
    Data data = new Data(dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear()); //data atual

    for(Limpeza limpeza : limpezas){
        if(limpeza.getVencimento().isPrevious((data))){ 
            limpezasValidas.add(limpeza);
        }else{
            limpezasInvalidas.add(limpeza);
        }
    }
    System.out.println("Limpezas Validas:");
    printLimpezas(limpezasValidas);
    System.out.println("Limpezas Invalidas:");
    printLimpezas(limpezasInvalidas);

}

    public String toString(){
        String str = "";
        for(Limpeza limpeza : limpezas){
            str += limpeza.toString() + "\n";
        }
        return str;
    }


}