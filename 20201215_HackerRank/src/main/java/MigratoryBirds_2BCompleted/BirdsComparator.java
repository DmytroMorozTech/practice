package MigratoryBirds_2BCompleted;

import java.util.Comparator;
import java.util.Map;

public class BirdsComparator implements Comparator<Map.Entry<Integer, Integer>>{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();
    }
}
