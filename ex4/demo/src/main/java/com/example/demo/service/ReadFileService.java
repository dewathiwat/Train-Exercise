package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DateListModel;
import com.example.demo.model.TitleMinModel;

@Service
public class ReadFileService {
    public DateListModel ReadFile(MultipartFile pathFile) {
        DateListModel dateListModel = new DateListModel();
        List<TitleMinModel> arr = new ArrayList<>();
        int loop=0;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(pathFile.getInputStream()))){
            String line;

            while ((line = input.readLine()) != null) {
                if(loop==0){
                    dateListModel.setDate(line);
                    loop++;
                }else {
                    TitleMinModel titleMinModel = new TitleMinModel();
                    String[] min = line.replaceAll("^.*?(\\w+)\\W*$", "$1").split("min");
                    int time = Integer.parseInt(min[0]);
                    titleMinModel.setMin(time);
                    titleMinModel.setTitle(line);
                    arr.add(titleMinModel);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateListModel.setList(arr);
        return dateListModel;
    }
}
