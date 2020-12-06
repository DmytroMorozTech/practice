package app;

import java.awt.*;

public class MyPoint extends Point {

    Point activePoint;
    int direction;
    int fieldSize;

    public double getCurrentX() {
        return activePoint.getX();
    }

    public double getCurrentY() {
        return activePoint.getY();
    }

    private double currentX; // col
    private double currentY; // row

    public MyPoint() {
        this.activePoint = new Point(0, 0);
        this.direction = 0;
        this.fieldSize = Main.fieldSize;
    }

    public MyPoint nextStep() {
        switch (direction) {
            case 1:
                if (isRowLast()) return this.c(1).dir(2);
                else if (isColFirst()) return this.r(1).dir(2);
                else return this.r(1).c(-1); // the main vector for case 1

            case 2:
                if (isColLast()) return this.r(1).dir(1);
                else if (isRowFirst()) return this.c(1).dir(1);
                else return this.r(-1).c(1); // the main vector for case 2

            default:
                return this.c(1).dir(1);
        }
    }

    public MyPoint c(int col) {
        currentX = activePoint.getX();
        currentY = activePoint.getY();
        this.activePoint.setLocation(currentX + col, currentY);
        return this;
    }

    public MyPoint r(int row) {
        currentX = activePoint.getX();
        currentY = activePoint.getY();
        this.activePoint.setLocation(currentX, currentY + row);
        return this;
    }

    private MyPoint dir(int newDir) {
        this.direction = newDir;
        return this;
    }

    private boolean isColFirst() {
        return activePoint.getX() == 0;
    }

    private boolean isRowLast() {
        return activePoint.getY() == fieldSize - 1;
    }

    private boolean isRowFirst() {
        return activePoint.getY() == 0;
    }

    private boolean isColLast() {
        return activePoint.getX() == fieldSize - 1;
    }
}
