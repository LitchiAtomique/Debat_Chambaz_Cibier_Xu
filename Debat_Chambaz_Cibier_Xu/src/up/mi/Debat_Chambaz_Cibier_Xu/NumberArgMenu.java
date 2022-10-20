package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class NumberArgMenu extends SingleMenu {
  public void GetInt() {
    this.value = IO.ioGetInt(
        this.scanner,
        this.prompt);
  }
}
