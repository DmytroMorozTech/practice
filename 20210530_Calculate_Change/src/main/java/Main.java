// We are given some amount of money (Double value).
// And we are given coin denominations within Set<Integer>.

// TASK: To find out the way for breaking that amount of money into given denominations of coins.
// The number of coins should be minimized: i.e. we should prefer taking one 25 cents coin
// instead of taking 25 coins of 1 cent.

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nominals = new HashSet<>(Arrays.asList(1, 2, 5, 10, 25, 50));
        System.out.println(change(4.73, nominals));
    }

    public static Map<Integer, Integer> change(Double amount, Set<Integer> denominations) {
        List<Integer> sortedNominals = denominations.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        Map<Integer, Integer> result = new HashMap<>();
        Double currentAmount = amount * 100;
        for (Integer nominal : sortedNominals) {
            Integer numbOfCoins = (int) (currentAmount / nominal);
            result.put(nominal, numbOfCoins);
            currentAmount = currentAmount - (nominal * numbOfCoins);
        }

        return result.entrySet()
                .stream()
                .filter(e -> e.getValue() != 0)
                .collect(Collectors.toMap(
                        (e) -> e.getKey(),
                        (e) -> e.getValue()
                ));
    }
}