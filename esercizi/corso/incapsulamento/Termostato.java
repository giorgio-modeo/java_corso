package incapsulamento;

public class Termostato {
    private int temperatura;

    public int regolaTemperatura(int t){
        return temperatura + t;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }
}
