package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class SingleMenu extends Menu {
  int value;
  Runnable function;

  void addFunction(Runnable function) {
    this.function = function;
  }

  void run() throws Exception {
    // error handling
    if (scanner == null)
      throw new Exception("Invalid scanner");
    if (prompt == null)
      throw new Exception("Invalid prompt");
    if (function == null)
      throw new Exception("Invalid function");
    function.run();
  }

  int getValue() {
    return this.value;
  }
}
