package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Menu class that displays a choice menu
 */
abstract public class Menu {
  String prompt;

  void addPrompt(String prompt) {
    this.prompt = prompt;
  }
}
