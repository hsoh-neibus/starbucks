package starbucks.service.employee;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class Manager implements Runnable {
  private String nickname;
  private int age;
  private List<Worker> workers;

  public Manager(String nickname, int age, Worker... workers) {
    this.nickname = nickname;
    this.age = age;
    this.workers = Arrays.asList(workers);
  }

  @Override
  public void run() {
    while (true) {
      workers.forEach(Worker::work);
    }
  }
}
