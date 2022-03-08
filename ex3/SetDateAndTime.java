package ex3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SetDateAndTime {

    public List<String> SetDate(List<String> arrReadFile){
        List<String> arr = new ArrayList<>();
        int day = 1;
        int hourse = 9;
        int minutes = 0;
        int loop = 0;
        int yy = 0, mm = 0, dd = 0;
            for (String data :arrReadFile) {
                String line = data;
                String lastWord = line.replaceAll("^.*?(\\w+)\\W*$", "$1");
                String[] min = lastWord.split("min");
                int min1 = Integer.parseInt(min[0]);
                if (loop == 0) {
                    String[] time = line.split("-");
                    yy = Integer.parseInt(time[0]);
                    mm = Integer.parseInt(time[1]);
                    dd = Integer.parseInt(time[2]);
                    arr.add("Day#"+day+" "+LocalDate.of(yy, mm, dd)+"\n");
                    loop++;
                } else {
                    if (hourse == 12) {
                        arr.add(LocalTime.of(hourse, minutes)+ " " + "Lunch\n");
                        hourse++;
                    }
                    if (hourse == 16) {
                        arr.add(LocalTime.of(hourse, minutes)+ " " + "Networking Event \n");
                        day++;
                        dd++;
                        hourse = 9;
                        minutes = 0;
                        arr.add("Day#"+day+" "+LocalDate.of(yy, mm, dd)+"\n");
                    }
                    arr.add(LocalTime.of(hourse, minutes)+ " " + line+"\n");

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
        return arr;
    }
    
}
