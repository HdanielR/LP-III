public class Date {
    private int day, month, year;

    
    public void setDate(int day, int month, int year){
        if(validDate(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            System.out.println("Erro data invalida!\n");
            System.exit(-1);
        }
    }

    //date getters
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }

  
    private boolean validDate(int insertDay, int insertMonth, int insertYear){
    if(insertMonth >= 1 && insertMonth <= 12){ //Checagem de mês, Janeiro - Dezembro
        if((insertMonth == 2) && ((insertDay >= 1) && (insertDay <= 29)) && ((insertYear % 4 == 0) && (insertYear % 100 == 0) && (insertYear % 400 == 0))){
            return true; // Considerando um dia a mais em fevereiro caso seja bissexto
        }else if((insertMonth == 2) && ((insertDay >= 1) && (insertDay <= 28))){
            return true;
        }else if(((insertDay >= 1) && (insertDay <= 31)) && ((insertMonth % 2 != 0) || (insertMonth == 8))){
            return true; 
        }else if((insertDay >= 1) && (insertDay <= 30) && (insertMonth % 2 == 0) && (insertMonth != 8)){
            return true;
        }
        return false;
    }
    return false;
}
    public void defaultDate(){
        day = getDay();
        month = getMonth();
        year = getYear();
    }

  
    public void printDate(){
        System.out.printf("%d,%d,%d\n", day, month, year);
    }

   
    public void printFullDate(){
        String months_names[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}; //associando os numeros aos 12 meses do ano
        System.out.printf("%d de %s de %d\n", day, months_names[getMonth()-1], year);
    }
}