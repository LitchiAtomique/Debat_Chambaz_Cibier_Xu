package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class SingleMenu {
  int value;

  void run(Scanner scanner) {
    this.value = IO.ioGetInt(
        scanner,
        this.prompt);
  }

  int getValue() {
    return this.value;
  }
}
