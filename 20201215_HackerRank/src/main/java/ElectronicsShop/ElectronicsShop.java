package ElectronicsShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectronicsShop {

    public static void main(String[] args) {
        int b = 60;
        int[] keybords = {40, 50, 60};
        int[] drives = {5, 8, 12};

        int result = getMoneySpent(keybords, drives, b);
        System.out.println(result);
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int result = -1;

        List<Integer> priceCombinations = new ArrayList<>();
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                priceCombinations.add(keyboard + drive);
            }
        }
        Collections.sort(priceCombinations);
        for (int combination : priceCombinations) {
            result = combination <= b ? combination : result;
        }
        return result;
    }
}
