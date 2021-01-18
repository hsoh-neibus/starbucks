package starbucks.domain.customer;

import lombok.extern.slf4j.Slf4j;
import starbucks.domain.menu.Drink;
import starbucks.domain.wallet.Wallet;

@Slf4j
public class Customer {

  private Wallet wallet = new Wallet(10000);
  private Drink drink;
  private String name;

  public Customer(String name, Drink drink) {
    this.name = name;
    this.drink = drink;
  }

  public Drink getDrink() {
    return drink;
  }

  public void pay() {
    wallet.pay(drink.getPrice());
    log.info("결제 완료. 거스름돈: {}원", wallet.getBalance());
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("이름: %s, 먹고 싶은 것:%s", name, drink.toString());
  }

  public void print() {
    log.info(toString());
  }

  public int getMoney() {
    return wallet.getBalance();
  }
}
