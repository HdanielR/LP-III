package DataHora;
import Data.ModeloData;
import Hora.ModeloHora;

public class MainDH {
    public static void main(String[] args) {
        ModeloData d1 = new ModeloData(6, 6, 2022);
        ModeloHora h1 = new ModeloHora(1, 26, 8);
        DataHora dh1 = new DataHora(d1, h1);

        System.out.println(dh1.toString());
        //dh1.isEqual(dh2);
    }
}

//pegar atributos privados das classes base? como?