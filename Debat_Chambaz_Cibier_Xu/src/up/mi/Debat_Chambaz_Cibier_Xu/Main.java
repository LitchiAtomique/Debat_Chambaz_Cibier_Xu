package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    NumberArgMenu numberArgMenu =  new NumberArgMenu();
    numberArgMenu.addScanner(scanner);
    numberArgMenu.addPrompt("Enter number of arguments");
    numberArgMenu.addFunction(() -> numberArgMenu.GetInt());

    try {
      numberArgMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      scanner.close();
      return;
    }
    int numberArguments = numberArgMenu.getValue();
    Arguments arguments = new Arguments(numberArguments);

    System.out.print(arguments);

    ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
    contradictionChoiceMenu.addScanner(scanner);
    contradictionChoiceMenu.addPrompt("Select a choice");
    contradictionChoiceMenu.addChoice("Add a contradiction", () -> contradictionChoiceMenu.contradictionAdd(arguments));
    contradictionChoiceMenu.addChoice("End", () -> contradictionChoiceMenu.end());

    try {
      contradictionChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      scanner.close();
      return;
    }

    System.out.print(arguments);

    Arguments solution = new Arguments(arguments);

    ArgumentChoiceMenu argumentChoiceMenu = new ArgumentChoiceMenu();
    argumentChoiceMenu.addScanner(scanner);
    argumentChoiceMenu.addPrompt("Select a choice");
    argumentChoiceMenu.addChoice("Add an argument", () -> argumentChoiceMenu.argumentAdd(arguments, solution));
    argumentChoiceMenu.addChoice("Remove an argument", () -> argumentChoiceMenu.argumentDel(solution));
    argumentChoiceMenu.addChoice("Check soltution", () -> argumentChoiceMenu.check(arguments, solution));
    argumentChoiceMenu.addChoice("End", () -> argumentChoiceMenu.end());

    try {
      argumentChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      scanner.close();
      return;
    }

    scanner.close();
  }
}
