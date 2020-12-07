package app;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    static Point[][] field;
    static ArrayList<String> fieldV4 = new ArrayList<>();
    static int fieldSize = 0;

    public static void main(String[] args) {
        initializeMatrix();
        drawV4();
    }

    public static void drawField2D(Point[][] field) {
        int length = field.length;
        Point currentPoint;

        for (Point[] points : field) {
            for (int k = 0; k < length; k++) {
                currentPoint = points[k];
                System.out.print(convertPointToStr(currentPoint));
                if (k == length - 1) System.out.print("\n");
            }
        }
    }

    public static void initializeMatrix() {
        fieldSize = Console.readNumber("Please enter the size of game field: ", 4, 30);
        field = new Point[fieldSize][fieldSize];
        System.out.println("Initially generated BASIC FIELD:");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < fieldSize; i++) {
            // i represents rows (in another words it represents Y-coordinate);
            for (int j = 0; j < fieldSize; j++) {
                // j represents columns (in another words it represents X-coordinate);
                field[i][j] = new Point(j, i); // when creating a Point we have to pass (x,y)
                // coordinates of the new Point to it.
            }
        }

        drawField2D(field);
    }

    public static void drawV4() {
        String s;
        MyPoint point = new MyPoint();
        fieldV4.add("X:0 Y:0 |");

        System.out.println("------------------------------------");
        System.out.println("DRAW V4:");

        for (int i = 0; i < fieldSize * fieldSize - 1; i++) {
            s = convertMyPointToStr(point.nextStep());
            fieldV4.add(s);
        }

        for (String str : fieldV4) {
            System.out.print(str);
        }
    }

    public static String convertMyPointToStr(MyPoint p) {
        return " X:" + (int) p.getCurrentX() + " Y:" + (int) p.getCurrentY() + " |";
    }

    public static String convertPointToStr(Point p) {
        return " X:" + (int) p.getX() + " Y:" + (int) p.getY() + " |";
    }
}