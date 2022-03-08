package ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {

    public void whenWriteStringUsingBufferedWritter_thenCorrect(List<String> arrReadFile,String writePathFile) {
  
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePathFile))) {
        for(String data:arrReadFile){
            writer.write(data);
        }
        writer.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
    
}
