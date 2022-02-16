package ex2;

import java.util.Stack;


public class Diamondshape {

    private int i;

    Diamondshape(int i) {
        this.i = i;

    }

    public void printDiamond() {
        String icon = "+";
        String blankSpace = " ";
        String area = "";
        Stack<String> stack = new Stack<>();
        int space = i / 2;
        for (int k = 0; k <= i; k++) {
            if (k % 2 != 0) {
                for (int c = 0; c < space; c++) {
                    area += blankSpace;// addBlankSpace to area
                }
                for (int c = 0; c < k; c++) {
                    area += icon;// addIcon to area
                }
                stack.push(area);// add area to stack
                area = "";
                space--;
            }
        }
        stack.stream().forEach(System.out::println);// print half top diamond
        stack.pop();
        Reverse.reverse(stack).stream().forEach(System.out::println);// print half under diamond
    }

   

    

}
