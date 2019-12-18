package cineflex.movies;

import cineflex.manager.Profile;
import cineflex.person.Person;

public interface InterfaceMovie {
    public void buyTicket(int i, Profile user);
    public int[] chooseSeat(int i, String aux, int[] values);
    public void buyFood(Person type, int i);
    public String payment(String schedule, int[] chosenSeat, Profile user, int i, int[] priceChoicce);
    public String cashPayment(Person type, String schedule, int i, int[] chosenSeat);
    public String coinPayment(Person type, String schedule, int i, int[] chosenSeat);
    public String movieTime(int i);
}
