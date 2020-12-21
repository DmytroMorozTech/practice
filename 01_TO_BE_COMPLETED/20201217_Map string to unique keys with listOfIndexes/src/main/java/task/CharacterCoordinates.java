package task;

import java.util.List;
import java.util.Map;

/**
 * "Hello, my dear friend, please keep learning, I'll guarantee you'll reach the moment you understand everything"
 *
 * e:16:<2,12,19,26,29,32,33,37,58,59,69,76,81,92,100,102>
 * l:8:<3,4,25,36,48,49,65,66>
 * n:8:<20,40,42,56,82,90,97,108>
 * r:7:<14,17,39,54,68,93,103>
 * a:7:<13,27,38,53,55,70,96>
 * t:5:<57,74,83,95,105>
 * i:4:<18,41,46,107>
 * h:4:<1,72,75,106>
 * u:4:<52,63,87,89>
 * d:4:<11,21,91,98>
 * y:4:<9,61,85,104>
 * o:4:<5,62,79,86>
 * g:3:<43,51,109>
 * m:3:<8,78,80>
 * s:2:<28,94>
 * p:2:<24,34>
 * k:1:<31>
 * f:1:<16>
 * c:1:<71>
 * v:1:<101>
 */
public class CharacterCoordinates {

  public static void doSmth(Counter<Character, Integer> c) {
    String s = "Hello, my dear friend, please keep learning, I'll guarantee you'll reach the moment you understand everything";

    for (int i = 0; i < s.length(); i++) {
      c.count(i, s.charAt(i));
    }

//    Map<Character, List<Integer>> result = c.get();
//    result.clear();
//    Set<Map.Entry<Character, List<Integer>>> entries = result.entrySet();

    for (Map.Entry<Character, List<Integer>> e: c) {
      Character symbol = e.getKey();
      List<Integer> indexes = e.getValue();
      System.out.printf("%c:%d:%s\n", symbol, indexes.size(), indexes);
    }

  }

  public static void main(String[] args) {
    doSmth(new CounterMapImpl<>());
  }
}
