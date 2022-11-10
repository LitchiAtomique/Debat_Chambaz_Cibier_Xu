package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.ArrayList;

/**
 * Container class for arguments
 * It is modeled after the adjency list
 */
public class Arguments {
  private ArrayList<Argument> arguments;

  /**
   * Initializes the list of arguments
   */
  public Arguments() {
    this.arguments = new ArrayList<Argument>();
  }

  /**
   * Initializes the arguments with a number of arguments
   * @param n Number of arguments to create the list with
   */
  public Arguments(int n) {
    this.arguments = new ArrayList<Argument>();
    for (int i = 0; i < n; i++) {
      this.arguments.add(new Argument(i));
    }
  }

  /**
   * Adds a contradiction for an argument
   * @param id The index of the argument to add a contradiction to
   * @param contradiction The contradiction to add
   */
  public void addContradiction(int id, Contradiction contradiction) throws Exception {
    int tId = -1;
    for (int i = 0; i < this.arguments.size(); i++) {
      if (this.arguments.get(i).getId() == id) {
        tId = i;
        break;
      }
    }

    if (tId == -1) {
      throw new Exception("Error, argument is not in the list of arguments");
    }

    int cId = contradiction.getContradicts();
    boolean contradictionPresent = false;
    for (int i = 0; i < this.arguments.size(); i++) {
      if (this.arguments.get(i).getId() == cId) {
        contradictionPresent = true;
        break;
      }
    }

    if (!contradictionPresent) {
      throw new Exception("Error, contradiction makes reference to argument not in the list");
    }

    if (cId == id) {
      throw new Exception("Error, argument and contradiction can not have reference the same arguement");
    }

    this.arguments.get(tId).addContradiction(contradiction);

    // if (i < 0 || i >= this.arguments.size()) {
    //   throw new Exception("Error, argument is not in list of argument");
    // }
    // if (contradiction.getContradicts() < 0 || contradiction.getContradicts() >= this.arguments.size()) {
    //   throw new Exception("Error, contradiction makes reference to argument not in the list");
    // }
    // if (i == contradiction.getContradicts()) {
    //   throw new Exception("Error, argument and contradiction can not have reference the same arguement");
    // }
    // this.arguments.get(i).addContradiction(contradiction);
  }

  /**
   * Adds an argument to the list of arguments
   * @param argument Argument to add
   */
  public void add(Argument argument) throws Exception {
    for (Argument arg : this.arguments) {
      if (arg.equals(argument)) {
        throw new Exception("Error, argument already present in the solution");
      }
    }
    this.arguments.add(argument);

  }

  /**
   * Removes an argument from the list of arguments
   * @param i Index to remove
   */
  public void del(int i) throws Exception {
    // TODO - Paul Chambaz - Needs a refactor so that argument have an proper id
    // then the id for this deletion should be the actual id of the argument, not the index in the adjency list
    if (i < 0 || i >= this.arguments.size()) {
      throw new Exception("Error, argument is not in the list");
    }

    this.arguments.remove(i);
  }

  /**
   * Checks the validity of a arguments
   */
  public boolean check() {
    return false;
  }

  public int getNumberArguments() {
    return this.arguments.size();
  }

  /**
   * Gets an argument from its id
   * @param i Index of argument to get
   */
  public Argument getArgument(int id) {
    for (int i = 0; i < this.arguments.size(); i++) {
      if (id == arguments.get(i).getId()) {
        return this.arguments.get(i);
      }
    }
    return null;
  }

  public void print() {
    for (int i = 0; i < this.arguments.size(); i++) {
      Argument argument = this.arguments.get(i);
      System.out.print(i);
      // argument.print();
      System.out.print(": [");
      for (int j = 0; j < argument.getNumberContradictions(); j++) {
        argument.getContradiction(j).print();
        if (j < argument.getNumberContradictions() - 1) {
          System.out.print(", ");
        }
      }
      System.out.println("]");
    }
  }
}
