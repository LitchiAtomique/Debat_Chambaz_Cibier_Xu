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
    try {
      if (this.arguments.get(id) == null) {
        throw new Exception("Error, argument is not in the list of arguments");
      }
    } catch (Exception e) {
      throw new Exception("Error, argument is not in the list of arguments");
    }

    try {
      if (this.arguments.get(contradiction.getContradicts()) == null) {
      throw new Exception("Error, contradiction makes reference to argument not in the list");
      }
    } catch (Exception e) {
      throw new Exception("Error, contradiction makes reference to argument not in the list");
    }

    if (contradiction.getContradicts() == id) {
      throw new Exception("Error, argument and contradiction can not have reference the same arguement");
    }

    for (Contradiction cont: this.arguments.get(id).getContradictions()) {
      if (cont.getContradicts() == contradiction.getContradicts()) {
        throw new Exception("Error, contradiction already present for this argument");
      }
    }

    this.arguments.get(id).addContradiction(contradiction);
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
    this.arguments.add(argument.getId(), argument);
  }

  /**
   * Removes an argument from the list of arguments
   * @param i Index to remove
   */
  public void del(int id) throws Exception {
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

    this.arguments.set(tId, null);
  }

  /**
   * Checks the validity of a arguments
   */
  public boolean check() {
    return false;
  }

  public ArrayList<Argument> getArguments() {
    return this.arguments;
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
  /**
   * Returns to string all arguments of the graph.
   */
  public String toString() {
    System.out.println("Printing");
    String out = "";
    out += "{\n";
    for (int i = 0; i < this.arguments.size(); i++) {
      Argument argument = this.arguments.get(i);
      if (argument == null) {
        continue;
      }
      out += "  " + argument + ": [";
      for (int j = 0; j < argument.getNumberContradictions(); j++) {
        out += argument.getContradiction(j);
        if (j < argument.getNumberContradictions() - 1) {
          out += ", ";
        }
      }
      out += "]\n";
    }
    out += "}\n";
    return out;
  }
}
