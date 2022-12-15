public class Cone extends Ponto2D{
    private Ponto2D pBase;
    private Ponto2D pTopo;
    private Ponto2D pLateral;
  
    private static float PI = 3.141592f;

    public Cone(Ponto2D p1, Ponto2D p2, Ponto2D p3){
        super(p1.getX(), p1.getY());
        pBase = p1;
        pLateral = p2;
        pTopo = p3;
    }

    public float calculaVolume(){
        float dBaseLateral = distance(pLateral);
        float dBaseTopo = distance(pTopo);

        return ((PI * dBaseLateral * dBaseLateral * dBaseTopo) / 3);
    }

    public float calculaAreaTotal(){
        float dBaseLateral = distance(pLateral);
        float dBaseTopo = distance(pTopo);

        return PI * dBaseLateral * (dBaseLateral + calculaGeratri(dBaseTopo, dBaseLateral));
    }

    private float calculaGeratri(float h, float r){
        return ((h * h) + (r * r));
    }

    @Override
    public String toString(){
        return "Area total = " + calculaAreaTotal() + "\nVolume = " + calculaVolume();
    }
}