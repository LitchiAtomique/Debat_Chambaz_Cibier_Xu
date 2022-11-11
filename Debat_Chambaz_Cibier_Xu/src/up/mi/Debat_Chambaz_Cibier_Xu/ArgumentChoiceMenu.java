package up.mi.Debat_Chambaz_Cibier_Xu;

/**
 * Class for the argument choice menu
 */
public class ArgumentChoiceMenu extends ChoiceMenu {
  /**
   * Adds an argument to the list of arguments
   * @param source arguments to copy from
   * @param dest arguments to copy to
   */
  public void argumentAdd(Arguments source, Arguments dest) {
    System.out.print(source);
    int arg = IO.ioGetArg(this.scanner, "Enter argument to add (An)");
    try {
      dest.add(source.getArgument(arg));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.print(dest);
  }

  /**
   * Deletes an argument from the list of arguments
   */
  public void argumentDel(Arguments arguments) {
    System.out.print(arguments);
    int arg = IO.ioGetArg(this.scanner, "Enter argument to remove (An)");
    try {
      arguments.del(arg);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ;
    }
    System.out.print(arguments);
  }

  /**
   * Checks the validity of a logical state
   */
  public void check(Arguments arguments, Arguments solution) {
    boolean noContradiction = true;
    // in practice this is O(n^2) since it is O(n^2 * m) and since the graph is a tree m is always equals to 1 (each argument can only contradict one argument)
    // transforming to adjency matrix requires O(n^2) so complexity is equivalent
    // finally this is just a complete lookup of the matrix
    // TODO: find a better solution is definite O(n^2) or O(nlog(n))
    for (Argument arg : solution.getArguments()) {
      for (Argument other : solution.getArguments()) {
        if (other.contradicts(arg)) {
          noContradiction = false;
          break;
        }
      }
    }
    // this is terrible since it is O(n^3)
    // TODO: find a better solution - this could mean changing data structures
    boolean defence = true;
    for (Argument arg : solution.getArguments()) {
      for (Argument other : arguments.getArguments()) {
        if (other.contradicts(arg)) {
          boolean isContradictContradicted = false;
          for (Argument otherContradict : solution.getArguments()) {
            if (otherContradict.contradicts(other)) {
              isContradictContradicted = true;
              break;
            }
          }
          if (!isContradictContradicted) {
            defence = false;
            break;
          }
        }
      }
    }
    // System.out.println("No Contradiction: " + noContradiction);
    // System.out.println("Defence: " + defence);
    // System.out.println("Result: " + (noContradiction && defence));
    if (noContradiction && defence) {
      System.out.println("This set of solution is admissible");
    } else {
      System.out.println("This set of solution is not admissible");
    }
  }
}
