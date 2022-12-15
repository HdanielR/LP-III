package Questão5;

public class AlunoPosGraduacao {
    
    public class AlunoPosGraduacao extends Aluno{
        private String nomeOrientador;
        private String tituloProjeto;
        private char nivel;
    
        public AlunoPosGraduacao(String n, int m, Data d, int s, int escolha, String no, String tp, char niv){
            super(n, m, d, s, escolha);
            nomeOrientador = no;
            tituloProjeto = tp;
            if(nivel != 'M' || nivel != 'D'){
                System.out.println("Erro, nivel invalido!!");
                System.exit(-1);
            }
            nivel = niv;
        }
    
        public String getNomeOrientador(){
            return nomeOrientador;
        }
    
        public String getTituloProjeto(){
            return tituloProjeto;
        }
    
        public char getNivel(){
            return nivel;
        }
    
        public void calculaMensalidade(){
            if(super.qMeses() < 24){
                setMensalidade(super.getMensalidade() + (0.2f * super.getMensalidade()));
            }
        }
    }
}
