import java.util.Calendar;
import java.util.Date;

//Utilizamos o isPrevious para verificar se a data é anterior a data atual, se for, o produto está vencido


public class Data implements DataInterface {
   
    private int day, month, year; //Data, Mês e Ano
    private int currentDay, currentMonth, currentYear;
    private static final String[] MONTHS = {"Janeiro", "Fevereiro", "Março", "Abril",
    "Maio", "Junho", "Julho", "Agosto",
    "Setembro", "Outubro", "Novembro", "Dezembro"}; //Meses do ano

    //Construtores
    //Construtor com 3 parametros
    public Data(int day, int month, int year){
        setDate(day, month, year);
        setCurrentDate();
    }//Fim

    //Construtor sem parametros(chama o construtor com 3 parametros)
    public Data(){
        this(1, 1, 1970);
    }//Fim

    //Construtor que recebe um objeto Data(chama o construtor com 3 parametros)
    public Data(Data date){
        this(date.getDay(), date.getMonth(), date.getYear());
    }//Fim
    //Fim construtores

    //Metodos get
    //Retorna o dia
    public int getDay(){
        return this.day;
    }//Fim getDay

    //Retorna o mês
    public int getMonth(){
        return this.month;
    }//Fim getMonth

    //Retorna o ano
    public int getYear(){
        return this.year;
    }//Fim getYear

    //Retorna o dia atual
    public int getCurrentDay(){
        return this.currentDay;
    }
    //Fim getCurrentDay

    //Retorna o mês atual
    public int getCurrentMonth(){
        return this.currentMonth;
    }
    //Fim getCurrentMonth

    //Retorna o ano atual
    public int getCurrentYear(){
        return this.currentYear;
    }
    //Fim getCurrentYear
    //Fim metodos get

    //Metodos set
    //Atualiza a data
    @Override
    public void setDate(int day, int month, int year){
        if(dateVerification(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            System.out.printf("Invalid Date!\n");
            System.exit(-1);
        }
    }//Fim setDate

    //Define a hora atual(obtem da classe Calendar)
    @Override
    public void setCurrentDate(){
        Calendar cal = Calendar.getInstance();
        this.currentDay = cal.get(Calendar.DATE);
        this.currentMonth = cal.get(Calendar.MONTH) + 1;
        this.currentYear = cal.get(Calendar.YEAR);
    }//Fim setCurrentDate
    //Fim metodos set

    //Verifica se a data está correta
    private boolean dateVerification(int day, int month, int year){
        if((month >= 1) && (month  <= 12)){
            if(month == 2){
                if((day >= 1) && (day <= 29) && (isLeapYear(year))){
                    return true;
                }else if((day >= 1) && (day <= 28)){
                    return true;
                }
                return false;
            }else if((day >= 1) && (day <= 30) && ((month % 2 == 0) && (month != 8))){
                return true;
            }else if((day >= 1) && (day <= 31)){
                return true;
            }
        }
        return false;
    }//Fim dateVerification

    //função que pega a data atual do computador e retorna uma string no formato data
    public String getCurrentDate(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        return day + "/" + month + "/" + year;
    }//Fim getCurrentDate

    
    public boolean isExpired(String date){
        String[] dateArray = date.split("/");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        if(year < this.currentYear){
            return true;
        }else if(year > this.currentYear){
            return false;
        }else{
            if(month < this.currentMonth){
                return true;
            }else if(month > this.currentMonth){
                return false;
            }else{
                if(day < this.currentDay){
                    return true;
                }
                return false;
            }
        }
    }//Fim isExpired


    //Metodo isPrevious com 3 parametros, Retorna verdadeiro se a data passada por paramentro é anterior a data do objeto
    @Override
    public boolean isPrevious(int day, int month, int year){
        if(year < this.year){
            return true;
        }else if(year > this.year){
            return false;
        }else{
            if(month < this.month){
                return true;
            }else if(month > this.month){
                return false;
            }else{
                if(day < this.day){
                    return true;
                }
                return false;
            }
        }
    }//Fim isPrevious

    //Retorna verdadeiro se a data passada por paramentro é anterior a data do objeto
    @Override
    public boolean isPrevious(Data outraData){
        return this.isPrevious(outraData.getDay(), outraData.getMonth(), outraData.getYear());
    }//Fim isPrevious
    
    //Retorna a quantidade de dias até uma data
    @Override
    public int howManyDays(int day, int month, int year){
        if(isPrevious(day, month, year)){
            float diffYears = (float)mode(year - this.year) - 1;
            float diffMonth1 = 12.0f - month;
            float diffMonth2 = this.month - 1.0f + 1;
            float days = (diffYears * 365.25f) + ((diffMonth1 + diffMonth2) * 365.25f / 12);
            return (int)(-days);
        }else{
            float diffYears = (float)mode(year - this.year) - 1;
            float diffMonth1 = 12.0f - this.month;
            float diffMonth2 = month - 1.0f + 1;
            float days = (diffYears * 365.25f) + ((diffMonth1 + diffMonth2) * 365.25f / 12);
            return (int)days;
        }
    }//Fim howManyDays

    //Retorna a quantidade de dias até uma data, aceita um objeto do tipo data(Chama o metodo com 3 parametros)
    @Override
    public int howManyDays(Data outraData){
        return this.howManyDays(outraData.getDay(), outraData.getMonth(), outraData.getYear());
    }//Fim howManyDays

    //Retorna o valor absoluto de um número
    private static int mode(int n){
        if(n < 0){
            return (-1 * n);
        }
        return n;
    }//Fim mode

    //Retorna o dia da semana
    @Override
    public String dayOfWeek(Data date){
        int d = date.getDay();
        int m = date.getMonth();
        int y = date.getYear();
        int k = 0;
        String[] daysWeek = {"Sabado", "Domingo","Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};

        if(m == 1){
            k = d + 2 * 13 + (3 * (13 + 1) / 5) + (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400) + 2;
        }else if(m == 2){
            k = d + 2 * 14 + (3 * (14 + 1) / 5) + (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400) + 2;
        }else{
            k = d + 2 * m + (3 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400) + 2;
        }

        return daysWeek[k % 7];
    }//Fim dayOfWeek

    //Verifica se o ano é bissexto
    private static boolean isLeapYear(int year){
        if((year % 4 == 0) && ((year % 100 == 0) && (year % 400 == 0))){
            return true;
        }
        return false;
    }//Fim isLeapYear

    //Metodo toString para retornar a data para impressão
    @Override
    public String toStringShort(){
        return day + "/" + month + "/" + year;
    }//Fim toString

    //Metodo toStringLong para retornar da data por extenso para impressão
    @Override
    public String toStringLong(){
        return day + " de " + MONTHS[month - 1] + " de " + year;
    }//Fim toStringLong

    public int compareTo(Date time) {
        return 0;
    }

    public boolean after(Calendar instance) {
        return false;
    }


    public boolean before(Calendar instance) {
        return false;
        
    }
}//Fim classe Data

