package ex3v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<FileModel> ReadFile(String pathFile){
        List<FileModel> arr = new ArrayList<>();
            try (BufferedReader input = new BufferedReader(new FileReader(pathFile))) {
                String currentLine;
            while ((currentLine = input.readLine()) != null) {
                FileModel fileModel = new FileModel();
                String[] min =  currentLine.replaceAll("^.*?(\\w+)\\W*$", "$1").split("min");
                int time = Integer.parseInt(min[0]);
                fileModel.setTime(time);
                fileModel.setTextLine(currentLine);
                arr.add(fileModel);
            }  
            } catch (IOException e) {
                e.printStackTrace();
            }
        return arr;
    }
}
