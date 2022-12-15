

public class Ponto2D {
   
    private float x;
    private float y;

    public Ponto2D(){
        this.x = 0;
        this.y = 0;
    }

    public Ponto2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

   
    public boolean inAxisX(){
        if((y == 0) && ((x < 0) || (x > 0))){
            return true;
        }
        return false;
    }

    public boolean inAxiY(){
        if((x == 0) && ((y < 0) || (y > 0))){
            return true;
        }
        return false;
    }

    public boolean inAxis(){
        if((x == 0) && (y == 0)){
            return true;
        }
        return false;
    }

    public boolean isOrigin(Ponto2D p){
        if((p.getX() == 0) && (p.getY() == 0)){
            return true;
        }
        return false;
    }

    public float distance(float x, float y){
        return (float)Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }

    public float distance(Ponto2D p){
        return (float)Math.sqrt((p.getX() - this.x) * (p.getX() - this.x) + (p.getY() - this.y) * (p.getY() - this.y));
    }
    
    public String toString(){
        return "(x, y) = " + "(" + x + ", " + y + ")";
    }

}