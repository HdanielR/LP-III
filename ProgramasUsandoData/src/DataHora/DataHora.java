package DataHora;

import Data.ModeloData;
import Hora.ModeloHora;

public class DataHora {
    ModeloHora hora1;
    ModeloData data1;

    public DataHora(ModeloData d1, ModeloHora h1) {
        data1 = d1;
        hora1 = h1;
    }
    
    public int getDia() {
        return data1.getDia();
    }

    public int getMes() {
        return data1.getMes();
    }

    public int getAno() {
        return data1.getAno();
    }

    public String toString() {
        return data1.showData() + ", " + hora1.showData();
    }

    public boolean isEqual(DataHora dh2) {
        if (data1.getDia() == dh2.getDia() && data1.getMes() == dh2.getMes() && data1.getAno() == dh2.getAno()
                && hora1.horaToInt() == dh2.hora1.horaToInt()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGreather(DataHora dh2) {
        if (data1.getAno() > dh2.getAno()) {
            return false;
        } else if (data1.getMes() > dh2.getMes()) {
            return false;
        } else if (data1.getDia() > dh2.getDia()) {
            return false;
        } else if (hora1.horaToInt() > dh2.hora1.horaToInt()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isLower(DataHora dh2) {
        if (data1.getAno() < dh2.getAno()) {
            return false;
        } else if (data1.getMes() < dh2.getMes()) {
            return false;
        } else if (data1.getDia() < dh2.getDia()) {
            return false;
        } else if (hora1.horaToInt() < dh2.hora1.horaToInt()) {
            return false;
        } else {
            return true;
        }
    }
 }
