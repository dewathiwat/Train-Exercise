package ex3;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        String readPathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3/TextFile.txt";//input location input file
        String writePathFile = "/Users/athiwatjansomwong/Train-Exercise/ex3/WriteFile.txt";//input location output file
        
        ReadFile readFile = new ReadFile();
        SetDateAndTime setDate = new SetDateAndTime();
        WriteFile writeFile = new WriteFile();


        List<String> arrReadFile = readFile.readFile(readPathFile);
        List<String> arr = setDate.SetDate(arrReadFile);

        writeFile.whenWriteStringUsingBufferedWritter_thenCorrect(arr,writePathFile);
        
    }

}
