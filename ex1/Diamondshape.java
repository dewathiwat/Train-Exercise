package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diamondshape {

    private int i = 0;
    String icon = "+";
    String blankSpace = " ";

    Diamondshape(int i) {
        this.i = i;

    }

    public void printDiamond() {
        List<String> arr = new ArrayList<>();
        int space = i / 2;
        for (int k = 1; k <= i; k++) {
            if (k % 2 == 1) {
                arr.add(addIconAndBlankSpace(space,k));
                space--;
            }

        }
        space = 1;
        if (i != 1) {
            for (int k = i - 1; k > 0; k--) {
                if (k % 2 == 1) {
                arr.add(addIconAndBlankSpace(space,k));
                    space++;
                }

            }
        } else {
        }
        for(String data:arr){
            System.out.println(data);
        }
    }


    private String addIconAndBlankSpace(int space,int k) {
        String area = "";
        for (int c = 0; c <= space; c++) {
            area+=blankSpace;
        }
        for (int c = 0; c < k; c++) {
           area+=icon;
        }

        return area;
    }

}
