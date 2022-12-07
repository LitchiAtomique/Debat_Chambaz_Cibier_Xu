package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the solution menu
 */
public class SolutionMenu extends ChoiceMenu {

  public void searchAdmissibleSolution(Solution[] admissibleSolutions, SolutionIndex admissibleSolutionIndex, SolutionMenuSelectionWrapper solutionMenuSelection) {
    admissibleSolutionIndex.increment();
    admissibleSolutionIndex.loop(admissibleSolutions.length);
    System.out.println(admissibleSolutions[admissibleSolutionIndex.getIndex()]);
    solutionMenuSelection.setSolutionMenuSelection(SolutionMenuSelection.ADMISSIBLE_MENU);
  }

  public void searchPreferredSolution(Solution[] preferredSolutions, SolutionIndex preferredSolutionIndex, SolutionMenuSelectionWrapper solutionMenuSelection) {
    preferredSolutionIndex.increment();
    preferredSolutionIndex.loop(preferredSolutions.length);
    System.out.println(preferredSolutions[preferredSolutionIndex.getIndex()]);
    solutionMenuSelection.setSolutionMenuSelection(SolutionMenuSelection.PREFERRED_MENU);
  }

  public void saveSolution(Solution[] admissibleSolutions, SolutionIndex admissibleSolutionIndex, Solution[] preferredSolutions, SolutionIndex preferredSolutionIndex, SolutionMenuSelectionWrapper solutionMenuSelection) {
    Solution toSave = null;
    switch (solutionMenuSelection.getSolutionMenuSelection()) {
      case DEFAULT_MENU: 
        System.out.println("Please select a solution first");
        return;
      case ADMISSIBLE_MENU:
        if (admissibleSolutionIndex.getIndex() == -1) {
          System.out.println("Please select a solution first");
          return;
        }
        toSave = admissibleSolutions[admissibleSolutionIndex.getIndex()];
        break;
      case PREFERRED_MENU:
      if (preferredSolutionIndex.getIndex() == -1) {
        System.out.println("Please select a solution first");
        return;
      }
      toSave = preferredSolutions[preferredSolutionIndex.getIndex()];
    }
    System.out.println("Saving to disk");
    System.out.println("[ " + toSave + " ]");
    Util.saveStringToFile(toSave.toString(), "data/save.txt");
    // TODO - save to a file given by user
  }
}
