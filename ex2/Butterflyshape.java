package ex2;

import java.util.Stack;

public class Butterflyshape {
    private int i;

    Butterflyshape(int i) {
        this.i = i;
    }

    public void printButterfly() {
        String icon = "+";
        String blankSpace = " ";
        String area = "";
        String backblankSpace = "";
        Stack<String> stack = new Stack<>();
        for (int r = 1; r <= i - 1; r++) {
            for (int d = 1; d <= r; d++) {
                area += icon;
                backblankSpace = area;
            }
            for (int s = 1; s <= 2 * (i - r) + 1; s++) {
                area += blankSpace;
            }
            area += backblankSpace;
            stack.push(area);
            area = "";
        }
        for (int j = 1; j <= i; j++) {
            area += icon;
        }
        area += '-' + area;
        stack.push(area);
        area = "";
        stack.stream().forEach(System.out::println);// print half top butterfly
        stack.pop();
        for(int i=stack.size();i>0;i--){
            System.out.println(stack.pop());// print half under butterfly
        }
    }
}
