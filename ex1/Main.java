package ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int odd;
        int even;
        while (true) {
            System.out.print("โปรดกรอกตัวเลขคู่เพื่อแสดงค่า Diamond : ");
            odd = input.nextInt();
            if (odd % 2 == 1) {
                System.out.println("กรุณาลองอีกครั้ง");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("โปรดกรอกตัวเลขคี่เพื่อแสดงค่า Butterfly : ");
            even = input.nextInt();
            if (odd % 2 == 1) {
                System.out.println("กรุณาลองอีกครั้ง");
            } else {
                break;
            }
        }
        System.out.println("Diamond");
        printDiamond d3 = new printDiamond(odd);
        d3.printDiamond();
        System.out.println("Butterfly");
        printButterfly b4 = new printButterfly(even);
        b4.printButterfly();


    }
}
