package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("usage: Debat_Chambaz_Cibier_Xu file_path");
      System.exit(1);
    }

    try {
      GraphReader.readFile(args[0]);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("done");

//     Scanner scanner = new Scanner(System.in);

//     NumberArgMenu numberArgMenu =  new NumberArgMenu();
//     numberArgMenu.addScanner(scanner);
//     numberArgMenu.addPrompt("Enter number of arguments");
//     numberArgMenu.addFunction(() -> numberArgMenu.setValueFromIO());

//     try {
//       numberArgMenu.run();
//     } catch (Exception e) {
//       System.out.println(e);
//       scanner.close();
//       return;
//     }
//     int numberArguments = numberArgMenu.getValue();
//     Debate debate = new Debate(numberArguments);

//     System.out.println(debate);

//     ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
//     contradictionChoiceMenu.addScanner(scanner);
//     contradictionChoiceMenu.addPrompt("Select a choice");
//     contradictionChoiceMenu.addChoice("Add a contradiction", () -> contradictionChoiceMenu.contradictionAdd(debate));
//     contradictionChoiceMenu.addChoice("End", () -> contradictionChoiceMenu.end());

//     try {
//       contradictionChoiceMenu.run();
//     } catch (Exception e) {
//       System.out.println(e.getMessage());
//       scanner.close();
//       return;
//     }

//     System.out.println("Debate:");
//     System.out.println(debate);

//     Solution solution = new Solution(debate);

//     ArgumentChoiceMenu argumentChoiceMenu = new ArgumentChoiceMenu();
//     argumentChoiceMenu.addScanner(scanner);
//     argumentChoiceMenu.addPrompt("Select a choice");
//     argumentChoiceMenu.addChoice("Add an argument", () -> argumentChoiceMenu.argumentAdd(debate, solution));
//     argumentChoiceMenu.addChoice("Remove an argument", () -> argumentChoiceMenu.argumentDel(solution));
//     argumentChoiceMenu.addChoice("Check solution", () -> argumentChoiceMenu.check(debate, solution));
//     argumentChoiceMenu.addChoice("End", () -> argumentChoiceMenu.end());

//     try {
//       argumentChoiceMenu.run();
//     } catch (Exception e) {
//       System.out.println(e.getMessage());
//       scanner.close();
//       return;
//     }

//     scanner.close();
  }
}
