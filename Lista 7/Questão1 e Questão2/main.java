

public class main{
    public static void main(String[] args){
        Ponto2D p = new Ponto2D(4, 3);
        Ponto2D p1 = new Ponto2D(6, 8);

        
        System.out.println(p.toString());
        System.out.println(p.distance(p1));

        Ponto3D p2 = new Ponto3D(2, 4, 6);
        Ponto3D p3 = new Ponto3D(3, 5, 7);

        System.out.println(p2.toString());
        System.out.println(p2.distance(p3));
    }
}