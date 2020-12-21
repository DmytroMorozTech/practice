package task;

import java.util.List;
import java.util.Map;

public interface Counter<A, I> extends Iterable<Map.Entry<A, List<I>>> {
  void count(I index, A symbol);
}
