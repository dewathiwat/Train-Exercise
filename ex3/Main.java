package ex3;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        String readPathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3/TextFile.txt";// กรอกที่อยู่ไฟล์ที่ต้องการ input
        String writePathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3/WriteFile.txt";//กรอกที่อยู่ไฟล์ที่ต้องการ output 
        
        ReadFile readFile = new ReadFile();
        SetDateAndTime setDate = new SetDateAndTime();
        WriteFile writeFile = new WriteFile();


        List<String> arrReadFile = readFile.readFile(readPathFile);
        List<String> arr = setDate.SetDate(arrReadFile);
        arr.forEach(System.out::print);

        writeFile.whenWriteStringUsingBufferedWritter_thenCorrect(arr,writePathFile);
        
    }

}
