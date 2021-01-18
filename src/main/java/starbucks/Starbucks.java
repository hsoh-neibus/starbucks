package starbucks;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import starbucks.domain.customer.Customer;
import starbucks.domain.customer.CustomerWaitLine;
import starbucks.domain.order.Orders;
import starbucks.domain.wallet.Wallet;
import starbucks.service.employee.Managers;
import starbucks.util.CustomerUtil;

@Slf4j
@Getter
@Builder
public class Starbucks {
  private Managers managers;
  private Wallet wallet;
  private Orders orders;
  private CustomerWaitLine customerWaitLine;

  private String storeName;

  public static void main(String[] args) {
    Starbucks starbucks = grandOpen("네이버스점");
    starbucks.managers = Managers.goTo(starbucks);
    starbucks.open();
    starbucks.greet(CustomerUtil.createCustomers(10));
  }

  private static Starbucks grandOpen(String storeName) {
    return Starbucks.builder()
        .storeName(storeName)
        .wallet(new Wallet(0))
        .orders(new Orders())
        .customerWaitLine(new CustomerWaitLine())
        .build();
  }

  private void greet(List<Customer> customers) {
    customerWaitLine.addAll(customers);
  }

  public void open() {
    managers.beginWork();

    new Thread(() -> {
      try {
        Thread.sleep(1000 * 10);

        orders.print();

        log.info("----대기 손님----");
        customerWaitLine.print();
        close();
      } catch (InterruptedException ignore) {}
    }, "스타벅스-네이버스점").start();
  }

  public void close() {
    System.exit(0);
  }
}