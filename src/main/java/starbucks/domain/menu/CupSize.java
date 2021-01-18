package starbucks.domain.menu;

import java.util.Arrays;
import java.util.Random;
import lombok.Getter;

@Getter
public enum CupSize {
  TRENTA(917),
  VENTI(591),
  GRANDE(473),
  TALL(354),
  SHORT(236);

  private int value;

  CupSize(int value) {
    this.value = value;
  }

  public static CupSize randomChoice() {
    int randomIndex = new Random().nextInt(values().length);
    return Arrays.asList(values()).get(randomIndex);
  }
}
