
package cineflex.food;

public final class Food {
    private float popcorn, sweet, beverage;

    public Food() {
        this.popcorn = 8.50f;
        this.sweet = 3.99f;
        this.beverage = 6.99f;
    }

    public float getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(float popcorn) {
        this.popcorn = popcorn;
    }

    public float getSweet() {
        return sweet;
    }

    public void setSweet(float sweet) {
        this.sweet = sweet;
    }

    public float getBeverage() {
        return beverage;
    }

    public void setBeverage(float beverage) {
        this.beverage = beverage;
    }
}
