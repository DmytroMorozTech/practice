import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = MockDataBase.getAll();

        // What we are doing here:
        // customer -> customer.getEmail()      one to one mapping
        List<String> emails = customers
                .stream() // Stream<Customer>
                .map(customer -> customer.getEmail()) // we map Customer object to String (customer.getEmail());
                .collect(Collectors.toList());
        System.out.println(emails);

        // customer -> customer.getPhoneNumbers()   one to many mapping
        List<List<String>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        // customer -> customer.getPhoneNumbers()   one to many mapping
        List<String> phonesFlattened = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phonesFlattened);


    }
}
