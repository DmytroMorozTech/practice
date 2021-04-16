import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockDataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "John", "john@gmail.com", Arrays.asList("12312345", "33322243")),
                new Customer(102, "Abby", "abby@gmail.com", Arrays.asList("222222222", "333333333")),
                new Customer(103, "Peter", "peter@gmail.com", Arrays.asList("444444444", "555555555")),
                new Customer(104, "Jason", "jason@gmail.com", Arrays.asList("666666666", "777777777")),
                new Customer(105, "Viktor", "viktor@gmail.com", Arrays.asList("888888888", "999999999"))
        ).collect(Collectors.toList());
    }
}
