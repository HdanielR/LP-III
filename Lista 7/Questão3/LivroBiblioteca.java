package Questão3;


    import java.util.*;

 public class LivroBiblioteca extends Livro{
    private boolean emprestado;
    private Data dataDev;
    

    public LivroBiblioteca(String t, String autor, int numPag, int anoPost, boolean emp, Data d){
        super(t, autor, numPag, anoPost);
        emprestado = emp;
        dataDev = d;
    }

    public boolean isAvaliable(){
        Calendar c = new GregorianCalendar();
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH);
        int y = c.get(Calendar.YEAR);
        Data dt = new Data(d, m, y);

        if(emprestado && dataDev.isPrevious(dt)){
            return false;
        }
        return true;
    }

    public void borrow(){
        if(isAvaliable()){
            System.out.println("Livros emprestado com seucesso!!\n");
        }
    }

    public String toString(){
        return super.toString() + "Emprestado: " + emprestado + "\nData de devolução: " + dataDev.toString();
    }
}

