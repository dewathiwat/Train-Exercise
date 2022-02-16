package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class printDiamond {

    private int i = 0;

    printDiamond(int i) {
        this.i = i;

    }

    public void printDiamond() {
        String icon = "+";
        String blankSpace = " ";
        String area = "";
        int space = i / 2;
        List arr = new ArrayList<>();
        for (int k = 1; k <= i; k++) {
            if (k % 2 == 1) {
                for (int c = 1; c <= space; c++) {
                    area += blankSpace;
                }
                for (int c = 1; c <= k; c++) {
                    area += icon;
                }
                arr.add(area);
                area="";
                space--;
            }

        }
        Collections.reverse(arr);
        arr.forEach(System.out::println);
        
    }
    

}
