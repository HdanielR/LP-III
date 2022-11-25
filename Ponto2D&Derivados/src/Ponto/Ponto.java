package Ponto;
public class Ponto {
    private double x, y;

    public Ponto (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Ponto () {
        this (0,0);
    }
    
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String imprimePonto () {
        return "(" + x + ", " + y + ")";
    }

    public static boolean isDifferent (Ponto p1, Ponto p2) {
        if (p1.getX() != p2.getX() || p1.getY() != p2.getY())
        return true;
        else
        return false;
    }
}
