package ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {

    public void whenWriteStringUsingBufferedWritter_thenCorrect(List<String> arrReadFile,String writePathFile) {
  
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePathFile))) {
        for(String data:arrReadFile){
            writer.write(data);
        }
        writer.close();
    } catch (Exception e) {
        
        e.printStackTrace();
    }
}
    
}
