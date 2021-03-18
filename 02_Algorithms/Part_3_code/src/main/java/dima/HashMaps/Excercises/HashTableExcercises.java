package dima.HashMaps.Excercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExcercises {
//    ------------------------------------------------------------------------------------------------------
//    Find the most repeated element in an array of integers. What is the time complexity of this method?
//    (A variation of this exercise is finding the most repeated word in a sentence.
//    The algorithm is the same. Here we use an array of numbers for simplicity.)
//    Input: [1, 2, 2, 3, 3, 3, 4] Output: 3

    // O(n)
    public int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        // Runtime complexity of this method is O(n) because we have to
        // iterate the entire array to populate our hash table.

        return result;
    }

//    ------------------------------------------------------------------------------------------------------
    // TASK:
    // Given an array of integers, count the number of unique pairs of integers that have difference k.
    // Input: [1, 7, 5, 9, 2, 12, 3] K=2

    // O(n)
    public int countPairsWithDiff(int[] numbers, int difference) {
        Set<Integer> set = new HashSet<>();
        for (int number: numbers)
            set.add(number);

        int count = 0;

        for (int number: numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }
        return count;
    }

//    ------------------------------------------------------------------------------------------------------
//    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//    Input: [2, 7, 11, 15] - target = 9
//    Output: [0, 1] (because 2 + 7 = 9)
//    Assume that each input has exactly one solution, and you may not use the same element twice.

    // O(n)
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        // Time complexity of this method is O(n) because we need to iterate
        // the array only once.

        return null;
    }
}
