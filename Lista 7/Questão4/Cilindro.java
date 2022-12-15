public class Cilindro extends Ponto2D{
   
    private Ponto2D pBase;
    private Ponto2D pTopo;
    private Ponto2D pLateral;
    private static float PI = 3.141592f;

    public Cilindro(Ponto2D p1, Ponto2D p2, Ponto2D p3){
        super(p1.getX(), p1.getY());
        pBase = p1;
        pLateral = p2;
        pTopo = p3;
    }

    public float calculaAreaTotal(){
        float dBaseLateral = distance(pLateral);
        float dBaseTopo = distance(pTopo);

        return (2 * dBaseLateral * PI * (dBaseTopo + dBaseLateral));
    }

    public float calculaVolume(){
        float dBaseLateral = distance(pLateral);
        float dBaseTopo = distance(pTopo);

        return (PI * dBaseLateral * dBaseLateral * dBaseTopo);
    }

    @Override
    public String toString(){
        return "Area total = " + calculaAreaTotal() + "\nVolume = " + calculaVolume();
    }
}