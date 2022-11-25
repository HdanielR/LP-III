package SegmentoReta;
import Ponto.Ponto;
import java.lang.Math;

public class SegmentoReta {
    private Ponto p1, p2;

    // SegmentoReta(double p1x, double p1y, double p2x, double p2y) {
    //     p1 = new Ponto(p1x, p1y);
    //     p2 = new Ponto(p2x, p2y);
    // }

    SegmentoReta(Ponto p1, Ponto p2) {
        if (Ponto.isDifferent(p1, p2)) {
            p1 = new Ponto(p1.getX(), p1.getY());
            p2 = new Ponto(p2.getX(), p2.getY());
        }
        else {
            p1 = new Ponto(0, 0);
            p2 = new Ponto(0, 0);
        }
    }

    public String imprimeReta() {
        return "p1 = " + p1.imprimePonto() + " p2 = " + p2.imprimePonto() + " d = " + calculaDistancia();
    }

    public double calculaDistancia() {
        return Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2)));
    }

    public static  double calculaDistancia(Ponto p1, Ponto p2) {
        return Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2)));
    }
}
