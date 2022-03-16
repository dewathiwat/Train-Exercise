package ex3v2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SetDateAndTime {

    public List<String> SetDate(List<FileModel> fileRead) {
        List<String> arr = new ArrayList<>();
        LocalTime time = LocalTime.of(9, 0);
        LocalDate date = LocalDate.now();
        int day = 1;
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int loop = 0;
        for (FileModel data : fileRead) {
            int hours = data.getTime() / 60;
            int minute = data.getTime() % 60;
            if (loop == 0) {
                String[] dateSplit = data.getTextLine().split("-");
                date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]),
                        Integer.parseInt(dateSplit[2]));
                date = checkHoliday(date);
                arr.add("Day " + day + " - " + dateFormat.format(checkHoliday(date)));

            } else {
                if (time.equals(LocalTime.NOON)) {
                    arr.add(timeFormat.format(time) + " Lunch");
                    time = time.plusHours(1);
                }
                if (time.plusHours(hours).plusMinutes(minute).isAfter(LocalTime.of(17, 0))) {
                    arr.add(timeFormat.format(time) + " Networking Event\n");
                    time = LocalTime.of(9, 0);
                    date = date.plusDays(1);
                    date = checkHoliday(date);
                    day++;
                    arr.add("Day " + day + " - " + dateFormat.format(date));
                }
                arr.add(timeFormat.format(time) + " " + data.getTextLine());
                time = time.plusHours(hours).plusMinutes(minute);
                if (fileRead.size() - 1 == loop) {
                    arr.add(timeFormat.format(time) + " Networking Event\n");
                }
            }
            loop++;
        }
        return arr;
    }

    public LocalDate checkHoliday(LocalDate date) {
        if (date.getDayOfWeek().getValue() == 6) {
            date = date.plusDays(2);
        } else if (date.getDayOfWeek().getValue() == 7) {
            date = date.plusDays(1);
        }
        return date;
    }

}
