import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertDecimalToBinary {
    List<Integer> remaindersArr = new ArrayList<>();

    public void findDivisionRemainder(int dividend, int divisor) {
        if (dividend < divisor) {
            remaindersArr.add(dividend);
            return;
        }
        int divisionResultInt = (int) (dividend / divisor);
        int divisionRemainder = dividend % divisor;
        remaindersArr.add(divisionRemainder);

        findDivisionRemainder(divisionResultInt, divisor);
    }

    public String findBinaryValue(int decimalValue) {
        boolean isPositiveNumber = decimalValue > 0;
        findDivisionRemainder(Math.abs(decimalValue), 2);
        Collections.reverse(remaindersArr);
        List<String> collect = remaindersArr.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        String binaryValue = String.join("", collect);
        String finalResult = isPositiveNumber ? binaryValue : "-".concat(binaryValue);
        return finalResult;
    }
}
