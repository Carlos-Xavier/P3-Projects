package cineflex.movies;

import cineflex.person.Person;

public interface InterfaceFilme {
    public void buyTicket(int i, Person type);
    public void chooseSeat(int i, String aux, int[] values);
    public void buyFood(Person type, int i);
    public void generateMovies();
    public void payment(String schedule, int[] valores, Person type, int i);
    public void cashPayment(Person type, int i, int[] values);
    public void coinPayment(Person type, int i, int[] values);
    public String movieTime(int i);
}
