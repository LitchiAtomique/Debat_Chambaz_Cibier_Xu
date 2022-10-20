package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    NumberArgMenu numberArgMenu =  new NumberArgMenu();
    numberArgMenu.addPrompt("Entrer le nombre d'argument");
    numberArgMenu.run(scanner);
    int numberArguments = numberArgMenu.getValue();

    ContradictionChoiceMenu contradictionChoiceMenu = new ContradictionChoiceMenu();
    contradictionChoiceMenu.addPrompt("Sélectionner un choix");
    contradictionChoiceMenu.addChoice("Ajouter une contradiction", () -> contradictionChoiceMenu.contradictionAdd());
    contradictionChoiceMenu.addChoice("Fin", () -> contradictionChoiceMenu.end());
    contradictionChoiceMenu.run(scanner);

    ArgumentChoiceMenu argumentChoiceMenu = new ArgumentChoiceMenu();
    argumentChoiceMenu.addPrompt("Sélectionner un choix");
    argumentChoiceMenu.addChoice("Ajouter un argument", () -> argumentChoiceMenu.argumentAdd());
    argumentChoiceMenu.addChoice("Retirer un argument", () -> argumentChoiceMenu.argumentDel());
    argumentChoiceMenu.addChoice("Vérifier la solution", () -> argumentChoiceMenu.check());
    argumentChoiceMenu.addChoice("Fin", () -> argumentChoiceMenu.end());
    argumentChoiceMenu.run(scanner);
	}
}
