package up.mi.Debat_Chambaz_Cibier_Xu;

import java.util.ArrayList;

public class SolutionSearcher {
  public static Solution[] getAdmissible(Debate debate) {
    Solution[] out;
    // this is o(2^n) and may result in very slow runtime
    ArrayList<int[]> solutionIndexes = generateSolutions(debate.getNumberArguments());

    ArrayList<Solution> admissibleSolutions = new ArrayList<Solution>();
    for (int[] solutionIndex : solutionIndexes) {
      // we first create the solution from its indexes
      Solution solution = new Solution(debate, solutionIndex);

      // we check that the solution is admissible
      if (solution.check(debate)) {
        admissibleSolutions.add(solution);
      }
    }
    

    // copy value to return a fixed size table
    out = new Solution[admissibleSolutions.size()];
    for (int i = 0; i < out.length; i++) {
      out[i] = admissibleSolutions.get(i);
    }

    return out;
  }

  public static Solution[] getPreferred(Solution[] admissibleSolutions) {
    Solution[] out;
    ArrayList<Solution> preferredSolutions = new ArrayList<Solution>();

    // we iterate over all admissible solutions
    for (Solution solution : admissibleSolutions) {
      // TODO - make sure that the empty solution works if there are no other solutions
      if (solution.isEmpty()) {
        continue;
      }
      // we want to check that there this solutions is not contained in any another solution
      boolean otherContains = false;
      // we iterate over every other solutions
      for (Solution other : admissibleSolutions) {
        // making sure we skip ourselves
        if (other.equals(solution)) {
          continue;
        }
        // if the other solution contains our solution then we can stop as we can be sure that this will not be a preferred solution
        if (other.contains(solution)) {
          otherContains = true;
          break;
        }
      }
      // if our argument is not contained in any other arguments then we can add it to the list of preferred solution
      if (!otherContains) {
        preferredSolutions.add(solution);
      }
    }

    // copy value to return a fixed size table
    out = new Solution[preferredSolutions.size()];
    for (int i = 0; i < out.length; i++) {
      out[i] = preferredSolutions.get(i);
    }

    return out;
  }

  private static ArrayList<int[]> generateSolutions(int order) {
    ArrayList<int[]> out = new ArrayList<int[]>();
    for (int i = 0; i <= order; i++) {
      ArrayList<int[]> combinations = generateCombinations(order, i);
      out.addAll(combinations);
    }
    return out;
  }

  private static ArrayList<int[]> generateCombinations(int n, int k) {
    ArrayList<int[]> out = new ArrayList<int[]>();
    generateCombinationRec(out, new int[k], 0, n - 1, 0);
    return out;
  }

  private static void generateCombinationRec(ArrayList<int[]> combinations, int data[], int start, int end, int index) {
    if (index == data.length) {
      int[] combination = data.clone();
      combinations.add(combination);
    } else if (start <= end) {
      data[index] = start;
      generateCombinationRec(combinations, data, start + 1, end, index + 1);
      generateCombinationRec(combinations, data, start + 1, end, index);
    }
  }
}
