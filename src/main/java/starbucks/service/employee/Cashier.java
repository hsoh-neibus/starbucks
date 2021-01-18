package starbucks.service.employee;

import lombok.extern.slf4j.Slf4j;
import starbucks.domain.customer.Customer;
import starbucks.domain.customer.CustomerWaitLine;
import starbucks.Starbucks;
import starbucks.domain.order.Order;

@Slf4j
public class Cashier implements Worker {

  private Starbucks starbucks;

  public Cashier(Starbucks starbucks) {
    this.starbucks = starbucks;
  }

  @Override
  public void work() {
    CustomerWaitLine customerWaitLine = starbucks.getCustomerWaitLine();
    Customer customer = customerWaitLine.pollCustomer();
    if (customer == null) {
      return;
    }

    Order order = new Order(customer);

    log.info("{}에게 {} 주문 받는 중... {}원 받았습니다.",
        customer.getName(), order.getDrink(), customer.getMoney());

    sell(order);
  }

  private void sell(Order order) {
    try {
      int price = order.payed();
      order.ordered();

      starbucks.getWallet().save(price);
      starbucks.getOrders().add(order);

      Thread.sleep(2000);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
