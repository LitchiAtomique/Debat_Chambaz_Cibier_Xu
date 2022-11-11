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
    System.out.println("dest");
    System.out.println(dest);
    try {
      dest.add(source.getArgument(arg));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println("test");
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
    for (Argument arg : solution.getArguments()) {
      for (Argument other : solution.getArguments()) {
        if (other.contradicts(arg)) {
          noContradiction = false;
          break;
        }
      }
    }
    boolean defence = true;
    for (Argument arg : solution.getArguments()) {
      if (arg == null) {
        continue;
      }
      for (Argument other : arguments.getArguments()) {
        if (other == null) {
          continue;
        }
        if (other.contradicts(arg)) {
          boolean isContradictContradicted = false;
          for (Argument otherContradict : solution.getArguments()) {
            if (otherContradict == null) {
              continue;
            }
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
    if (noContradiction && defence) {
      System.out.println("This set of solution is admissible");
    } else {
      System.out.println("This set of solution is not admissible");
    }
  }
}
