package cineflex.person;

public class Student extends Person {
    
    public Student(float price, String type) {
        super();
        this.setType(type);
        
        if (price != 7.0f) {
            this.setDiscount(price/2);
        } else {
            this.setDiscount(0);
        }
        this.setDiscount_3D(2.0f);
    }
}
