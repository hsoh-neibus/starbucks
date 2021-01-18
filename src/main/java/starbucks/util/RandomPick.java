package starbucks.util;

import java.util.Random;

public class RandomPick {

  public static int range(int length) {
    return new Random().nextInt(length);
  }
}
