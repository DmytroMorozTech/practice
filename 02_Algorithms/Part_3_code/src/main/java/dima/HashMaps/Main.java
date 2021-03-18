package dima.HashMaps;

import dima.HashMaps.Excercises.HashTableExcercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String s = "a green apple";
//        FirstNonRepeatedLetter FNRLetter = new FirstNonRepeatedLetter();
//        char letter = FNRLetter.findLetter(s);
//        System.out.printf("FirstNonRepeatedLetter: %c \n", letter);
//        -----------------------------------------------------------------------
//
//        char firstRepeatedChar = FNRLetter.findFirstRepeatedChar(s);
//        System.out.printf("firstRepeatedChar: %c \n", firstRepeatedChar);
//        -----------------------------------------------------------------------

//        HashMapMyImplementation myHashMap = new HashMapMyImplementation(10);
//        myHashMap.put(1,"John");
//        myHashMap.put(1,"Johnny Junior");
//        myHashMap.put(2,"Suzzie");
//        myHashMap.put(11,"PHIL");
//
//        String getFirstElem = myHashMap.get(1);
//        System.out.println(getFirstElem);
//
//        myHashMap.put(5,"Viktor Penny");
//        myHashMap.remove(5);
//        System.out.println("THE END");
//        -----------------------------------------------------------------------
//        HashMapMyImplementation table = new HashMapMyImplementation(5);
//        table.put(6, "A");
//        table.put(8, "B");
//        table.put(11, "C");
//        table.put(6, "A+");
//        table.remove(6);
//        System.out.println(table.get(10));
//        -----------------------------------------------------------------------

//        HashTableExcercises hte = new HashTableExcercises();
//        int[] intArr = {1, 7, 5, 9, 2, 12, 3};
//        int res = hte.countPairsWithDiff(intArr, 2);
//        System.out.println(res);
//        -----------------------------------------------------------------------

        HashTableExcercises hte = new HashTableExcercises();
        int[] arr = {2, 7, 11, 15};
        int[] resOfTwoSumFunc = hte.twoSum(arr, 9);
        System.out.println(Arrays.toString(resOfTwoSumFunc));
        // Expected output: [0,1]

    }
}
