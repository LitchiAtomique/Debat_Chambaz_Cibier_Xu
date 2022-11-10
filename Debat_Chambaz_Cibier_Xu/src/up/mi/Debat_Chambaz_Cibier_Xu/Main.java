package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	  
    // int numberArguments = 4;
    // Arguments arguments = new Arguments(numberArguments);
    // try {
    //   arguments.addContradiction(0, new Contradiction(1));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }
    // try {
    //   arguments.addContradiction(1, new Contradiction(2));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }
    // try {
    //   arguments.addContradiction(1, new Contradiction(3));
    // } catch(Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // System.out.println("done");

    // Arguments solution = new Arguments();

    // try {
    //   solution.add(arguments.getArgument(0));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // try {
    //   solution.add(arguments.getArgument(1));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // try {
    //   solution.add(arguments.getArgument(2));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // try {
    //   solution.add(arguments.getArgument(3));
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // System.out.println("add done");

    // try {
    //   solution.del(4);
    // } catch (Exception e) {
    //   System.out.println(e);
    //   return;
    // }

    // System.out.println(solution.check());

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

    ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
    contradictionChoiceMenu.addScanner(scanner);
    contradictionChoiceMenu.addPrompt("Sélectionner un choix");
    contradictionChoiceMenu.addChoice("Ajouter une contradiction", () -> contradictionChoiceMenu.contradictionAdd(numberArguments,arguments));
    contradictionChoiceMenu.addChoice("Fin", () -> contradictionChoiceMenu.end());

    try {
      contradictionChoiceMenu.run();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }

    for (int i = 0; i < arguments.getNumberArguments(); i++) {
      System.out.print("[" + i + "]: [");
      Argument argument  = arguments.getArgument(i);
      for (int j = 0; j < argument.getNumberContradictions(); j++) {
        Contradiction contradiction = argument.getContradiction(j);
        System.out.print(contradiction.getContradicts());
        if (j < argument.getNumberContradictions() - 1) {
          System.out.print(", ");
        }
      }
      System.out.println("]");
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
