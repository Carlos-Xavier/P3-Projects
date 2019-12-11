package cineflex.days;

import java.util.Random;

public class Days {
    private final float[] daysPrice;
    private static final String[] days = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
    
    public Days(float mon, float tue, float wed, float thur, float fri, float sat, float sun) {
        this.daysPrice = new float[7];
        this.daysPrice[0] = mon;
        this.daysPrice[1] = tue;
        this.daysPrice[2] = wed;
        this.daysPrice[3] = thur;
        this.daysPrice[4] = fri;
        this.daysPrice[5] = sat;
        this.daysPrice[6] = sun;
    }
    
    public static int random() {
        Random gerador = new Random();
        
        return gerador.nextInt(7);
    }
    
    public float getDayPrice(int i) {
        return this.daysPrice[i];
    }
    
    public static String getDay(int i) {
        return Days.days[i];
    }
}
