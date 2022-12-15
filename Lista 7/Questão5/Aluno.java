import java.util.Calendar;

public class Aluno{
    private String nome;
    private int matricula;
    private Data data;
    private int semestre;
    private int escCurso;
    private String[] cursos = {"Engenharias", "Computação", "Letras", "Biológicas"};
    private float mensalidade = 700f;

    public Aluno(String n, int m, Data d, int s, int escolha){
        nome = n;
        matricula = m;
        data = d;
        semestre = s;
        if(escCurso > 1 && escCurso > 4){
            System.out.println("Erro, curso invalido!!");
            System.exit(-1);
        }else{
            escCurso = escolha;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public int getMaticula(){
        return this.matricula;
    }

    public Data getData(){
        return this.data;
    }

    public int getSemestre(){
        return this.semestre;
    }

    public float getMensalidade(){
        return this.mensalidade;
    }

    public void setMensalidade(float f){
        mensalidade = f;
    }

    public void calculaMensalidade(){
        if(escCurso == 1){
            mensalidade = mensalidade + (0.2f * mensalidade);
        }else if(escCurso == 2){
            mensalidade = mensalidade + (0.1f * mensalidade);
        }else if(escCurso == 3){
            mensalidade = mensalidade + (0.05f * mensalidade);
        }

        if(qMeses() != semestre){
            mensalidade = mensalidade + (0.2f * mensalidade);
        }
    }

    public int qMeses(){
        Calendar cal = Calendar.getInstance();
        int d = cal.get(Calendar.DATE);
        int m = cal.get(Calendar.MONTH) + 1;
        int y = cal.get(Calendar.YEAR);
        int dias = data.howManyDays(d, m, y);
        int calc = 0;

        while(dias > 0){
            calc = calc + (dias % 30);
            dias = dias / 30;
        }

        return calc;
    }

    @Override
    public String toString(){
        return "Node: " + nome + "\nMatricula: " + matricula + "\nData: " + data.toString() + "\nSemestre: " + semestre + "\nCurso: " + cursos[escCurso - 1] + "\n";
    }
}