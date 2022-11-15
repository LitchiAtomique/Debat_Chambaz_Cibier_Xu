package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

/**
 * Menu class that displays a menu to be
 * instanciated further
 */
abstract public class Menu {
  protected Scanner scanner;
  protected String prompt;

  /**
   * 
   * @param scanner Initialized scanner
   */
  public void addScanner(Scanner scanner) {
    this.scanner = scanner;
  }
/**
 * 
 * @param prompt Add a message to prompt
 */
  public void addPrompt(String prompt) {
    this.prompt = prompt;
  }
}
