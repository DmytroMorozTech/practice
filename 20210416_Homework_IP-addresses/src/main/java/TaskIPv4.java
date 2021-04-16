import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskIPv4 {

    static class IP {
        final int a;
        final int b;
        final int c;
        final int d;

        IP(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return String.format("%d.%d.%d.%d", a, b, c, d);
        }
    }

    static class IPStructure {

        private final Map<Integer, Map<Integer, Map<Integer, Set<Integer>>>> data = new HashMap<>();

        void add(IP ip) {
            if (this.contains(ip)) {
                System.out.printf("Ip %s is already present in data-structure.\n", ip);
                return;
            }
            // we shouldn't do anything if given IP is already present in the IPStructure

            if (!isValid(ip.toString()).isPresent()) {
                System.out.printf("Ip %s is INVALID.\n", ip);
                return;
            }

            Set<Integer> setD = new HashSet<>();
            setD.add(ip.d);
            Map<Integer, Set<Integer>> mapCD = new HashMap<>();
            mapCD.put(ip.c, setD);
            Map<Integer, Map<Integer, Set<Integer>>> mapBCD = new HashMap<>();
            mapBCD.put(ip.b, mapCD);

            // if ip.a is not found in data:
            if (!data.containsKey(ip.a)) {
                data.put(ip.a, mapBCD);
                return;
            }

            if (data.get(ip.a).containsKey(ip.b)) {

                // contains ip.a, ip.b, ip.c  -> we should only add data(ip.d)
                // to the Set<Integer> at the bottom of hierarchy.
                if (data.get(ip.a).get(ip.b).containsKey(ip.c)) {

                    Set<Integer> setC = data.get(ip.a).get(ip.b).get(ip.c);
                    setC.add(ip.d);
                    return;
                }

                // contains ip.a, ip.b, but doesn't contain ip.c, ip.d:
                Map<Integer, Set<Integer>> mapAB = data.get(ip.a).get(ip.b);
                mapAB.put(ip.c, setD);
                return;
            }

            //contains only ip.a data
            Map<Integer, Map<Integer, Set<Integer>>> mapA = data.get(ip.a);
            mapA.put(ip.b, mapCD);

        }

        void add(String ip) {
            if (isValid(ip).isPresent()) {
                add(isValid(ip).get());
                return;
            }
            System.out.printf("IP %s is INVALID.\n", ip);
        }

        boolean contains(IP ip) {
            return data.containsKey(ip.a)
                    && data.get(ip.a).containsKey(ip.b)
                    && data.get(ip.a).get(ip.b).containsKey(ip.c)
                    && data.get(ip.a).get(ip.b).get(ip.c).contains(ip.d);
        }

        boolean contains(String ip) {
            return isValid(ip)             // Optional<IP>
                    .map(x -> contains(x))       // Optional<Boolean> true / false
                    .orElse(false);
        }

        @Override
        public String toString() {
            String dataAsStr = data.entrySet().stream().map(e -> e.toString()).collect(Collectors.joining("\n"));
            return "*********************************\n" +
                    "IPStructure\n" +
                    "data:\n" + dataAsStr +
                    "\n*********************************\n";
        }
    }

    /**
     * 1. validation
     * <p>
     * 1.2a.3.5 - x
     * abracadabra - x
     * 256.1.1.1 - x
     * 1.1.1.1.1 - x
     * <p>
     * 0..255
     * <p>
     * 256 * 256 * 256 * 256
     * <p>
     * 2. structure ho hold them
     * <p>
     * 1.000.000
     * <p>
     * 1.2.3.4
     * 1.2.3.5
     * 1.2.3.15
     * <p>
     * 8.8.8.8
     * 8.8.8.10
     * 8.8.8.20
     * <p>
     * 8.8.18.8
     * 8.8.18.10
     * 8.8.18.20
     * <p>
     * 8.28.18.8
     * 8.28.18.10
     * 8.28.18.20
     * <p>
     * 100.156.5.6
     * 8.7.9.3
     * <p>
     * check: 11.b.c.d // O(1)
     * <p>
     * HashSet<IP>
     * 4.294.901.760
     * <p>
     * Map<Int, Map<Int, Map<Int, Set<Int>>>>
     */

    static Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException x) {
            return Optional.empty();
        }
    }

    static Optional<IP> isValid(String ip) {
        String[] s4 = ip.split("\\.");
        if (s4.length != 4) return Optional.empty();

        List<Integer> i4 = Arrays.stream(s4)
                .flatMap(x -> toInt(x).map(Stream::of).orElse(Stream.empty()))
//      .flatMap(x -> {
//        Optional<Integer> oi = toInt(x);
//        if (oi.isPresent()) return Stream.of(oi.get());
//        return Stream.empty();
//      })
                .filter(x -> x >= 0 && x <= 255)
                .collect(Collectors.toList());
        if (i4.size() != 4) return Optional.empty();

        return Optional.of(new IP(
                i4.get(0), i4.get(1), i4.get(2), i4.get(3)
        ));
    }

    static Stream<String> source() {
        return Stream.of(
                "1.2.3.4",
                "1.2.3.5",
                "8.8.8.8",
                "100.156.5.6",
                "8.7.9.3",
                "1.2a.3.5",
                "abracadabra",
                "256.1.1.1",
                "1.1.1.1.1",
                "244.244.1.2",
                "244.244.1.5",
                "244.244.2.23",
                "244.244.2.2",
                "244.244.2.5",
                "244.244.2.8",
                "244.244.2f.5",
                "288.1.1.1",
                "245.245.245.245"
        );
    }

    static IPStructure add(IPStructure ips, IP ip) {
        ips.add(ip);
        return ips;
    }

    static IPStructure add(IPStructure ips, String ip) {
        isValid(ip).ifPresent(x -> ips.add(x));
        return ips;
    }

    /**
     * O(n) - x
     * O(C) ==> O(1)
     * O(4)
     */
    static boolean contains(IPStructure ips, String ip) {
        throw new IllegalArgumentException();
    }

    public static Stream<IP> convert(Stream<String> src) {
        return src
                .flatMap(x -> isValid(x).map(Stream::of).orElse(Stream.empty()));
    }

    public static void main(String[] args) {
        System.out.println("All valid IPs that are stored in source() function:");
        System.out.println("---------------------------------------------------------");
        convert(source())
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------------");

        IPStructure ipStructure = new IPStructure();
        convert(source()).forEach(ipStructure::add);

        ipStructure.add("100.156.5.6");
        ipStructure.add("100.156.5.7");

        // Block of invalid IP-addresses:
        ipStructure.add("100.156.5.7as");
        ipStructure.add("100.156.5.-2");
        ipStructure.add("0.0.0.0");
        ipStructure.add("256.0.0.0");
        ipStructure.add("hello!");

        System.out.printf("ipStructure.contains(\"100.156.5.7\"): %b \n", ipStructure.contains("100.156.5.7")); // true

        System.out.println(ipStructure);

    }

}
