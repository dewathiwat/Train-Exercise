package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DateListModel;
import com.example.demo.model.DayDateListModel;
import com.example.demo.model.TimeTitleMinModel;
import com.example.demo.model.TitleMinModel;

@Service
public class SetDateAndTimeService {
    public List<DayDateListModel> SetDate(DateListModel fileRead) {
        List<DayDateListModel> arr = new ArrayList<>();
        List<TimeTitleMinModel> listTime = new ArrayList<>();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy").withChronology(ThaiBuddhistChronology.INSTANCE);
        String[] dateSplit = fileRead.getDate().split("-");
        LocalTime time = LocalTime.of(9, 0);
        LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]),
                Integer.parseInt(dateSplit[2]));
        date = checkHoliday(date);
        int day = 1;
        int loop = 0;

        for (TitleMinModel data : fileRead.getList()) {
            int hours = data.getMin() / 60;
            int minute = data.getMin() % 60;
            DayDateListModel dayDateListModel = new DayDateListModel();
            dayDateListModel.setDateTh(dateFormat.format(date));
            dayDateListModel.setDay(day);
                if (time.equals(LocalTime.NOON)) {
                    listTime.add(lunchTime(timeFormat.format(time)));
                    time = time.plusHours(1);
                }else if (time.plusHours(hours).plusMinutes(minute).isAfter(LocalTime.of(17, 0))) {
                    listTime.add(networkingEvenTime(timeFormat.format(time)));
                    dayDateListModel.setList(listTime);
                    arr.add(dayDateListModel);
                    listTime = new ArrayList<>();
                    time = LocalTime.of(9, 0);
                    date = date.plusDays(1);
                    date = checkHoliday(date);
                    day++;
                }
                    listTime.add(timeTitleMin(timeFormat.format(time),data.getTitle(),data.getMin()));
                    time = time.plusHours(hours).plusMinutes(minute);
                    if (fileRead.getList().size() - 1 == loop) {
                        listTime.add(networkingEvenTime(timeFormat.format(time)));
                        dayDateListModel.setList(listTime);
                        arr.add(dayDateListModel);
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

    private TimeTitleMinModel lunchTime(String time){
        TimeTitleMinModel timeTitleMinModel = new TimeTitleMinModel();
        timeTitleMinModel.setTime(time);
        timeTitleMinModel.setMin(60);
        timeTitleMinModel.setTitle("Lunch");
        return timeTitleMinModel;
    }
    private TimeTitleMinModel networkingEvenTime(String time){
        TimeTitleMinModel timeTitleMinModel = new TimeTitleMinModel();
        timeTitleMinModel.setTime(time);
        timeTitleMinModel.setTitle("Networking Event");
        return timeTitleMinModel;
    }
    private TimeTitleMinModel timeTitleMin(String time,String title,Integer min){
        TimeTitleMinModel timeTitleMinModel = new TimeTitleMinModel();
        timeTitleMinModel.setTime(time);
        timeTitleMinModel.setTitle(title);
        timeTitleMinModel.setMin(min);
        return timeTitleMinModel;
    }
}