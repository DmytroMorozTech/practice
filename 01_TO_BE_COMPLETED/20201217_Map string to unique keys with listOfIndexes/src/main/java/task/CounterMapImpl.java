package task;

import java.util.*;

public class CounterMapImpl<A, I> implements task.Counter<A, I> {

  private final Map<A, List<I>> map = new HashMap<>();

  public void count(I index, A symbol) {
    if (map.containsKey(symbol)) {
      List<I> indexes = map.get(symbol);
      indexes.add(index);
    } else {
      ArrayList<I> empty = new ArrayList<>();
      empty.add(index);
      map.put(symbol, empty);
    }
  }

  @Override
  public Iterator<Map.Entry<A, List<I>>> iterator() {
    return map       // Map<A, List<Integer>>
        .entrySet()  // Set<Map.Entry<A, List<Integer>>>
        .iterator(); // Iterator<Map.Entry<A, List<Integer>>>
  }

//  public Map<Character, List<Integer>> get() {
//    return map;
//  }

}
