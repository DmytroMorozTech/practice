package app;

import java.awt.*;

public class MyPoint {

    Point activeP;
    int direction;
    int fieldSize;

    public MyPoint() {
        this.activeP = new Point(0, 0);
        this.direction = 0;
        this.fieldSize = Main.fieldSize;
    }

    public MyPoint nextStep() {
        switch (direction) {
            case 1:
                if (isRowLast()) return c(1).dir(2);
                else if (isColFirst()) return r(1).dir(2);
                else return r(1).c(-1); // the main vector for case 1

            case 2:
                if (isColLast()) return r(1).dir(1);
                else if (isRowFirst()) return c(1).dir(1);
                else return r(-1).c(1); // the main vector for case 2

            default:
                return c(1).dir(1);
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

    public int getX() {
        return this.activeP.x;
    }

    public int getY() {
        return this.activeP.y;
    }
}
