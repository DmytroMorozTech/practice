package enumPractice;

public class Enum {
    enum Transport {
        PLANE, TRAIN, AUTO, RAIL
    }

    public static void main(String[] args) {
//        Transport allTransports [] = Transport.values();
//
//        for (Transport t: allTransports) {
//            System.out.print(t + " |");
//            System.out.println(t.ordinal());
//            System.out.println(t instanceof Transport);
//        }

        Animal animal = Animal.CAT;
        System.out.println(animal.getTranslation());
    }
}
