package ex2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("กรุณากรอกตัวเลข ตัวเลขที่สามารถกรอกได้คือ 1-50 ");
        System.out.println("เลขที่กรอกถ้าเป็นเลขคี่จะแสดง Diamond ถ้าเป็นเลขคู่จะแสดง Butterfly ");
        while (true) {
            System.out.print("โปรดกรอกตัวเลข : ");
            number = input.nextInt();
            if (0 < number && number <= 50) {
                if (number % 2 != 0) {
                    System.out.println("Print diamond shape follow by input number.");
                    Diamondshape d3 = new Diamondshape(number);
                    d3.printDiamond();
                } else {
                    System.out.println("Print butterfly shape follow by input number.");
                    Butterflyshape b4 = new Butterflyshape(number);
                    b4.printButterfly();
                }
                break;
            } else {
                System.out.println("ตัวเลขที่สามารถกรอกได้คือ 1-50 กรุณาลอกอีกครั้ง");
            }

        }

    }

}
