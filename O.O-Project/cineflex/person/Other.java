package cineflex.person;

import cineflex.person.Person;

public class Other extends Person {

    public Other(float price, String type) {
        super();
        this.setType(type);
        this.setDiscount(price); 
        this.setDiscount_3D(4.0f);
    }
}
