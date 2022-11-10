package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the number of argument menu
 */
public class NumberArgMenu extends SingleMenu {
  private int value;

  public NumberArgMenu() {
    super(); //Appel le constructeur de la class SingleMenu
    this.value = 0;
  }
  /**
   * Gets an int from io
   */
  public void GetInt() {
    this.value = IO.ioGetInt(
        this.scanner,
        this.prompt);
  }

  public int getValue() {
    return this.value;
  }
}
