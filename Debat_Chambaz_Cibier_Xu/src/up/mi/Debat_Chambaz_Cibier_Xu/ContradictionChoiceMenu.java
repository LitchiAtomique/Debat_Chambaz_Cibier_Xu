package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the contradiction choice menu
 */
public class ContradictionChoiceMenu extends ChoiceMenu {
  /**
   * Adds a contradiction
   */
  public void contradictionAdd(int size, Arguments arguments) {
    int args[] = IO.ioGetArgs(this.scanner, "Entrer la liste des arguments (A{n1} A{n2})", size);
    
    try {
    	arguments.addContradiction(args[0]-1, new Contradiction(args[1]-1));
    }catch (Exception e) {
        System.out.println(e);
        return;
    }
    System.out.println("Contradiction ajoutée");
    System.out.println((args[0]-1)+", "+ (args[1]-1));
  }
}
