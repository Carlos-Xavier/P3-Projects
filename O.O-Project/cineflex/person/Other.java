package cineflex.person;

public class Other extends Person {

    public Other(float price, String type) {
        super();
        this.setType(type);
        this.setDiscount(0); 
        
        if (price != 7.0f) {
            this.setDiscount_3D(4.0f);
        } else {
            this.setDiscount_3D(2.0f);
        }   
    }
}
