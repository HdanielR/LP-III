import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.List;


public class Main{

    public static void main(String[] args){
        
        Estoque estoque = new Estoque();
        Almoxerifado almoxerifado = new Almoxerifado();
        //Instanciando a interface
        Armazenar armazena[] = new Armazenar [2]; //cria um vetor de armazenar
        armazena [0] = estoque; //armazena o estoque no vetor
        armazena [1] = almoxerifado; //armazena o almoxerifado no vetor

        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
       
        while (opcao != 9){
            System.out.println("1 - Cadastrar Alimento");
            System.out.println("2 - Cadastrar Limpeza");
            System.out.println("3 - Listar Alimentos");
            System.out.println("4 - Listar Limpezas");
            System.out.println("5 - Remover Alimento");
            System.out.println("6 - Remover Limpeza");
            System.out.println("7 - Listar Alimentos por Validade");
            System.out.println("8 - Listar Limpezas por Validade");
            System.out.println("9 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

        
            switch(opcao){
                case 1:
                    System.out.println("Digite o nome do alimento:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o codigo de barras do alimento (tam 9):");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite a quantidade do alimento:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o fornecedor do alimento:");
                    String fornecedor = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Digite o dia da data de vencimento:");
                    int day = scanner.nextInt();
                    System.out.println("Digite o mes da data de vencimento:");
                    int month = scanner.nextInt();
                    System.out.println("Digite o ano da data de vencimento:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    
                    Alimento alimento1 = new Alimento (fornecedor, codigo, nome, day, month, year, quantidade, true);
                    Alimento alimento = alimento1;
                    //polimorfismo
                    armazena[0].armazenar(alimento);
                    break;
                case 2:
                    System.out.println("Digite o nome do produto de limpeza:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o codigo de barras do produto de limpeza (tam 10):");
                    codigo = scanner.nextLine();
                    System.out.println("Digite o fornecedor do produto de limpeza:");
                    fornecedor = scanner.nextLine();
                    System.out.println("Digite a quantidade do produto de limpeza:");
                    quantidade = scanner.nextInt();
                    System.out.println("Digite o dia da data de vencimento:");
                    int dia = scanner.nextInt();
                    System.out.println("Digite o mes da data de vencimento:");
                    int mes = scanner.nextInt();
                    System.out.println("Digite o ano da data de vencimento:");
                    int ano = scanner.nextInt();
                    Limpeza limpeza1 = new Limpeza (fornecedor, codigo, nome, dia, mes, ano, quantidade, true);
                    Limpeza limpeza = limpeza1;
                    //polimorfismo
                    armazena[1].armazenar(limpeza);
                    break;
                case 3:
                    estoque.printAlimentos();
                    break;
                case 4:
                    almoxerifado.printLimpezas();
                    break;
                case 5:
                    System.out.println("Digite o nome do alimento que deseja remover:");
                    nome = scanner.nextLine();
                    estoque.removerAlimentos(nome);
                    break;
                case 6:
                    System.out.println("Digite o nome do produto de limpeza que deseja remover:");
                    nome = scanner.nextLine();
                    almoxerifado.removeLimpezaNome(nome);
                    break;
                case 7:
                    estoque.listarAlimentosPorValidade();
                    break;
                case 8:
                    almoxerifado.listarLimpezaPorValidade();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                }
            }
        }

  
    
    }
