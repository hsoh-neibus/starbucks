package starbucks.service.employee;

import lombok.extern.slf4j.Slf4j;
import starbucks.Starbucks;
import starbucks.domain.order.Order;

@Slf4j
public class Barista implements Worker {

  private Starbucks starbucks;

  public Barista(Starbucks starbucks) {
    this.starbucks = starbucks;
  }

  @Override
  public void work() {
    Order order = starbucks.getOrders().pickOrder();
    if (order == null) {
      return;
    }

    log.info("{} 만드는 중...", order.getDrink().toString());

    delivery(order);
  }

  private void delivery(Order order) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException ignore) {}

    log.info("{}님~ 주문 하신 {} 나왔습니다~", order.getCustomer().getName(), order.getDrink());

    order.delivered();
  }
}