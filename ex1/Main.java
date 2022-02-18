package ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int odd;
        int even;
        while (true) {
            System.out.print("โปรดกรอกตัวเลขคี่เพื่อแสดงค่า Diamond : ");
            odd = input.nextInt();
            if (odd % 2 == 0) {
                System.out.println("กรุณาลองอีกครั้ง");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("โปรดกรอกตัวเลขคู่เพื่อแสดงค่า Butterfly : ");
            even = input.nextInt();
            if (even % 2 == 1) {
                System.out.println("กรุณาลองอีกครั้ง");
            } else {
                break;
            }
        }
        System.out.println("Diamond");
        Diamondshape d3 = new Diamondshape(odd);
        d3.printDiamond();
        System.out.println("Butterfly");
        Butterflyshape b4 = new Butterflyshape(even);
        b4.printButterfly();

    }
}
