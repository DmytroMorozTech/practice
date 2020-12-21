package MigratoryBirds_2BCompleted;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        SetDemo.show();
    }

    public static void show() {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c","d"));

        //Union
        set1.addAll(set2);
    }
}
