import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.*;
import java.util.*;

//Estoque que é responsável por armazenar os alimentos
public class Estoque implements Armazenar { //implementando a interface Armazenar
    private ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
    
    //pegando a dataAtual do sistema
    ZoneId zid = ZoneId.of("America/Sao_Paulo"); //pegando o fuso horário do Brasil
    public final LocalDate dataAtual = LocalDate.now(zid);   

    
    public boolean validaCodigoBarras(String codigo){
        if(codigo.length() == 9){
            return true; //valida se tiver 9 digitos, se não tiver, retorna false
        }
        return false;
    }
   
    //função que adiciona um alimento no array se o código de barras for válido
    public void addAlimento(Alimento alimento){
        if(alimento.validaCodigoBarras()){
            alimentos.add(alimento);
        }
    }
    
    //função que retorna a data de validade
    public Data getValidade(String codigo){
        for(Alimento alimento : alimentos){ //percorre o arraylist de alimentos
            if(alimento.getCodigoBarras().equals(codigo)){ 
                return alimento.getValidade(); 
            }
        } 
        return null; 
    }

    //função que retorna a data atual
    public Calendar getInstance(){
        return Calendar.getInstance();
    }
    
    //função que retorna o alimento
    public Alimento getAlimento(String codigo){ 
        for(Alimento alimento : alimentos){ 
            if(alimento.getCodigoBarras().equals(codigo)){ 
                return alimento; 
            }
        }
        return null;
    }
    
    //função que retorna a quantidade de alimentos
    public int getQuantidade(String codigo){ 
        int quantidade = 0; 
        for(Alimento alimento : alimentos){ 
            if(alimento.getCodigoBarras().equals(codigo)){  
                quantidade++;
            }
        }
        return quantidade;
    }

    
    //printa quantidade de alimentos
    public static void printQuantidade(ArrayList<Alimento> alimentos){
        for(Alimento alimento : alimentos){
            System.out.println(alimento.getQuantidade()); 
        }
    }

    //função que retorna o indice do alimento
    public int getIndice(String codigo){
        int indice = 0;
        for(Alimento alimento : alimentos){ 
            if(alimento.getCodigoBarras().equals(codigo)){
                return indice;
            }
            indice++;
        }
        return -1;
    }

    
    //função que verifica se o alimento existe
    public boolean isAlimento(String codigo){
        for(Alimento alimento : alimentos){
            if(alimento.getCodigoBarras().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    //função que remove um alimento do arraylist  
    public void removeAlimento(String codigo){
        for(Alimento alimento : alimentos){
            if(alimento.getCodigoBarras().equals(codigo)){
                alimentos.remove(alimento);
                break;
            }
        }
    }
   
    
    //função que adiciona a quantidade de um alimento
    public void addQuantidade(String codigo, int quantidade){
        for(Alimento alimento : alimentos){
            if(alimento.getCodigoBarras().equals(codigo)){
                alimento.setQuantidade(alimento.getQuantidade() + quantidade);
            }
        }
    }
    //função que printa os alimentos
    public void printAlimentos(){
        for(Alimento alimento : alimentos){
            System.out.println(alimento.toString());
        }
    }
    //função que printa o alimento com mais quantidade
    public void printAlimentoMais(){
        int maior = 0;
        for(Alimento alimento : alimentos){ 
            if(alimento.getQuantidade() > maior){ 
                maior = alimento.getQuantidade(); //maior recebe a quantidade do alimento
            }
        }
        for(Alimento alimento : alimentos){ 
            if(alimento.getQuantidade() == maior){ //se a quantidade do alimento for igual a maior, printa o alimento
                System.out.println(alimento.toString());
            }
        }
    }
     
    //função que armazena o alimento, utilizada na interface
    @Override
    public void armazenar(Produto produto){
        if(produto instanceof Alimento){
            addAlimento((Alimento)produto);
        }
    }
    
    @Override
    //função que desarmazena o alimento, utilizada na interface
    public void desarmazenar(Produto produto){
        if(produto instanceof Alimento){
            removeAlimento(produto.getCodigoBarras());
        }
    }

    //função que printa os alimentos com o mesmo código
    public void printAlimentos(String codigo){
        for(Alimento alimento : alimentos){
            if(alimento.getCodigoBarras().equals(codigo)){
                System.out.println(alimento.toString());
            }
        }
    }
   
 //toString
    public String toString(){
        String str = "";
        for(Alimento alimento : alimentos){
            str += alimento.toString() + "\n";
        }
        return str;
    }

    //função que printa os alimentos
    public static void printAlimentos(ArrayList<Alimento> alimentos){
        for(Alimento alimento : alimentos){
            System.out.println(alimento.toString());
        }
    }

    //função que remove os alimentos pelo nome
    public void removerAlimentos(String nome){
        for(Alimento alimento : alimentos){
            if(alimento.getNome().equals(nome)){
                alimentos.remove(alimento);
                break;
            }
        }
    }
     //função que lista os alimentos de acordo com a validade (vencido ou não)
    public void listarAlimentosPorValidade(){
        ArrayList<Alimento> alimentosValidos = new ArrayList<Alimento>();
        ArrayList<Alimento> alimentosInvalidos = new ArrayList<Alimento>();
        Data data = new Data(dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear());

        for(Alimento alimento : alimentos){
            if(alimento.getVencimentoAlimento().isPrevious((data))){ 
                alimentosValidos.add(alimento); //adiciona o alimento no arraylist de alimentos validos
            }else{
                alimentosInvalidos.add(alimento); //adiciona o alimento no arraylist de alimentos invalidos
            }
        }
        System.out.println("Alimentos Validos:");
        printAlimentos(alimentosValidos);
        System.out.println("Alimentos Invalidos:");
        printAlimentos(alimentosInvalidos);

    }



}








            

















