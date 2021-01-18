package starbucks.domain.menu;

public class Americano implements Drink {
  private CupSize cupSize;

  public Americano(CupSize cupSize) {
    this.cupSize = cupSize;
  }

  @Override
  public int getPrice() {
    return cupSize.getValue() * 10;
  }

  @Override
  public String getSize() {
    return cupSize.name();
  }

  @Override
  public String getName() {
    return "아메리카노";
  }

  @Override
  public String toString() {
    return String.format("아메리카노[%s]", cupSize.name());
  }
}
