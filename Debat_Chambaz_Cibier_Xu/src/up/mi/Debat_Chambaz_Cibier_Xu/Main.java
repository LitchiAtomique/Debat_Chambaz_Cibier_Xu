package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    NumberArgMenu numberArgMenu =  new NumberArgMenu();
    numberArgMenu.addScanner(scanner);
    numberArgMenu.addPrompt("Entrer le nombre d'argument");
    numberArgMenu.addFunction(() -> numberArgMenu.GetInt());

    try {
      numberArgMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
    int numberArguments = numberArgMenu.getValue();

    ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
    contradictionChoiceMenu.addScanner(scanner);
    contradictionChoiceMenu.addPrompt("Sélectionner un choix");
    contradictionChoiceMenu.addChoice("Ajouter une contradiction", () -> contradictionChoiceMenu.contradictionAdd());
    contradictionChoiceMenu.addChoice("Fin", () -> contradictionChoiceMenu.end());

    try {
      contradictionChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }

    ArgumentChoiceMenu argumentChoiceMenu = new ArgumentChoiceMenu();
    argumentChoiceMenu.addScanner(scanner);
    argumentChoiceMenu.addPrompt("Sélectionner un choix");
    argumentChoiceMenu.addChoice("Ajouter un argument", () -> argumentChoiceMenu.argumentAdd());
    argumentChoiceMenu.addChoice("Retirer un argument", () -> argumentChoiceMenu.argumentDel());
    argumentChoiceMenu.addChoice("Vérifier la solution", () -> argumentChoiceMenu.check());
    argumentChoiceMenu.addChoice("Fin", () -> argumentChoiceMenu.end());

    try {
      argumentChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
  }
}
