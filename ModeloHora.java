package Hora;
public class ModeloHora {
    private int seg, min, hora;

     public ModeloHora(int seg, int min, int hora) {
        if (verificaHora(seg, min, hora)){
            this.seg = seg;
            this.min = min;
            this.hora = hora;
        }
    }

    public ModeloHora() {
        this(0,0,0);
    }
    public ModeloHora(int seg) {
        this(seg,0,0);
        }

    public ModeloHora(int seg, int min) {
        this(seg, min, 0);
        
    }
   

    private boolean verificaHora (int seg, int min, int hora) {
        if (seg < 0 || seg >= 60 || min < 0 || min >= 60 || hora < 0 || hora >= 24) {
            System.out.println("Hora inválida");
            return false;
        }
        else {
            return true;
        }
    }

    // private boolean verificaHora (int seg, int min) {
    //     if (seg < 0 || seg >= 60 || min < 0 || min >= 60) {
    //         System.out.println("Hora inválida");
    //         return false;
    //     }
    //     else {
    //         return true;
    //     }
    // }

    // private boolean verificaHora (int seg) {
    //     if (seg < 0 || seg >= 60) {
    //         System.out.println("Hora inválida");
    //         return false;
    //     }
    //     else {
    //         return true;
    //     }
    // }

    public String showData () {
        return String.format("%02d", hora) + ":" + String.format("%02d", min) + ":" + String.format("%02d", seg);
    }

    public int horaToInt() {
        return hora*3600 + min * 60 + seg;
    }

    public static String intToHora (int x) {
        int h, m;
        h = x / 3600;
        x = x%3600;
        m = x / 60;
        x = x%60;
        return String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", x);
    }

    public static void main(String[] args) {
        ModeloHora d = new ModeloHora(600, 200);
        System.out.println(d.showData());
    }
}