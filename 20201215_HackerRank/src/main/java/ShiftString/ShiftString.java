package ShiftString;
// We should create a function that will shift the given String to the given amount of chars to the
// left and then to the right.

public class ShiftString {
    public static void main(String[] args) {
        System.out.println(shift("Hello", 3, 3)); // Hello
        System.out.println(shift("Hello", 3, 4)); // oHell
        System.out.println(shift("Hello", 3, 6)); // lloHe
        System.out.println(shift("Hello", 1000, 1003)); // lloHe
        System.out.println(shift("Hello", 1_000_032, 1_000_030)); // lloHe
        System.out.println(shift("Hello", 1_999_999, 2_999_998)); // elloH
    }

    static public String shift(String orig, int left, int right) {
        int sLength = orig.length();
        if (left % sLength == 0 && right % sLength == 0) return orig;

        String moveDir = (right - left) > 0 ? "right" : "left";

        int delta = Math.abs(right - left) % sLength;
        switch (moveDir) {
            case "right":
                String start = orig.substring(sLength - delta);
                String end = orig.substring(0, sLength - delta);
                return start.concat(end);
            case "left":
                String start1 = orig.substring(delta);
                String end1 = orig.substring(0, delta);
                return start1.concat(end1);
            default:
                return orig;
        }
    }
}
