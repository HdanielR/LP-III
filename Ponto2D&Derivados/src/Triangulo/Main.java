package Triangulo;
import Ponto.Ponto;

public class Main {
    public static void main(String[] args) {
        
        /*triangulo isoceles
        Ponto a = new Ponto (1, 1);
        Ponto b = new Ponto (2, 1);
        Ponto c = new Ponto (1.5, 2); */
        
        /*triangulo retangulo*/
        Ponto a = new Ponto (1, 1);
        Ponto b = new Ponto (1, 7);
        Ponto c = new Ponto (9, 7);
        
        
        Triangulo t = new Triangulo (a, b, c);
        System.out.println(t.imprimeTriangulo());
        if (t.isIsoceles())
            System.out.println("Triangulo Isoceles");
        if (t.isEquilatero())
            System.out.println("Triangulo Equilatero");
        if (t.isRetangulo())
            System.out.println("Triangulo Retangulo");
    }
}
