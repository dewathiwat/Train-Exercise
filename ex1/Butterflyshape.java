package ex1;

import java.util.ArrayList;
import java.util.List;

public class Butterflyshape {
    private int i;
    String icon = "+";
    String blankSpace = " ";
    Butterflyshape(int i) {
        this.i = i;
    }

    public void printButterfly() {
        List<String> arr = new ArrayList<>();
        
        for (int r = 1; r <= i - 1; r++) {
            arr.add(addIconAndBlankSpace(r));
        }
        arr.add(printCenterIcon()+"-"+printCenterIcon());
        for (int r = i - 1; r >= 1; r--) {
            arr.add(addIconAndBlankSpace(r));
        }
        for(String data:arr){
            System.out.println(data);
        }

    }
    private String addIconAndBlankSpace(int r){
        String area = "";
        area+=addIcon(r);
        for (int s = 1; s <= 2 * (i - r) + 1; s++) {
            area+=blankSpace;
        }
        area+=addIcon(r);
        return area;
    }
    private String addIcon(int r){
        String area = "";
        for (int d = 1; d <= r; d++) {
            area+=icon;
        }
        return area;
    }
    private String printCenterIcon(){
        String area = "";
        for (int j = 1; j <= i; j++) {
            area+=icon;
        }
        return area;
    }
}
