package starbucks.domain.order;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import starbucks.domain.customer.Customer;
import starbucks.domain.menu.Drink;

@Slf4j
public class Order {

  public enum OrderStatus {WAIT_ORDER, WAIT_DRINK, DELIVERED}

  @Getter
  private Drink drink;
  private LocalDateTime localDateTime;
  private OrderStatus orderStatus;
  @Getter
  private Customer customer;

  public Order(Customer customer) {
    this.drink = customer.getDrink();
    this.localDateTime = LocalDateTime.now();
    this.orderStatus = OrderStatus.WAIT_ORDER;
    this.customer = customer;
  }

  public int payed() {
    customer.pay();
    return drink.getPrice();
  }

  public void ordered() {
    orderStatus = OrderStatus.WAIT_DRINK;
  }

  public void delivered() {
    orderStatus = OrderStatus.DELIVERED;
  }

  @Override
  public String toString() {
    return String.format("주문자: %s, 주문 추가: %s(%d원), 주문일: %s, 주문 상태: %s",
        customer.getName(),
        drink.getName(),
        drink.getPrice(),
        localDateTime.toString(),
        orderStatus.name());
  }

  public void print() {
    log.info(toString());
  }
}