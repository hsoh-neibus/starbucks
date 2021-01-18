package starbucks.domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.extern.slf4j.Slf4j;
import starbucks.domain.order.Order;

@Slf4j
public class Orders {

  private final List<Order> orderHistory = new ArrayList<>();
  private Queue<Order> orderQueue = new ConcurrentLinkedQueue();

  public void add(Order order) {
    log.info(order.toString());
    this.orderHistory.add(order);
    this.orderQueue.add(order);
  }

  public Order pickOrder() {
    return orderQueue.poll();
  }

  public void print() {
    log.info("영업 종료");
    orderHistory.forEach(Order::print);
  }
}
