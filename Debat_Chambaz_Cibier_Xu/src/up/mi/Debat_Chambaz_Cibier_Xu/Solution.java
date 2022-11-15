package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.ArrayList;

public class Solution extends Debate {

  public Solution(Debate debate) {
    this.arguments = new ArrayList<Argument>();
    for (int i = 0; i < debate.getNumberArguments(); i++) {
      this.arguments.add(null);
    }
  }

  public boolean check(Debate debate) {
    for (Argument arg : this.getArguments()) {
      if (arg == null) continue;
      for (Argument other : this.getArguments()) {
        if (other == null) continue;
        if (other.contradicts(arg)) {
          return false;
        }
      }
    }
    for (Argument arg : this.getArguments()) {
      if (arg == null) continue;
      for (Argument other : debate.getArguments()) {
        if (other.contradicts(arg)) {
          boolean isDefended = false;
          for (Argument defender : this.getArguments()) {
            if (defender == null) continue;
            if (defender.contradicts(other)) {
              isDefended = true;
              break;
            }
          }
          if (!isDefended) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public String toString() {
    if (this.isEmpty())
      return "[ ]";
    String out = "";
    out += "[ ";
    for (int i = 0; i < this.arguments.size(); i++) {
      Argument argument = this.arguments.get(i);
      if (argument == null)
        continue;
      out += argument;
      out += ", ";
    }
    out = out.substring(0, out.length() - 2);
    out += " ]";
    return out;
  }
}
