package cineflex.days;

import java.util.Random;

public class Days {
    private final float[] days;

    public Days(float mon, float tue, float wed, float thur, float fri, float sat, float sun) {
        this.days = new float[7];
        this.days[0] = mon;
        this.days[1] = tue;
        this.days[2] = wed;
        this.days[3] = thur;
        this.days[4] = fri;
        this.days[5] = sat;
        this.days[6] = sun;
    }
    
    public static int random() {
        Random gerador = new Random();
        
        return gerador.nextInt(7);
    }
    
    public float getDay(int i) {
        return this.days[i];
    }
}
