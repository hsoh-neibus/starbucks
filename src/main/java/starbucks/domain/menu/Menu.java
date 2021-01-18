package starbucks.domain.menu;

public class Menu {

  public static Drink americano(CupSize cupSize) {
    return new Americano(cupSize);
  }
}
