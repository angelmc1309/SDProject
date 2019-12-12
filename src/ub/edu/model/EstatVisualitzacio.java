package model;

public class EstatVisualitzacio {
    public static int NOT_STARTED = 0;
    public static int STARTED = 1;
    public static int ENDED = 2;
    private int state;
    public EstatVisualitzacio(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
