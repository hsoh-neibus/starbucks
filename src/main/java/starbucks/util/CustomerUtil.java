package starbucks.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import starbucks.domain.customer.Customer;
import starbucks.domain.menu.CupSize;
import starbucks.domain.menu.Menu;

public class CustomerUtil {
  static String[] customerArr = {"아이유", "사나", "수지", "루돌프", "페이커"};

  public static List<Customer> createCustomers(int size) {
    return IntStream.range(0, size)
        .mapToObj(i -> new Customer(randomName(i), Menu.americano(CupSize.randomChoice())))
        .collect(Collectors.toList());
  }

  private static String randomName(int index) {
    int randomIdx = RandomPick.range(customerArr.length);
    return customerArr[randomIdx] + index;
  }
}
