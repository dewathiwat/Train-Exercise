package ex3v2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String readPathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3/TextFile.txt";// กรอกที่อยู่ไฟล์ที่ต้องการ input
        String writePathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3v2";//กรอกที่อยู่ไฟล์ที่ต้องการ output
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        SetDateAndTime setDateAndTime = new SetDateAndTime();
        List<FileModel> fileRead =readFile.ReadFile(readPathFile);
        List<String> timeLine = setDateAndTime.SetDate(fileRead);
        writeFile.whenWriteStringUsingBufferedWritter_thenCorrect(timeLine, writePathFile);
    }
}
