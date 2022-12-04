
//QUESTÃO 6
package Agendamento;
import Hora.ModeloHora;
import Contato.Contato;
import DataHora.DataHora;

public class Agendamento {
    private String nome;
    private DataHora dh;
    private ModeloHora duracao;
    private int n;
    private Contato c[];
    private Contato dono;

    Agendamento (String nome, DataHora inicio, ModeloHora duracao, Contato dono,int quantidade, Contato participante[]) {
        this.nome = nome;
        dh = inicio;
        this.duracao = duracao;
        c = participante;
        n = quantidade;
        this.dono = dono;
    }

    public String imprimeAgendamento() {
        String str = "Lista de Participantes \n";
        for (int i = 0; i<n; i++) {
            str += "Participante[" + i + "]\n" + c[i].imprimeContato() + "\n";
        }
        return "Sessao: " + nome + "\nData e Horario de Inicio: " + dh.toString() + "\nDuracao: " +
        duracao.showData() + "\nDono do Agendamento: "+ dono.imprimeContato() + "\nNumero de participantes: " + n + "\n" + str;
    }

}
