package Triangulo;
import Ponto.Ponto;
import SegmentoReta.SegmentoReta;
import java.lang.Double;

public class Triangulo {
    private Ponto a, b, c;
    private double cat1, cat2;

    Triangulo (Ponto a, Ponto b, Ponto c) {
        if (verificaPonto(a, b, c) || !Ponto.isDifferent(a, b) || !Ponto.isDifferent(a, c) || !Ponto.isDifferent(b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            this.a = new Ponto (0, 0);
            this.b = new Ponto (0, 0);
            this.c = new Ponto (0, 0);
        }
    }
    private boolean verificaPonto(Ponto a, Ponto b, Ponto c) {
        /* Um jeito de verificar se três pontos estão alinhados é fazer o produto misto deles, se
        for = 0 então eles estão alinhados. O produto misto consiste em faz o determinate da matriz
        formada com as coordenadas dos pontos */
        double mat[][] = new double[3][3];
        mat[0][0] = a.getX();
        mat[0][1] = a.getY();
        mat[0][2] = 1;
        mat[1][0] = b.getX();
        mat[1][1] = b.getY();
        mat[1][2] = 1;
        mat[2][0] = c.getX();
        mat[2][1] = c.getY();
        mat[2][2] = 1;
        double diagPrin1 = mat[0][0] * mat[1][1] * mat[2][2];
        double diagPrin2 = mat[0][1] * mat[1][2] * mat[2][0];
        double diagPrin3 = mat[0][2] * mat[1][0] * mat[2][1];
        double diagSec1 = mat[2][0] * mat[1][1] * mat[0][2];
        double diagSec2 = mat[2][1] * mat[1][2] * mat[0][0];
        double diagSec3 = mat[2][2] * mat[1][0] * mat[0][1];
        double prodmisto = -(diagSec1 + diagSec2 + diagSec3) + (diagPrin1 + diagPrin2 + diagPrin3);
        
        return  Double.compare(prodmisto, 0.0) == 0 ? false : true;
    }

    public String imprimeTriangulo() {
        return "a = " + a.imprimePonto() + " b = " + b.imprimePonto() + " c = " + c.imprimePonto() + 
        "\n" + "Segmentos: ab = " + SegmentoReta.calculaDistancia(a, b) + ", bc = " + 
        SegmentoReta.calculaDistancia(b, c) + ", ac = " + SegmentoReta.calculaDistancia(a, c);
    }

    public boolean isEquilatero() {
        double ab = SegmentoReta.calculaDistancia(a, b);
        double ac = SegmentoReta.calculaDistancia(a, c);
        double bc = SegmentoReta.calculaDistancia(b, c);
        if (Double.compare(ab, ac) == 0 && Double.compare(ab, bc) == 0 && Double.compare(ac, bc) == 0)
            return true;
        else
            return false;
    }

    private double hipo() {
        double ab = SegmentoReta.calculaDistancia(a, b);
        double ac = SegmentoReta.calculaDistancia(a, c);
        double bc = SegmentoReta.calculaDistancia(b, c);
        if (ab > bc && ab > ac) {
            cat1 = bc*bc;
            cat2 = ac*ac;
            return ab*ab;
        }
        else if (bc > ab && bc>ac) {
            cat1 = ab*ab;
            cat2 = ac*ac;
            return bc*bc;
        }
        else {
            cat1 = bc*bc;
            cat2 = ab*ab;
            return ac*ac;
        }
    }

    public boolean isRetangulo () {
        if (Double.compare((hipo()), cat1 + cat2) == 0)
            return true;
        else
            return false;
    }

    public boolean isIsoceles() {
        double ab = SegmentoReta.calculaDistancia(a, b);
        double ac = SegmentoReta.calculaDistancia(a, c);
        double bc = SegmentoReta.calculaDistancia(b, c);
        if (Double.compare(ab, bc) == 0 && Double.compare(ab, ac) != 0 && Double.compare(bc, ac) != 0)
            return true;
        else if (Double.compare(ac, bc) == 0 && Double.compare(ab, ac) != 0 && Double.compare(bc, ab) != 0)
            return true;
        else if (Double.compare(ab, ac) == 0 && Double.compare(bc, ac) != 0 && Double.compare(bc, ab) != 0)
            return true;
        else
            return false;
    }

}
