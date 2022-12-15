
    public class Ponto3D extends Ponto2D{

    private float z;

    public Ponto3D(){
        super();
        this.z = 0;
    }

    public Ponto3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public Ponto3D(Ponto3D p){
        super(p.getX(), p.getY());
        this.z = p.getZ();
    }

    public float getZ(){
        return this.z;
    }

    public void setZ(float z){
        this.z = z;
    }

    public String toString(){
        return "(" + super.getX() + ", " + super.getY() + ", " + this.z + ")";
    }

    public float distance(float x, float y, float z){
        return (float)Math.sqrt((x - super.getX()) * (x - super.getX()) + (y - super.getY()) * (y - super.getY()) + (z - this.z) * (z - this.z));
    }

    public float distance(Ponto3D p){
        return (float)Math.sqrt((p.getX() - super.getX()) * (p.getX() - super.getX()) + (p.getY() - super.getY()) * (p.getY() - super.getY()) + (p.getZ() - this.z) * (p.getZ() - this.z));
    }
}

