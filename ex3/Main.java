package ex3;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String fileName = "/Users/athiwatjansomwong/Train-Exercise/ex3/TextFile.txt";
        int Day = 1;
        int hourse = 9;
        int minutes = 0;
        int loop = 0;
        int yy = 0, mm = 0, dd = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String lastWord = line.replaceAll("^.*?(\\w+)\\W*$", "$1");
                String[] min = lastWord.split("min");
                int min1 = Integer.parseInt(min[0]);

                if (loop == 0) {
                    String[] time = line.split("-");
                    yy = Integer.parseInt(time[0]);
                    mm = Integer.parseInt(time[1]);
                    dd = Integer.parseInt(time[2]);

                    System.out.println(LocalDate.of(yy, mm, dd));
                    loop++;
                } else {
                    if (hourse == 12) {
                        System.out.println(LocalTime.of(hourse, minutes)+ " " + "Lunch \n");
                        hourse++;
                    }
                    if (hourse == 16) {
                        System.out.println(LocalTime.of(hourse, minutes)+ " " + "Networking Event \n");
                        Day++;
                        dd++;
                        hourse = 9;
                        minutes = 0;
                    System.out.println(LocalDate.of(yy, mm, dd));
                        

                    }
                    System.out.println(LocalTime.of(hourse, minutes)+ " " + line);

                    if (min1 >= 60) {
                        minutes = minutes + min1 - 60;
                        hourse++;
                    } else if (min1 < 60) {
                        minutes = minutes + min1;
                    }
                    if (minutes >= 60) {
                        minutes = minutes - 60;
                        hourse++;
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
