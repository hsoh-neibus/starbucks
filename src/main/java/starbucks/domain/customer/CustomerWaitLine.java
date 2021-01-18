package starbucks.domain.customer;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerWaitLine {

  Queue<Customer> customers = new ConcurrentLinkedQueue<>();

  public void add(Customer customer) {
    customers.add(customer);
  }

  public Customer pollCustomer() {
    return customers.poll();
  }

  public void print() {
    customers.forEach(Customer::print);
  }

  public void addAll(List<Customer> guestsList) {
    customers.addAll(guestsList);
  }
}
