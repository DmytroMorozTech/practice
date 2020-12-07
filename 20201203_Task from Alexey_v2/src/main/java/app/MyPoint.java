package app;

import java.awt.*;

public class MyPoint extends Point {

    Point activeP;
    int direction;
    int fieldSize;

    public MyPoint() {
        this.activeP = new Point(0, 0);
        this.direction = 0;
        this.fieldSize = Main.fieldSize;
    }

    public double getCurrentX() {
        return activeP.getX();
    }

    public double getCurrentY() {
        return activeP.getY();
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

    private MyPoint c(int col) {
        this.activeP.setLocation(activeP.x + col, activeP.y);
        return this;
    }

    private MyPoint r(int row) {
        this.activeP.setLocation(activeP.x, activeP.y + row);
        return this;
    }

    private MyPoint dir(int newDir) {
        this.direction = newDir;
        return this;
    }

    private boolean isColFirst() {
        return activeP.x == 0;
    }

    private boolean isRowLast() {
        return activeP.y == fieldSize - 1;
    }

    private boolean isRowFirst() {
        return activeP.y == 0;
    }

    private boolean isColLast() {
        return activeP.x == fieldSize - 1;
    }
}
