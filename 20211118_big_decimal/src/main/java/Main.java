// Nice article re: BigDecimal
// https://blogs.oracle.com/javamagazine/post/four-common-pitfalls-of-the-bigdecimal-class-and-how-to-avoid-them
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

// In the sample below we will get: 0.6100000000000001
//        System.out.println(1.03 - .42);

// In the sample below we will get: 0.09999999999999998
//        System.out.println(1.00 - 9 * .10);

// ----------------------------------
        /**
         * Actual output in the sample below will be:
         *  3 items bought
         *  Change: $0.3999999999999999
         *
         *  This is not what we really want!
         *  That is why we should never use data types Double and Float for operations with money.
         *  For these purposes we should use BigDecimal.
         */
//        double funds = 1.00;
//        int itemsBought = 0;
//        for (double price = .10; funds >= price; price += .10) {
//            funds -= price;
//            itemsBought++;
//        }
//        System.out.println(itemsBought + " items bought");
//        System.out.println("Change: $" + funds);
//
// ----------------------------------
        /**
         * In a sample below we can see, that everything works just as expected.
         */
//        final BigDecimal TEN_CENTS = new BigDecimal(".10");
//        int itemsBought = 0;
//        BigDecimal funds = new BigDecimal("1.00");
//
//        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
//            itemsBought++;
//            funds = funds.subtract(price);
//        }
//
//        System.out.println(itemsBought + " items bought");
//        System.out.println(funds);
// ----------------------------------
        /**
         * According to java docs we should avoid using constructor of BigDecimal, where we have to pass double into it;
         * Because the result that we get may be unexpected. Iт this case it will be:
         * 23.760000000000001563194018672220408916473388671875
         * Therefore we should use the String constructor in preference to the double constructor.
         */
        BigDecimal bigDecimalStrConstructor1 = new BigDecimal("23.76");
        System.out.println(bigDecimalStrConstructor1);

        BigDecimal bigDecimalStringConstructor2 = new BigDecimal(String.valueOf(23.76));
        System.out.println(bigDecimalStringConstructor2);

        BigDecimal bigDecimalDoubleConstructor = new BigDecimal(23.76);
        System.out.println(bigDecimalDoubleConstructor);

    }
}
