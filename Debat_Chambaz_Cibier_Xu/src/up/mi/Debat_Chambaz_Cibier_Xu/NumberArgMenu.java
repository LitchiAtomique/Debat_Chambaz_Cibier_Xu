package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the number of argument menu
 */
public class NumberArgMenu extends SingleMenu {
  private int value;

  public NumberArgMenu() {
    super();
    this.value = 0;
  }
  /**
   * Set Value from the IO.ioGetInt function
   */
  public void setValueFromIO() {
    this.value = IO.ioGetInt(
        this.scanner,
        this.prompt);
  }
/**
 * 
 * @return the value
 */
  public int getValue() {
    return this.value;
  }
}
