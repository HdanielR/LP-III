package Agendamento;
import Data.ModeloData;
import Hora.ModeloHora;
import Contato.Contato;
import DataHora.DataHora;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModeloData d = new ModeloData(14, 06, 2022);
        ModeloHora h = new ModeloHora(0, 30, 7);
        DataHora inicio = new DataHora(d, h);
        ModeloHora duracao = new ModeloHora(0, 40, 1);
        Contato dono = new Contato("Matheus", "mblemos.cic@uesc.br", "73982367799");
        int n = 2;
        Contato participante[] = new Contato[n];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Nome:");
            String nome = input.nextLine();
            System.out.println("Email:");
            String email = input.nextLine();
            System.out.println("Telefone:");
            String tel = input.nextLine();
            participante[i] = new Contato (nome, email, tel);
        }
        Agendamento a = new Agendamento("Aula LpIII", inicio, duracao, dono ,n, participante);
        System.out.println(a.imprimeAgendamento());
        input.close();
    }
}
