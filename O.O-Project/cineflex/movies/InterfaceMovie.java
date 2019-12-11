package cineflex.movies;

import cineflex.person.Person;

public interface InterfaceMovie {
    public void buyTicket(int i, Person type);
    public int[] chooseSeat(int i, String aux, int[] values);
    public void buyFood(Person type, int i);
    public boolean payment(String schedule, int[] valores, Person type, int i);
    public boolean cashPayment(Person type, String schedule, int i, int[] values);
    public boolean coinPayment(Person type, String schedule, int i, int[] values);
    public String movieTime(int i);
}
