import java.util.*;

class Solution {
    // Global index to traverse the formula string
    int index = 0;

    public String countOfAtoms(String formula) {
        // Parse the formula and get the count of each atom
        Map<String, Integer> atomCounts = parseFormula(formula);

        // Use TreeMap to automatically sort atoms by their names
        TreeMap<String, Integer> sortedAtomCounts = new TreeMap<>(atomCounts);

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedAtomCounts.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula) {
        Map<String, Integer> atomCounts = new HashMap<>();

        while (index < formula.length() && formula.charAt(index) != ')') {
            if (formula.charAt(index) == '(') {
                index++; // Move past the '('
                Map<String, Integer> nestedCounts = parseFormula(formula);
                int multiplier = getMultiplier(formula);
                for (Map.Entry<String, Integer> entry : nestedCounts.entrySet()) {
                    atomCounts.put(entry.getKey(), atomCounts.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
                }
            } else {
                String atom = getAtom(formula);
                int count = getMultiplier(formula);
                atomCounts.put(atom, atomCounts.getOrDefault(atom, 0) + count);
            }
        }

        index++; // Move past the ')'
        return atomCounts;
    }

    private String getAtom(String formula) {
        StringBuilder atom = new StringBuilder();
        atom.append(formula.charAt(index++)); // The first character is uppercase
        while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
            atom.append(formula.charAt(index++));
        }
        return atom.toString();
    }

    private int getMultiplier(String formula) {
        StringBuilder multiplier = new StringBuilder();
        while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
            multiplier.append(formula.charAt(index++));
        }
        return multiplier.length() == 0 ? 1 : Integer.parseInt(multiplier.toString());
    }
}
