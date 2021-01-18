package starbucks.service.employee;

import java.util.ArrayList;
import java.util.List;
import starbucks.Starbucks;

public class Managers {
  private List<Manager> managerList = new ArrayList<>();

  public static Managers goTo(Starbucks starbucks) {
    Managers managers = new Managers();

    Manager chicol = new Manager("ChiCol", 34,
        new Barista(starbucks));
    managers.add(chicol);

    Manager tom = new Manager("Tom", 40,
        new Barista(starbucks));

    managers.add(tom);

    Manager eric = new Manager("Eric", 40,
        new Cashier(starbucks));
    managers.add(eric);

    return managers;
  }

  public void add(Manager manager) {
    managerList.add(manager);
  }

  public void beginWork() {
    for (Manager manager : managerList) {
      new Thread(manager, manager.getNickname()).start();
    }
  }
}
