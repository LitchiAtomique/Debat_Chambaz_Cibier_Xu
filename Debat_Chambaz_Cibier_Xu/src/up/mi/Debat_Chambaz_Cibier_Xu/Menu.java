package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

/**
 * Menu class that displays a choice menu
 */
abstract public class Menu {
  Scanner scanner;
  String prompt;

  void addScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  void addPrompt(String prompt) {
    this.prompt = prompt;
  }
}
