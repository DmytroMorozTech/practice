package Ema_s_Supercomputer;
// https://www.hackerrank.com/challenges/two-pluses/problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TwoPluses {
    final static int OCCUPIED = 1;
    final static int FREE = 0;

    static int delta(int size) {
        return (size -1) / 2;
    }

    static boolean doesFitH(int[][] grid, int size, int cx, int cy) {
        int delta = delta(size);
        return IntStream.rangeClosed(cx - delta, cx + delta)
                .allMatch(x -> grid[cy][x] == FREE);
    }

    static boolean doesFitV(int[][] grid, int size, int cx, int cy) {
        int delta = delta(size);
        return IntStream.rangeClosed(cy - delta, cy + delta)
                .allMatch(y -> grid[y][cx] == FREE);
    }

    // size is ODD
    static boolean doesFit(int[][] grid, int size, int x, int y) {
        int delta = delta(size);
        int centerX = x + delta;
        int centerY = y + delta;
        return doesFitH(grid, size, centerX, centerY)
                && doesFitV(grid, size, centerX, centerY);
    }

    static void mark(int[][] grid, int size, int x, int y) {
        int delta = delta(size);
        int cx = x + delta;
        int cy = y + delta;
        IntStream.rangeClosed(cy - delta, cy + delta)
                .forEach(yCoord -> grid[yCoord][cx] = OCCUPIED);
        IntStream.rangeClosed(cx - delta, cx + delta)
                .forEach(xCoord -> grid[cy][xCoord] = OCCUPIED);
    }

    static void release(int[][] grid, int size, int x, int y) {
        int delta = delta(size);
        int cx = x + delta;
        int cy = y + delta;
        IntStream.rangeClosed(cy - delta, cy + delta)
                .forEach(yCoord -> grid[yCoord][cx] = FREE);
        IntStream.rangeClosed(cx - delta, cx + delta)
                .forEach(xCoord -> grid[cy][xCoord] = FREE);
    }

    public static int[][] convert(List<String> grid) {
        int h = grid.size();
        int w = grid.get(0).length();
        int[][] data = new int[h][w];
        IntStream.range(0, h).forEach(y ->
                IntStream.range(0, w).forEach(x ->
                        data[y][x] = grid.get(y).charAt(x) == 'G' ? FREE : OCCUPIED
                ));
        return data;
    }

    static class Pos {
        private final Integer x1;
        private final Integer y1;
        private final Integer x2;
        private final Integer y2;
        private final Integer size1;
        private final Integer size2;
        private Integer product;

        public Pos(Integer x1, Integer y1, Integer x2, Integer y2, Integer size1, Integer size2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.size1 = size1;
            this.size2 = size2;
        }

        public Integer getProduct() {
            return getAreaOfPlus(size1) * getAreaOfPlus(size2);
        }

        private Integer getAreaOfPlus(Integer sizeOfSegment) {
            return sizeOfSegment * 2 - 1;
        }
    }

//  static void print2DimArray(int[][] arr) {
//    for (int[] row: arr) {
//      for (int i = 0; i< row.length; i++) {
//        System.out.printf("%d ", row[i]);
//      }
//      System.out.print("\n");
//    }
//  }

    public static int twoPluses(List<String> grid0) {
        final int[][] grid = convert(grid0);
//    print2DimArray(grid);
        final int H = grid.length;
        final int W = grid[0].length;
        final int MAXPLUS0 = Math.min(H, W);
        final int MAXPLUS = MAXPLUS0 % 2 != 0 ? MAXPLUS0 : MAXPLUS0 - 1;

        Pos pos = IntStream.rangeClosed(1, MAXPLUS)
                .filter(size1 -> size1 % 2 > 0).boxed()// 1 3 5 7 9 11 ...
                .flatMap(size1 ->
                        IntStream.rangeClosed(0, W - size1).boxed()
                            .flatMap(x1 ->
                                IntStream.rangeClosed(0, H - size1).boxed()
                                    .flatMap(y1 ->
                                        IntStream.rangeClosed(1, MAXPLUS)
                                            .filter(size2 -> size2 % 2 > 0).boxed()
                                            .flatMap(size2 ->
                                                    IntStream.rangeClosed(0, W - size2).boxed()
                                                        .flatMap(x2 ->
                                                            IntStream.rangeClosed(0, H - size2).boxed()
                                                                .flatMap(y2 -> {
                                                                    if (doesFit(grid, size1, x1, y1)) {
                                                                        mark(grid, size1, x1, y1);
                                                                        if (doesFit(grid, size2, x2, y2)) {
                                                                            release(grid, size1, x1, y1);
                                                                            return Stream.of(new Pos(x1, y1, x2, y2, size1, size2));
                                                                        }
                                                                        release(grid, size1, x1, y1);
                                                                        return Stream.empty();
                                                                    }
                                                                    return Stream.empty();
                                                                })
                                                        )
                                                    )
                                    )
                            )
                )
                .max(Comparator.comparingInt(Pos::getProduct))
                .get();
        return pos.getProduct();
    }

    public static void main(String[] args) {
        List<String> sampleInput0 = Arrays.asList(
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
        );
        // expected output -> 5

        List<String> sampleInput1 = Arrays.asList(
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB"
        );
        // expected output -> 25

        List<String> sampleInput2 = Arrays.asList(
                "GBBGGBGGBBGGGB",
                "GBBGGBGGBBGGGB",
                "GBBGGBGGBBGGGB",
                "GBBGGBGGBBGGGB",
                "GGGGGGGGGGGGGG",
                "GBBGGBGGBBGGGB",
                "GGGGGGGGGGGGGG",
                "GBBGGBGGBBGGGB",
                "GBBGGBGGBBGGGB",
                "GGGGGGGGGGGGGG",
                "GGGGGGGGGGGGGG",
                "GGGGGGGGGGGGGG",
                "GBBGGBGGBBGGGB"
        );
        // expected output -> 225

        int output0 = twoPluses(sampleInput0);
        System.out.println(output0);

        int output1 = twoPluses(sampleInput1);
        System.out.println(output1);

        int output2 = twoPluses(sampleInput2);
        System.out.println(output2);
    }

}
