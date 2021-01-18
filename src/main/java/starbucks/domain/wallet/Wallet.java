package starbucks.domain.wallet;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wallet {

  private AtomicInteger balance;

  public Wallet(int value) {
    this.balance = new AtomicInteger(value);
  }

  public void pay(int price) {
    if (balance.get() < price) {
      throw new IllegalArgumentException("죄송합니다 손님. 잔액이 부족합니다.");
    }

    this.balance.addAndGet(-price);
  }

  public void save(int price) {
    log.info("매장 총 매출액: {}원", this.balance.addAndGet(price));
  }

  public int getBalance() {
    return balance.get();
  }
}
