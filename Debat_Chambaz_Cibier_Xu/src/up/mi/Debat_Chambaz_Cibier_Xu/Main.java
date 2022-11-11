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
    Arguments arguments = new Arguments(numberArguments);

    System.out.print(arguments);

    ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
    contradictionChoiceMenu.addScanner(scanner);
    contradictionChoiceMenu.addPrompt("Sélectionner un choix");
    contradictionChoiceMenu.addChoice("Ajouter une contradiction", () -> contradictionChoiceMenu.contradictionAdd(arguments));
    contradictionChoiceMenu.addChoice("Fin", () -> contradictionChoiceMenu.end());

    try {
      contradictionChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }

    System.out.print(arguments);

    Arguments solution = new Arguments(arguments);

    ArgumentChoiceMenu argumentChoiceMenu = new ArgumentChoiceMenu();
    argumentChoiceMenu.addScanner(scanner);
    argumentChoiceMenu.addPrompt("Sélectionner un choix");
    argumentChoiceMenu.addChoice("Ajouter un argument", () -> argumentChoiceMenu.argumentAdd(arguments, solution));
    argumentChoiceMenu.addChoice("Retirer un argument", () -> argumentChoiceMenu.argumentDel(solution));
    argumentChoiceMenu.addChoice("Vérifier la solution", () -> argumentChoiceMenu.check(arguments, solution));
    argumentChoiceMenu.addChoice("Fin", () -> argumentChoiceMenu.end());

    try {
      argumentChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
  }
}
