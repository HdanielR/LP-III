package Data;
public class ModeloData {
    private int dia;
    private int mes;
    private int ano;
    
    
    public ModeloData (int dia, int mes, int ano) {
         if (verificaData(dia, mes, ano)) {
             this.dia =  dia;
             this.mes = mes;
             this.ano = ano;
        }   
    }
    public ModeloData() {
    this (1,1,1);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    

    public boolean verificaData(int dia, int mes, int ano) {
        //Evitar ter essa verificação dentro de cada case
        if (dia < 1) {
            System.out.println("Data invalida");
            dia = 0;
            mes = 0;
            ano = 0;
            return false;
        }

            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12:
                    if (dia>31) {
                        System.out.println("Data invalida");
                        dia = 0;
                        mes = 0;
                        ano = 0;
                        return false;
                    }
                    break;
                    //Coloquei a verificação de ano bissexto apenas para case 2 para poupar verificação
                case 2:
                    if ( ano%400 == 0 || ano%4 == 0 && ano%100 != 0 ) {
                        if (this.dia > 29) {
                            System.out.println("Data invalida");
                            dia = 0;
                            mes = 0;
                            ano = 0;
                            return false;
                        }
                    }
                    else if (dia > 28)  {
                        System.out.println("Data invalida");
                        dia = 0;
                        mes = 0;
                        ano = 0;
                        return false;
                    }
                    break;
                case 4, 6, 9, 11:
                    if (dia>30) {
                        System.out.println("Data invalida");
                        dia = 0;
                        mes = 0;
                        ano = 0;
                        return false;
                    }
                    break;
                default:
                    System.out.println("Data invalida");
                    dia = 0;
                    mes = 0;
                    ano = 0;
                    return false;
            }
            return true;
        }

    public String showData() {
        return String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/" + String.format("%02d", ano);
    }
//Calculos feitos utilizando o algoritmo de Zeller (1882), disponível em:
// https://www.criarfazer.net/como-calcular-o-dia-da-semana-de-qualquer-ano/
    public void getDiaSemana(int dia, int mes, int ano) {
        if (this.mes < 3) {
            this.mes = this.mes + 12;
            this.ano--;
        }
        int q = this.dia;
        int m = this.mes;
        int k = this.ano % 100;
        int j = this.ano / 100;
        int h = q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j);
        h = h % 7;
        switch (h) {
            case 0 -> System.out.println("Sabado");
            case 1 -> System.out.println("Domingo");
            case 2 -> System.out.println("Segunda");
            case 3 -> System.out.println("Terça");
            case 4 -> System.out.println("Quarta");
            case 5 -> System.out.println("Quinta");
            case 6 -> System.out.println("Sexta");
            default -> System.out.println("Falha");
        }
        //O IntelliJ sugeriu esse "switch enchanced", pode comentar se acha a legibilidade do código  melhor assim?
    }

    public static void showMes(int mes) {
        switch (mes) {
            case 1 -> System.out.println("Janeiro");
            case 2 -> System.out.println("Fevereiro");
            case 3 -> System.out.println("Março");
            case 4 -> System.out.println("Abril");
            case 5 -> System.out.println("Maio");
            case 6 -> System.out.println("Junho");
            case 7 -> System.out.println("Julho");
            case 8 -> System.out.println("Agosto");
            case 9 -> System.out.println("Setembro");
            case 10 -> System.out.println("Outubro");
            case 11 -> System.out.println("Novembro");
            case 12 -> System.out.println("Dezembro");
            default -> System.out.println("Mês Inválido");
        }
    }
    public static void bissexto(int ano) {
        if (ano%400 == 0 || ano%4 == 0 && ano%100 != 0) {
            System.out.println("Esse ano é bissexto");
        }
        else {
            System.out.println("Esse ano não é bissexto");
        }
    }
}
