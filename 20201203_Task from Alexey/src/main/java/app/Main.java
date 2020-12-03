package app;

import java.awt.*;

public class Main {

    static Point[][] field;
    static int fieldSize = 0;

    public static void main(String[] args) {
        initializeMatrix();
        drawV1();
        drawV2();
//        drawV3(); // this method should be turned off when testing drawV4()
        // drawV3() in some way conflicts with drawV4(), but I have found the reason yet.
        drawV4();
    }

    public static void drawField(Point[][] field) {
        int length = field.length;
        Point currentPoint;

        for (int j = 0; j < length; j++) {
            for (int k = 0; k < length; k++) {
                currentPoint = field[j][k];
                System.out.print(" " + "X:" + (int) currentPoint.getX() + " Y:" + (int) currentPoint.getY() + " |");
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

        drawField(field);
    }

    public static void drawV1() {
        System.out.println("-------------------------------------------");
        System.out.println("DRAW V1:");
        int row = 0;
        int col = 0;
        Point currentPoint;
        for (int i = 0; i < fieldSize * fieldSize; i++) {
            row = (int) (i / fieldSize);    // rows represent Y-coordinate
            col = i % fieldSize;            // columns represent X-coordinate

            currentPoint = field[row][col];
            // when retrieving an elem of an array we have to specify ROW first, COL second
            System.out.print(printPoint(currentPoint));
            if ((i + 1) % fieldSize == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void drawV2() {
        System.out.println("-------------------------------------------");
        System.out.println("DRAW V2:");
        int row = 0;
        int col = 0;
        Point currentPoint;

        int colMirrored = 0;
        for (int i = 0; i < fieldSize * fieldSize; i++) {
            row = (int) (i / fieldSize);
            col = i % fieldSize;
            if (row % 2 == 0) {
                currentPoint = field[row][col];
                System.out.print(printPoint(currentPoint));
            } else if (row % 2 != 0) {
                colMirrored = fieldSize - col - 1;
                currentPoint = field[row][colMirrored];
                System.out.print(printPoint(currentPoint));
            }
            if ((i + 1) % fieldSize == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void drawV3() {
        System.out.println("-------------------------------------------");
        System.out.println("DRAW V3:");
        int length = field.length;

        Point leftTopBorder = field[1][0];
        Point rightTopBorder = field[0][length - 1];
        Point rightBottomBorder = field[length - 1][length - 1];
        Point leftBottomBorder = field[length - 1][0];

        int row = 0;
        int col = 0;
        Point currentPoint = field[row][col];
        System.out.print(printPoint(currentPoint));
        String moveDirection = "leftToRight";

        for (int i = 0; i < fieldSize * fieldSize - 1; i++) {

            switch (moveDirection) {
                case "leftToRight":
                    col = col + 1;
                    break;
                case "topToBottom":
                    row = row + 1;
                    break;
                case "rightToLeft":
                    col = col - 1;
                    break;
                case "bottomToTop":
                    row = row - 1;
                    break;
            }
            currentPoint = field[row][col];
            System.out.print(printPoint(currentPoint));

            if (currentPoint.equals(rightTopBorder)) {
                moveDirection = "topToBottom";
                System.out.println("Changed direction: " + moveDirection);
                rightTopBorder.setLocation(field[row + 1][col - 1]);
            } else if (currentPoint.equals(rightBottomBorder)) {
                moveDirection = "rightToLeft";
                System.out.println("Changed direction: " + moveDirection);
                rightBottomBorder.setLocation(field[row - 1][col - 1]);
            } else if (currentPoint.equals(leftBottomBorder)) {
                moveDirection = "bottomToTop";
                System.out.println("Changed direction: " + moveDirection);
                leftBottomBorder.setLocation(field[row - 1][col + 1]);
            } else if (currentPoint.equals(leftTopBorder)) {
                moveDirection = "leftToRight";
                System.out.println("Changed direction: " + moveDirection);
                leftTopBorder.setLocation(field[row + 1][col + 1]);
            }
        }
    }

    public static void drawV4() {
        System.out.println("-------------------------------------------");
        System.out.println("DRAW V4:");

        int row = 0;
        int col = 0;
        Point currentPoint = field[row][col];
        System.out.print(printPoint(currentPoint));
        String moveDirection = "leftToRight";

        for (int i = 0; i < fieldSize * fieldSize - 1; i++) {

            switch (moveDirection) {
                case "leftToRight":
                    col = col + 1;
                    moveDirection = row == 0 ? "rightTopToLeftBottom" : "leftBottomToRightTop";
                    //this case works only for 1 cell and we have to change direction
                    break;
                case "rightTopToLeftBottom":
                    col = col - 1;
                    row = row + 1;
                    if (col == 0 && row + 1 < fieldSize) moveDirection = "topToBottom";
                    if (row == fieldSize - 1) moveDirection = "leftToRight";
                    break;
                case "topToBottom": //OK
                    row = row + 1;
                    moveDirection = col == 0 ? "leftBottomToRightTop" : "rightTopToLeftBottom";
                    //this case works only for 1 cell and we have to change direction
                    break;
                case "leftBottomToRightTop":
                    col = col + 1;
                    row = row - 1;
                    if (row == 0 && col + 1 <= fieldSize) moveDirection = "leftToRight";
                    if (col == fieldSize - 1) moveDirection = "topToBottom";
                    break;
            }

            currentPoint = field[row][col];
            System.out.print(printPoint(currentPoint));
        }
    }

    public static String printPoint(Point p) {
        String result;
        result = " " + "X:" + (int) p.getX() + " Y:" + (int) p.getY() + " |";
        return result;
    }
}
